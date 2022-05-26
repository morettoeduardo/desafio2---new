/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.tipoimovelservice.controller;

import br.com.saks.tipoimovelservice.model.TipoImovel;
import br.com.saks.tipoimovelservice.repository.TipoImovelRepository;
import br.com.saks.tipoimovelservice.service.ImovelService;
import java.util.List;
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
@RequestMapping("/tipoimovel")
public class TipoImovelController {
    
    @Autowired
    private TipoImovelRepository tipoImovelRepository;
    
    @Autowired
    private ImovelService imovelService;
    
    @GetMapping
    public List<TipoImovel> listarTodos() {
        return tipoImovelRepository.findAll();
    }
    
    @GetMapping(value="/{id}")
    public TipoImovel listarPeloId(@PathVariable Long id) {
        Optional<TipoImovel> tipoImovelResponse = tipoImovelRepository.findById(id);
        TipoImovel tipoImovel = tipoImovelResponse.get();
        tipoImovel.setImoveisRelacionados(imovelService.listarPeloIdTipoImovel(tipoImovel.getId()));
        return tipoImovel;
    }
    
    @PostMapping
    public TipoImovel adicionar(@RequestBody TipoImovel cliente) {
        return tipoImovelRepository.save(cliente);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody TipoImovel cliente) {
        return tipoImovelRepository.findById(id)
                .map(record -> {
                    record.setNome(cliente.getNome());
                    TipoImovel tipoImovelUpdated = tipoImovelRepository.save(record);
                    return ResponseEntity.ok().body(tipoImovelUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return tipoImovelRepository.findById(id)
                .map(record -> {
                    tipoImovelRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
}