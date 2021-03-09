/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
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

   
    

    public NpcInimigo(int experiencia, String descricaoMorte, String nomePersonagem, int modForça, 
            int modInteligencia, int modDestreza, int classe, ItemArma arma, ItemArmadura armadura) {
        super(nomePersonagem, modForça, modInteligencia, modDestreza, classe, arma, armadura);
        this.experiencia = experiencia;
        this.descricaoMorte = descricaoMorte;
        this.vivo = true;
        super.geraSpriteInimigo();
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
                   // return super.ataqueMagico(defesa, super.magia);
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
    public void setDescricaoMorte(String descricao){
        this.descricaoMorte = descricao;
    }
    public String getDescricaoMorte(){
        return this.descricaoMorte;
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
