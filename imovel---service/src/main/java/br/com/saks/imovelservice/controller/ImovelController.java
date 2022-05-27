/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.imovelservice.controller;

import br.com.saks.imovelservice.model.Cliente;
import br.com.saks.imovelservice.model.Imovel;
import br.com.saks.imovelservice.model.Interesse;
import br.com.saks.imovelservice.model.InteresseIdentity;
import br.com.saks.imovelservice.repository.ImovelRepository;
import br.com.saks.imovelservice.service.ClienteService;
import br.com.saks.imovelservice.service.InteresseService;
import br.com.saks.imovelservice.service.TipoImovelService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */
@RestController
@RequestMapping("/imovel")
public class ImovelController {
    
    @Autowired
    private ImovelRepository imovelRepository;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private InteresseService interesseService;
    
    @Autowired
    private TipoImovelService tipoImovelService;
    
    @GetMapping
    public List<Imovel> listarTodos() {
        return imovelRepository.findAll();
    }
    
    @GetMapping(value="/conjunto/{id}")
    public Imovel listarPeloIdConjunto(@PathVariable Long id) {
        Optional<Imovel> imovelResponse = imovelRepository.findById(id);
        Imovel imovel = imovelResponse.get();
        imovel.setTipoImovel(tipoImovelService.listarPeloId(imovel.getIdTipoImovel()));
        return imovel;
    }
    
    @GetMapping(value="/tipoimovel/{idTipoImovel}")
    public List<Imovel> listarPeloIdTipoImovel(@PathVariable Long idTipoImovel) {
        List<Imovel> imoveis = imovelRepository.findAll();
        List<Imovel> imovelTipo = new ArrayList<>();
        for(Imovel imovel : imoveis)
            if(Objects.equals(imovel.getIdTipoImovel(), idTipoImovel))
                imovelTipo.add(imovel);
        return imovelTipo;
    }
    
    @GetMapping(value="/{id}")
    public Imovel listarPeloId(@PathVariable Long id) {
        Optional<Imovel> imovelResponse = imovelRepository.findById(id);
        Imovel imovel = imovelResponse.get();
        imovel.setTipoImovel(tipoImovelService.listarPeloId(imovel.getIdTipoImovel()));
        List<Interesse> interesses;
        interesses = interesseService.listarPeloIdImovel(id);
        List<Cliente> clientes = new ArrayList<>();
        for(Interesse interesse : interesses) {
            InteresseIdentity interesseId = interesse.getInteresseIdentity();
            Cliente cliente = clienteService.listarPeloId(interesseId.getIdCliente());
            clientes.add(cliente);
        }
        imovel.setClientesInteresse(clientes);
        return imovel;
    }
    
    
    
    @PostMapping
    public Imovel adicionar(@RequestBody Imovel imovel) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        imovel.setDataCriacao(date);
        imovel.setStatus(1);
        return imovelRepository.save(imovel);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Imovel imovel) {
        return imovelRepository.findById(id)
                .map(record -> {
                    record.setTitulo(imovel.getTitulo());
                    record.setIdTipoImovel(imovel.getIdTipoImovel());
                    record.setDescricao(imovel.getDescricao());
                    record.setValor(imovel.getValor());
                    record.setStatus(imovel.getStatus());
                    
                    Imovel imovelUpdated = imovelRepository.save(record);
                    return ResponseEntity.ok().body(imovelUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return imovelRepository.findById(id)
                .map(record -> {
                    imovelRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
