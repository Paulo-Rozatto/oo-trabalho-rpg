package br.com.ufjf.estudante.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathe
 */
public class Item {
    
    protected String nome;
    //0 = consumivel, 1=arma, 2=armadura
    protected int modelo;
    
    public Item(String nome) {
        this.nome = nome;
        this.modelo = -1;
    }

    public String getNome() {
        return nome;
    }

    public int getModelo() {
        return modelo;
    }
    
    
    
    
        
}
