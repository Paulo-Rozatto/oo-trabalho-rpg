/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
*/
package br.com.ufjf.estudante.main;

import javax.swing.ImageIcon;
import java.util.*;



/**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Classe base para montros e jogador
 */
public class Personagem {
   
    private String nomePersonagem;//nome da criatura/player
    
    private int hitPoints;//pontos de vida maximo
    private int vidaAtual;//pontos de vida atuais
    private int manaPoints;//pontos de mana maximo
    private int manaAtual;//pontos de mana atuais
    private int defesa;//defesa da criatura/player
    
    protected int modForça;// modficador de força da criatura/player
    protected int modInteligencia;//modificador de inteligencia da criatura/player
    protected int modDestreza;// modificador de destreza da criatura/player
    
    
    public Dado dado;//Dado para rolar os valores na classe
    protected int classe;//classe escolhida pela criatura/player para gerar valores de combate
    protected ItemArma arma;// implementação futura
    protected ItemArmadura armadura;// implementação futura
    public List<AtackMagico> ListaMagias;
    
    
 
    private ImageIcon sprite;//Imagem do personagem
    
    
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Gera os hitPoints do personagem valida e se variavel classe e valida
 */

    private void geraHP(){
        switch (classe){
            case 1:
                hitPoints= 5+dado.rodaDado(8)+(modForça*2);//Guerreiro
                break;
            case 2:
                hitPoints= 3+dado.rodaDado(6)+modForça+(modInteligencia/2);//Mago
                break;
            case 3: 
                hitPoints= 5+dado.rodaDado(6)+modForça;//Ladino
                break;
            default:
                classe=-1;
                System.out.println("Escolha de classe invalida");
        } 
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Gera os manaPontis do personagem e valida se variavel classe e valida
 */
    
    private void geraMP() {
        switch (classe) {
            case 1:
               this.manaPoints = 3 + dado.rodaDado(2) + this.modInteligencia;//Guerreiro
                break;
            case 2:
                this.manaPoints = 6 + dado.rodaDado(4) + (this.modInteligencia*2);//Mago
                break;
            case 3:
                this.manaPoints = 3 + dado.rodaDado(3) + this.modInteligencia+ (this.modDestreza/2);//Ladino
                break;
            default:
                classe=-1;
                System.out.println("Escolha de classe invalida");
        }
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Gera os defesa do personagem e valida se variavel classe e valida
 */
    
    private void geraDefesa(){
        switch (classe) {
            case 1:
                defesa = 10 + modDestreza+ ((this.modForça/2)-1);//Guerreiro
                break;
            case 2:
                defesa = 10 + modDestreza;//Mago
                break;
            case 3:
                defesa = 10 + (modDestreza*2);//Ladino
                break;
            default:
                classe=-1;
                System.out.println("Escolha de classe invalida");
        }
        this.defesa=defesa+this.armadura.getBonusDefesa();
        
    }
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Escolhe a classe para o calculo dos status de combate ou realiza nova escolha de classe caso o valor foi invalido
     
 */
            
        public void escolhaClasse(int classe) {
        if (classe > 3 && classe<=0) {
            System.out.println("Classe invalida por favor digite de numero " + 1 + "a " + 3 + "sendo: \n1-Guerreiro\n2=Mago\n3-Ladino");
            this.classe=-1;
        } else {
            if (this.classe!= -1){
                this.classe = classe;
                geraHP();
                geraMP();
                geraDefesa();
                geraSprite();
                this.defesa=+this.armadura.getBonusDefesa();
            }
        }

    } 
 /**
 *
 * @author MATHEUS NP
 * Data 05/03/21 ultima modfificação
 * construtor
 */



    public Personagem(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, int classe, ItemArma arma, ItemArmadura armadura) {
        this.nomePersonagem = nomePersonagem;
        this.modForça = modForça;
        this.modInteligencia = modInteligencia;
        this.modDestreza = modDestreza;
        this.classe = classe;
        this.arma = arma;
        this.armadura = armadura;
        this.classe = classe;
        escolhaClasse(classe);
        ListaMagias= new LinkedList<AtackMagico>();
    }
    
    
 /**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * realiza ataqueFisico
 */
    
    public int ataqueFisico(int defesaInimiga){
        
        int guardaDado= this.dado.rodaDado(20);
        if(modForça < modDestreza){
           System.out.println("O dado girado foi de " + (guardaDado+modDestreza) + " e precisava de " + defesaInimiga);
           return this.arma.ataque(defesaInimiga, this.modDestreza );
        }
        else{
            System.out.println("O dado girado foi de " + (guardaDado+modForça) + " e precisava de " + defesaInimiga);
            return this.arma.ataque(defesaInimiga, this.modForça);
        }

    }
    /**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * realiza ATAQUEMAGICO
 */
    
    public int ataqueMagico(int defesaInimiga, AtackMagico magia) {

        if (this.manaPoints >= magia.getPM()) {
            int guardaDado = this.dado.rodaDado(20);
            if (guardaDado + this.modInteligencia > defesaInimiga) {
                if (arma.getTipo() == 2) {
                    this.manaAtual = -magia.getPM();
                    System.out.println("O dado girado foi de " + (guardaDado + this.modInteligencia) + " e precisava de " + defesaInimiga);
                    return magia.rodaDano(this.modInteligencia) + arma.getBonusAtack();
                } else {
                    this.manaAtual = -magia.getPM();
                    System.out.println("O dado girado foi de " + (guardaDado + this.modInteligencia) + " e precisava de " + defesaInimiga);
                    return magia.rodaDano(this.modInteligencia);
                }
            } else {
                System.out.println("Sem Pontos de Mana suficientes para esta magia");
                return 0;
            }
        }
        return 0;
} 
    
  /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Descrição da morte(sugerido cara criatura/montros ter uma diferente)
 */
    
    public void morte(){
        System.out.println("YOU DIE");
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Calcula os pontos de vida e verifica a morte do personagem
 */
    
    public void sofreAtack(int danoInimigo){
        this.vidaAtual=-danoInimigo;
        if(this.vidaAtual<=0){
            this.morte();
    }
    }
    
    public void ListaMagias(){
        for (int i = 0; i < ListaMagias.size(); i++) {
            ListaMagias.get(i).getNomeMagia();
        }
        //
        //
    }
    
    
    
 //PARTE RESERVADA A INTERFACE GRAFICA
        private void geraSprite() {
        sprite = new ImageIcon("res\\jogador\\guerreiro.png"); //Pasta onde esta a imagem
        switch (classe) {

            case 1:
                sprite = new ImageIcon("res\\jogador\\guerreiro.png"); //Pasta onde esta a imagem
                break;
            case 2:
                sprite = new ImageIcon("res\\jogador\\mago.png"); //Pasta onde esta a imagem
                break;
            case 3:
                sprite = new ImageIcon("res\\jogador\\ladino.png"); //Pasta onde esta a imagem
                break;
            default:
                sprite = new ImageIcon("res\\jogador\\guerreiro.png"); //Pasta onde esta a imagem
        }
    }
   
      
    
    
   /**
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Geters E Seters
 */   
    
    

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getModForça() {
        return modForça;
    }

    public int getModInteligencia() {
        return modInteligencia;
    }

    public int getModDestreza() {
        return modDestreza;
    }

    public int getClasse() {
        return classe;
    }

    public ImageIcon getSprite() {
        return sprite;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    protected void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    protected void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    protected void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    protected void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    protected void setModForça(int modForça) {
        this.modForça = modForça;
    }

    protected void setModInteligencia(int modInteligencia) {
        this.modInteligencia = modInteligencia;
    }

    protected void setModDestreza(int modDestreza) {
        this.modDestreza = modDestreza;
    }
    public void setArma(ItemArma arma) {
        this.arma = arma;

    
    }

    public void setArmadura(ItemArmadura armadura) {
        this.armadura = armadura;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public ItemArma getArma() {
        return arma;
    }

    public ItemArmadura getArmadura() {
        return armadura;
    }
    
}
