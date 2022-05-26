/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.tipoimovelservice.repository;

import br.com.saks.tipoimovelservice.model.TipoImovel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eduar
 */
public interface TipoImovelRepository extends JpaRepository<TipoImovel, Long>{
    
}
