/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.imovelservice.model;

/**
 *
 * @author eduar
 */
public class InteresseIdentity {
    private Long idCliente;
    private Long idImovel;

    public InteresseIdentity() {}

    public InteresseIdentity(Long idCliente, Long idImovel) {
        this.idCliente = idCliente;
        this.idImovel = idImovel;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Long idImovel) {
        this.idImovel = idImovel;
    }
}
