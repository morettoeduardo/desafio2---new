/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.administradorservice.model;

import static br.com.saks.administradorservice.controller.AdministradorController.getSHA256;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author eduar
 */
@Entity
@Data
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length=100)
    private String nome;
    
    @Column(nullable = false, length=200)
    private String email;
    
    @Column(nullable = false, length=200)
    private String senha;
    
    @Column(length=1)
    private int status;
    
    public void setSenha(String senha){
        this.senha = getSHA256(senha);
    }
}
