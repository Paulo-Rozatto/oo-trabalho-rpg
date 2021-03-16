/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
 */

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
        this.modelo = 0;//0 = consumivel, 1=arma, 2=armadura
    }

    public int getTipo() {
        return tipo;
    }

    public int getValorBonus() {
        return valorBonus;
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" + 
                "Tipo: " + this.tipo + "\n" + 
                "ValorBonus: " + this.valorBonus;
    }
}
