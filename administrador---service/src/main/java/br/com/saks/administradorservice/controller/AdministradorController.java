/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.administradorservice.controller;

import br.com.saks.administradorservice.model.Administrador;
import br.com.saks.administradorservice.repository.AdministradorRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
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
@RequestMapping("/administrador")
public class AdministradorController {
    
    @Autowired
    private AdministradorRepository administradorRepository;
    
    @GetMapping
    public List<Administrador> listarTodos() {
        return administradorRepository.findAll();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Administrador> listarPeloId(@PathVariable Long id) {
        return administradorRepository.findById(id);
    }
    
    @PostMapping
    public Administrador adicionar(@RequestBody Administrador administrador) {
        return administradorRepository.save(administrador);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Administrador administrador) {
        return administradorRepository.findById(id)
                .map(record -> {
                    record.setNome(administrador.getNome());
                    record.setEmail(administrador.getEmail());
                    record.setSenha(administrador.getSenha());
                    record.setStatus(administrador.getStatus());
                    Administrador administradorUpdated = administradorRepository.save(record);
                    return ResponseEntity.ok().body(administradorUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return administradorRepository.findById(id)
                .map(record -> {
                    administradorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
     public static String getSHA256(String senha){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(senha.getBytes("utf8"));
	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }
    
}