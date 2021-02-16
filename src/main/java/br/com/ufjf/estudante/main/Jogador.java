/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;

/**
 *
 * @author MATHEUS NP
 * Data 15/02/21 ultima modfificação
 * sub-Classe de personagem
 */
public class Jogador extends Personagem{
    private int level;//level atual
    private int barraDeExp;//experiencia atual para passar de level
    private int proxLevel;//experiencia a conquistada para poder passar de level
   
/**
 *
 * @author MATHEUS NP
 * Data 15/02/21 ultima modfificação
 * construtor
 */
    public Jogador(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, AtackFisico atackFisico, AtackMagico atackMagico, int classe) {
        super(nomePersonagem, modForça, modInteligencia, modDestreza, atackFisico, atackMagico, classe);
        this.level = 1;
        this.barraDeExp = 0;
        this.proxLevel=10;
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 15/02/21 ultima modfificação
 * Metodo para subir o nivel do personagem
 */
    
    private void sobeLevel(){
        if (super.classe>=1 &&super.classe<=3) {
            System.out.println("Você subiu de Level PARABÉNS!!!!!!!\nAgora você esta no Level " + this.level);
            this.level++;
            this.barraDeExp = (int) (this.barraDeExp + (this.barraDeExp * 0.5));
            int guardaDado = 0;
            switch (super.classe) {
                case 1:
                    guardaDado = dado.rodaDado(8);
                    super.setHitPoints(super.getHitPoints() + guardaDado + super.getModForça());
                    System.out.println("Você ganhou " + (guardaDado + super.getModForça()) + "de pontos de vida atualmente você tem : " + super.getHitPoints());
                    guardaDado = dado.rodaDado(3);
                    super.setManaPoints(super.getManaPoints() + guardaDado);
                    System.out.println("Você ganhou " + guardaDado + " de pontos de mana atualmente você tem : " + super.getManaPoints());
                    break;
                case 2:
                    guardaDado = dado.rodaDado(6);
                    super.setHitPoints(super.getHitPoints() + guardaDado);
                    System.out.println("Você ganhou " + (guardaDado + super.getModForça()) + "de pontos de vida atualmente você tem : " + super.getHitPoints());
                    guardaDado = dado.rodaDado(6);
                    super.setManaPoints(super.getManaPoints() + guardaDado + (super.getModInteligencia() / 2));
                    System.out.println("Você ganhou " + (guardaDado + super.getModInteligencia() / 2) + " de pontos de mana atualmente você tem : " + super.getManaPoints());
                    break;
                case 3:
                    guardaDado = dado.rodaDado(8);
                    super.setHitPoints(super.getHitPoints() + guardaDado + (super.getModForça() / 2));
                    System.out.println("Você ganhou " + (guardaDado + (super.getModForça() / 2)) + "de pontos de vida atualmente você tem : " + super.getHitPoints());
                    guardaDado = dado.rodaDado(4);
                    super.setManaPoints(super.getManaPoints() + guardaDado + (super.getModInteligencia() / 2));
                    System.out.println("Você ganhou " + (guardaDado + super.getModInteligencia() / 2) + " de pontos de mana atualmente você tem : " + super.getManaPoints());
                    break;
                default:
            }
        }
        else
           System.out.println("Classe invalida");
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 15/02/21 ultima modfificação
 * Metodo para imprimir a porcentegem de EXP para o proximo level
 */
    
    public void porcentagemEXP(){
        float procentafemProxLv=(this.barraDeExp*100)/this.proxLevel;
        System.out.println("Você esta a %.1f %n\"" + procentafemProxLv + "para o proximo Level");
    }
    
    /**
 *
 * @author MATHEUS NP
 * Data 15/02/21 ultima modfificação
 * Metodo para calcular se o personagem pode subir de level e invocar o metodo sobeLevel(); se não for possivel mostra a exp atual em relação ao proximo level
 */
    
    public void adquireExp(boolean vivo,int exp){
        if(vivo){
            this.barraDeExp=+exp;
            while(this.barraDeExp>=this.proxLevel){
                sobeLevel();
                this.barraDeExp=-proxLevel;
            }
        }
        else{
            this.porcentagemEXP();
        }
    }
    
    
}