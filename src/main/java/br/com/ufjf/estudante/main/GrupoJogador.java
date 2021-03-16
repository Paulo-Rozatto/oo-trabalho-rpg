/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
 */
package br.com.ufjf.estudante.main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sabri
 */
public class GrupoJogador{
     private static List<Jogador> grupoJogador = new ArrayList<>();
     public static void iniciaGrupo(List<Jogador> grupoEntrada){
         grupoJogador.addAll(grupoEntrada);
         grupoJogador.get(0).addMagia(GeraItensMagiaNpcs.bolaDeFogo());
         grupoJogador.get(0).addMagia(GeraItensMagiaNpcs.adagaMental());
     }
     public static int getSize(){
         return grupoJogador.size();
     }
     public static Jogador getJogador(int id){
         try{
            return grupoJogador.get(id);
         } catch (NullPointerException e){
             return null;
         }
     }
     public static void removeJogador(int id){
         if(grupoJogador.size() > 0)
            grupoJogador.remove(id);
     }
}
