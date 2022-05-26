/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.imovelservice.service;

import br.com.saks.imovelservice.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author eduar
 */
@FeignClient(name="cliente-service")
public interface ClienteService {
    
    @GetMapping(value="/cliente/conjunto/{id}")
    Cliente listarPeloId(@PathVariable("id") Long id);
}
