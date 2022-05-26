/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.clienteservice.service;

import br.com.saks.clienteservice.model.Imovel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author eduar
 */
@FeignClient(name="imovel-service")
public interface ImovelService {
    
    @GetMapping(value="/imovel/conjunto/{idImovel}")
    Imovel listarPeloId(@PathVariable("idImovel") Long idImovel);
}
