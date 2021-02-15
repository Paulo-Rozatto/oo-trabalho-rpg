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
 * Classe para fazer ataques fisicos
 */
public class AtackFisico extends Atack{
    
    private String nomeAtack;
    
 /**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Construtor
 */   
    

    public AtackFisico(String nomeAtack, int dano, int danoB, int numDados) {
        super(dano, danoB, numDados);
        this.nomeAtack = nomeAtack;
    }

       
   /**
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Geters E Seters
 */   
    public String getNomeAtack() {
        return nomeAtack;
    }

    
    

    
    
    
}
