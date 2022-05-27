/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.saks.interesseservice.repository;

import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eduar
 */
public interface InteresseRepository extends JpaRepository<Interesse, InteresseIdentity>{
    
}
