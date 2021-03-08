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
