
package br.com.ufjf.estudante.main;

/**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Classe base para AtackFisico e AtackMagico
 */
public class Atack {

    private Dado dado;

    //inicializa o dado
    public Atack() {
        this.dado = new Dado();
    }

    /*Recebe um valor inteiro para cara face do dano
    e retorna um valor inteiro randomico gerado pelo dado >=1 
    edit: MATHEUS NP 11/02/21
     */
    public int rodaDano(int numFaces) {
        if (numFaces != 1) {
            return this.dado.RodaDado(numFaces);
        } else {
            return 0;
        }

    }
}
