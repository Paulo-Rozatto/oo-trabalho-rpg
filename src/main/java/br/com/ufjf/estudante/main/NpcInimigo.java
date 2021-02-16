/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;
/**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * sub-Classe de personagem
 */


public class NpcInimigo extends Personagem {

    private int experiencia;
    private String descricaoMorte;
    private boolean vivo;
    //private Itens drop;
    
    
/**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * construtor
 */

    public NpcInimigo(int experiencia, String descricaoMorte, String nomePersonagem, int modForça, int modInteligencia,
    int modDestreza, AtackFisico atackFisico, AtackMagico atackMagico, int classe) {
        super(nomePersonagem, modForça, modInteligencia, modDestreza, atackFisico, atackMagico, classe);
        this.experiencia = experiencia;
        this.descricaoMorte = descricaoMorte;
        this.vivo=true;
    }
    
/**
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Decide ação do NPC (vai amentar o numro de acoes conforme o numero de criatura e novas implementacões forem aumentando)
 */
    
    
    
    public int decideAcao(int defesa) {
        int guardaDado = super.dado.rodaDado(3);
        if (super.getModInteligencia() <= 0) {
            return super.ataqueFisico(defesa);
        }
        else {
            switch (guardaDado) {
                case 2:
                    return super.atackMagico.rodaDano(super.getModInteligencia());
                default:
                    return super.ataqueFisico(defesa);
            }
        }

    }
 /**
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Narração da morte do NPC polimofirmo da super.morte();
 */
    @Override
    public void morte(){
        System.out.println(this.descricaoMorte);
        vivo= false;
    }
 
    
    
    
    /**
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Geters 
 */
    

    public int getExperiencia() {
        if(vivo)
           return experiencia;
        else
            return 0;
    }

    public boolean isVivo() {
        return vivo;
    }
    
    

    
}