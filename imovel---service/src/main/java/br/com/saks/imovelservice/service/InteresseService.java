/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.imovelservice.service;

import br.com.saks.imovelservice.model.Interesse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author eduar
 */
@FeignClient(name="interesse-service")
public interface InteresseService {
    
    @GetMapping(value="/interesse/cliente/{idCliente}")
    List<Interesse> listarPeloIdImovel(@PathVariable("idCliente") Long idCliente);
}