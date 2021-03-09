/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
*/
package br.com.ufjf.estudante.main;
import java.util.Random;
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Classe para rolagem de dado mais pratica
 */
public class Dado {
    private Random dado;
/**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Construtor  
 */
    public Dado() {
        this.dado= new Random();
    }
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Roda o dado e retorna o valor rodado;
 */
    public int rodaDado(int faces){
        return dado.nextInt(faces)+1;
    }
    
/*
 *@author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Roda multiplos dados o dado e retorna o valor rodado;
 */
    
    public int rodaDadoMultiplos(int faces, int quantDados){
        int valor=0;
        for (int i = 0; i < quantDados; i++) {
            valor=+this.rodaDado(faces);
        }
        return valor;
    }
    
    
}
