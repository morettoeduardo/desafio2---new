/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.interesseservice.controller;

import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import br.com.saks.interesseservice.repository.InteresseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */
@RestController
@RequestMapping("/interesse")
public class InteresseController {
    
    @Autowired
    private InteresseRepository interesseRepository;
    
    @GetMapping
    public List<Interesse> listarTodos() {
        return interesseRepository.findAll();
    }
    
    @GetMapping(value="/cliente/{idCliente}")
    public List<Interesse> listarPeloIdCliente(@PathVariable Long idCliente) {
        List<Interesse> interesseTodos = interesseRepository.findAll();
        List<Interesse> interessePorCliente = new ArrayList<>();   
        for(Interesse interesse : interesseTodos) {
            InteresseIdentity interesseId = interesse.getInteresseIdentity();
            if(Objects.equals(interesseId.getIdCliente(), idCliente))
                interessePorCliente.add(interesse);
        }    
        return interessePorCliente;
    }
    
    @GetMapping(value="/imovel/{idImovel}")
    public List<Interesse> listarPeloIdImovel(@PathVariable Long idImovel) {      
        List<Interesse> interesseTodos = interesseRepository.findAll();
        List<Interesse> interessePorImovel = new ArrayList<>();
        for(Interesse interesse : interesseTodos) {
            InteresseIdentity interesseId = interesse.getInteresseIdentity();
            if(Objects.equals(interesseId.getIdImovel(), idImovel))
                interessePorImovel.add(interesse);
        }
        return interessePorImovel;
    }
    
    @GetMapping(value = "/{idCliente}/{idImovel}")
    public Optional<Interesse> findByClienteImovel(@PathVariable Long idCliente, @PathVariable Long idImovel) {
        final InteresseIdentity identity = new InteresseIdentity(idCliente, idImovel);
        return interesseRepository.findById(identity);
    }
    
    @PostMapping
    public Interesse adicionar(@RequestBody InteresseIdentity interesseIdentity) {
        Interesse interesse = new Interesse();
        interesse.setInteresseIdentity(interesseIdentity);
        return interesseRepository.save(interesse);
    }
    
    @DeleteMapping(value="/{idCliente}/{idImovel}")
    public ResponseEntity deletar(@PathVariable Long idCliente, @PathVariable Long idImovel) {
        final InteresseIdentity identity = new InteresseIdentity(idCliente, idImovel);
        return interesseRepository.findById(identity)
            .map(record-> {
                interesseRepository.deleteById(identity);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    } 
}
