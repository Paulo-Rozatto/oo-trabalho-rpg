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