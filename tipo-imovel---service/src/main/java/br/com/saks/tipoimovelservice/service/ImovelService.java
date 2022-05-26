/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.tipoimovelservice.service;

import br.com.saks.tipoimovelservice.model.Imovel;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author eduar
 */
@FeignClient(name="imovel-service")
public interface ImovelService {
    
    @GetMapping(value = "/imovel/tipoimovel/{idTipoImovel}")
    List<Imovel> listarPeloIdTipoImovel(@PathVariable("idTipoImovel") Long idTipoImovel);
}