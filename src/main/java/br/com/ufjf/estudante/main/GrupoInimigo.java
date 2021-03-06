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
public class GrupoInimigo{
    private static List<Jogador> grupoJogador = new ArrayList<>();
     private static List<NpcInimigo> grupoInimigo = new ArrayList<>();
     public static void iniciaGrupo(int round){
         int experiencia;
         String descricaoMorte;
         String nome;
         int forca;
         int inteligencia;
         int destreza;
         AtackFisico ataqueFisico;
         AtackMagico ataqueMagico;
         int classe;
         NpcInimigo inimigo;
        switch(round){
             case 0:
                experiencia = 10;
                descricaoMorte = "No ceu tem pao? E morreu.";
                nome = "Monstro 1";
                forca = 5;
                inteligencia = 5;
                destreza = 5;
                ataqueFisico = new AtackFisico("ataque", 5, 5, 0);
                ataqueMagico = new AtackMagico("magia", 5, 5, 5, 0);
                classe = 1;
                inimigo = new NpcInimigo(experiencia, descricaoMorte, nome, forca, inteligencia, destreza, ataqueFisico, ataqueMagico, classe);
                grupoInimigo.add(inimigo);
                                experiencia = 10;
                nome = "Monstro 2";
                inimigo = new NpcInimigo(experiencia, descricaoMorte, nome, forca, inteligencia, destreza, ataqueFisico, ataqueMagico, classe);
                grupoInimigo.add(inimigo);
                 break;
             case 1:
                 break;
             case 2:
                 break;
         }
     }
     public static int getSize(){
         return grupoInimigo.size();
     }
     public static NpcInimigo getInimigo(int id){
         return grupoInimigo.get(id);
     }
     public static void removeInimigo(int id){
         if(grupoInimigo.size() > 0)
            grupoInimigo.remove(id);
     }
}
