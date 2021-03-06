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
public class GrupoJogador{
     private static List<Jogador> grupoJogador = new ArrayList<>();
     public static void iniciaGrupo(List<Jogador> grupoEntrada){
         grupoJogador.addAll(grupoEntrada);
     }
     public static int getSize(){
         return grupoJogador.size();
     }
     public static Jogador getJogador(int id){
         return grupoJogador.get(id);
     }
     public static void removeJogador(int id){
         if(grupoJogador.size() > 0)
            grupoJogador.remove(id);
     }
}
