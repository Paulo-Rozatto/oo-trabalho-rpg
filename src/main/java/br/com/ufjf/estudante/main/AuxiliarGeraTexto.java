/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sabri
 */
public class AuxiliarGeraTexto {
    private static List<Integer> ataque = new ArrayList<>(5);
    private static List<Integer> magia = new ArrayList<>(3);
//posicao 0 corresponde a estado, posicao 1 corresponde a dando e posicao 2 corresponde a defesa.
    
    public static void setTextoAtaqueFisico(int dado, int defesa){
        ataque.add(0, dado);
        ataque.add(1, defesa);
    }
    public static void setDescricaoAtaqueFisico(int estado, int dado, int defesa){
        ataque.add(2, estado);
        ataque.add(3, dado);
        ataque.add(4, defesa);
    }
    private static String getDescricaoDoAtaqueFisico(){
        switch(ataque.get(2)){
            case 0:
                return "\nO dado girado foi um critico!!!!!";
            case 1:
                try{
                    return ("\nO dado girado foi de " + ataque.get(3) + " e precisava de " + ataque.get(4));
                }catch(NullPointerException e){
                    return "";
                }
            case 2:
                try{
                    return ("\nO ataque não acertou o inimigo, o dado tirado foi " + ataque.get(3));
                }catch(NullPointerException e){
                    return "";
                }
        }
        return "";
    }
    public static String getTextoAtaqueFisico(){
        try{
            return "\nO dado girado foi de " + ataque.get(0) + " e precisava de " + ataque.get(1) + AuxiliarGeraTexto.getDescricaoDoAtaqueFisico();
        } 
        catch(NullPointerException e){
            return "";
        }
    }
    public static void setTextoAtaqueMagico(){
        magia.add(0, 1);
    }
    public static void setTextoAtaqueMagico(int dado, int defesa){
        magia.add(0, 0);
        magia.add(1, dado);
        magia.add(2, defesa);
    }
    public static String getTextoAtaqueMagico(){
        if(magia.size() > 0)
            switch(magia.get(0)){
                case 0:
                    try{
                        return "\nO dado girado foi de " + magia.get(1) + " e precisava de " + magia.get(2);
                    }
                    catch(NullPointerException e){
                        return "";
                    }
                case 1:
                    return "\nSem Pontos de Mana suficientes para esta magia";
            }
        return "";
    }
}
