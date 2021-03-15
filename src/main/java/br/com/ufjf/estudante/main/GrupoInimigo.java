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
    private static List<NpcInimigo> grupoInimigo = new ArrayList<>();
     public static void iniciaGrupo(){
         Dado dado = new Dado();
         for(int i = 0; i < GrupoJogador.getSize(); i++){
             grupoInimigo.add(auxIniciaGrupo(dado.rodaDado(16)));
         }
         /*
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
                nome = "Esqueleto 1";
                forca = 2;
                inteligencia = 1;
                destreza = 1;
                AtackFisico atackFisico= new AtackFisico("corte", 8, 1, 1);
                ItemArma itemArma = new ItemArma(atackFisico, 1, "machado", 1);
                ItemArmadura armadura= new ItemArmadura("Leve", 4, "tecido");
                ataqueMagico = new AtackMagico("magia", 5, 5, 5, 0);
                classe = 1;
                inimigo = new NpcInimigo(experiencia, descricaoMorte, nome, forca, inteligencia, destreza, classe, itemArma, armadura);
                grupoInimigo.add(inimigo);
                                experiencia = 10;
                nome = "Esqueleto 2";
                inimigo = new NpcInimigo(experiencia, descricaoMorte, nome, forca, inteligencia, destreza, classe, itemArma, armadura);
                grupoInimigo.add(inimigo);
                GrupoInimigo.getInimigo(0).addMagia(GeraItensMagiaNpcs.adagaMental());
                GrupoInimigo.getInimigo(1).addMagia(GeraItensMagiaNpcs.adagaMental());
                 break;
             case 1:
                 break;
             case 2:
                 break;
         }
         */
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
     public static NpcInimigo auxIniciaGrupo(int tipo){
         switch(tipo){
             case 1:
                 return GeraItensMagiaNpcs.Minotauro();
             case 2:
                 return GeraItensMagiaNpcs.aranhaGigante();
             case 3:
                 return GeraItensMagiaNpcs.bandido();
             case 4:
                 return GeraItensMagiaNpcs.centauro();
             case 5:
                 return GeraItensMagiaNpcs.dragao();
             case 6:
                 return GeraItensMagiaNpcs.elfoArqueiro();
             case 7:
                 return GeraItensMagiaNpcs.elfoMago();
             case 8:
                 return GeraItensMagiaNpcs.esqueleto();
             case 9:
                 return GeraItensMagiaNpcs.esqueletoArqueiro();
             case 10:
                 return GeraItensMagiaNpcs.goblin();
             case 11:
                 return GeraItensMagiaNpcs.lobo();
             case 12:
                 return GeraItensMagiaNpcs.necromante();
             case 13:
                 return GeraItensMagiaNpcs.ogro();
             case 14:
                 return GeraItensMagiaNpcs.orc();
             case 15:
                 return GeraItensMagiaNpcs.orcChefe();
             case 16:
                 return GeraItensMagiaNpcs.zumbi();
         }
         return GeraItensMagiaNpcs.esqueleto();
     }
}
