/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.clienteservice.model;

import static br.com.saks.clienteservice.controller.ClienteController.getSHA256;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Data;

/**
 *
 * @author eduar
 */
@Entity
@Data
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length=100)
    private String nome;
    
    @Column(nullable = false, length=200)
    private String email;
    
    @Column(nullable = false, length=200)
    private String senha;
    
    @Column(length=15)
    private String telefone;
    
    @Transient
    List<Imovel> imoveisInteresse;
    
    public void setSenha(String senha) {
        this.senha = getSHA256(senha);
    }
}
