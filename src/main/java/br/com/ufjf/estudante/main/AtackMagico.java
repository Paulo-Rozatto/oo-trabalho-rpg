/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;

 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Classe para fazer ataques magicos
 */
public class AtackMagico extends Atack{
    
    private String nomeMagia;//Nome da magia

/**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Construtor
 */
    public AtackMagico(String nomeMagia) {
        super();
        this.nomeMagia = nomeMagia;
    }
/**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Roda dano do ataque
 */
    public int rodaDano(int numFaces, int mod) {
        if (numFaces != 1) {
            return super.rodaDano(numFaces) + mod+((mod/2)-1);
        } else {
            return 0;
        }

    }
}