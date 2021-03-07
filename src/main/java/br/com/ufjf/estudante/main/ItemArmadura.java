/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;

/**
 *
 * @author mathe
 */
public class ItemArmadura extends Item{

    private String tipo;
    private int bonusDefesa;
    

    public ItemArmadura(String tipo, int bonusDefesa, String nome) {
        super(nome);
        this.tipo = tipo;
        this.bonusDefesa = bonusDefesa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }
    
    
}
