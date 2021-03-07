/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
*/
package br.com.ufjf.estudante.main;

/**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Classe base para AtackFisico e AtackMagico
 */
public class Atack {

    private Dado dado;//dado para rolagem do dano
    private int dano;//numero de faces do(s) dados
    private int danoB;//dano Base do ataque
    public int numDados;//Numero de dados rodados
    

  /**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Construtor
 */   
    public Atack(int dano, int danoB, int numDados) {
        this.dano = dano;
        this.danoB = danoB;
        this.numDados= numDados;
    }
    

    /**
     *
     * @author MATHEUS NP
     * Data 14/02/21 ultima modfificação
     * Roda dano do ataque
     * 
     */
    
    public int rodaDano(int mod) {
        return this.dado.rodaDadoMultiplos(dano, numDados)+ this.danoB + mod;
    }
    
       
   /**
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Geters E Seters
 */   

    public int getDano() {
        return dano;
    }

    public int getDanoB() {
        return danoB;
    }

    public int getNumDados() {
        return numDados;
    }
    
}



