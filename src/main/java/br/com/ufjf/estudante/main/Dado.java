/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public int RodaDado(int faces){
        return dado.nextInt(faces)+1;
    }
    
    
}
