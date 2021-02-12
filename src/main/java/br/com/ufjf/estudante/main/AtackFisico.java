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
 * Classe para fazer ataques fisicos
 */
public class AtackFisico extends Atack{
    
    private String nomeAtack;
    
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Construtor
 */

    public AtackFisico(String nome) {
        super();
        this.nomeAtack= nome;
    }

 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Roda dano do ataque
 */   
    
    public int rodaDano(int numFaces, int mod){
        if(numFaces!=1)
            return super.rodaDano(numFaces)+mod;
        else{
            return 0;
        }
    }
    

    
    
    
}
