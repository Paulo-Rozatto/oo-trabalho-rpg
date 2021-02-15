/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;

 /**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Classe para fazer ataques magicos
 */
public class AtackMagico extends Atack{
    
    private String nomeMagia;//Nome da magia
    private int PM;// pontos de mana para usar a magia

/**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Construtor
 */   
    public AtackMagico(String nomeMagia, int PM, int dano, int danoB, int numDados) {
        super(dano, danoB, numDados);
        this.nomeMagia = nomeMagia;
        this.PM = PM;
    }

    /**
     * @author MATHEUS NP
     * Data 14/02/21 ultima modfificação
     * Geters E Seters
     */
    public String getNomeMagia() {
        return nomeMagia;
    }

    public int getPM() {
        return PM;
    }
    
}