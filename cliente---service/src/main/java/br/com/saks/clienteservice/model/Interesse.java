/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.clienteservice.model;

/**
 *
 * @author eduar
 */
public class Interesse {
    InteresseIdentity interesseIdentity;

    public Interesse() {
    }

    public Interesse(InteresseIdentity interesseIdentity) {
        this.interesseIdentity = interesseIdentity;
    }

    public InteresseIdentity getInteresseIdentity() {
        return interesseIdentity;
    }

    public void setInteresseIdentity(InteresseIdentity interesseIdentity) {
        this.interesseIdentity = interesseIdentity;
    }
}
