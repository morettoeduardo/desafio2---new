/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.imovelservice.service;

import br.com.saks.imovelservice.model.TipoImovel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author eduar
 */
@FeignClient(name="tipo-imovel-service")
public interface TipoImovelService {
    
    @GetMapping(value = "/tipoimovel/{idTipoImovel}")
    TipoImovel listarPeloId(@PathVariable("idTipoImovel") Long idTipoImovel);
}