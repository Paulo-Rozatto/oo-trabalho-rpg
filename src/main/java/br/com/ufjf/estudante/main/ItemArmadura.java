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
public class ItemArmadura extends Item{

    private String tipo;
    private int bonusDefesa;
    

    public ItemArmadura(String tipo, int bonusDefesa, String nome) {
        super(nome);
        this.tipo = tipo;
        this.bonusDefesa = bonusDefesa;
        this.modelo = 2;//0 = consumivel, 1=arma, 2=armadura
    }

    public String getTipo() {
        return tipo;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" + 
                "Tipo: " + this.tipo + "\n" + 
                "BonusDefesa: " + this.bonusDefesa;
    }
}
