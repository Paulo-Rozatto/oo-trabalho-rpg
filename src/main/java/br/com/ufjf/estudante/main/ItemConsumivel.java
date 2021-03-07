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
public class ItemConsumivel extends Item{

    public int tipo;
    /*
    *1-Restaura vida(HP)
    *2-Restaura mana
    */
    public int valorBonus;

    public ItemConsumivel(int tipo, int valorBonus, String nome) {
        super(nome);
        this.tipo = tipo;
        this.valorBonus = valorBonus;
    }

    public int getTipo() {
        return tipo;
    }

    public int getValorBonus() {
        return valorBonus;
    }

   

    
    
}
