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
 * @author MATHEUS NP Data 12/02/21 ultima modfificação Classe base para montros
 * e jogador
 */
public abstract class Personagem {

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
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Gera os hitPoints do
     * personagem valida e se variavel classe e valida
     */
    private void geraHP() {
        switch (classe) {
            case 1:
                hitPoints = 15 + dado.rodaDado(10) + (modForça * 2) + (+modDestreza);//Guerreiro
                break;
            case 2:
                hitPoints = 9 + dado.rodaDado(8) + modForça + (modInteligencia / 2);//Mago
                break;
            case 3:
                hitPoints = 12 + dado.rodaDado(8) + modForça + (modDestreza / 2);//Ladino
                break;
            default:
                classe = -1;
                System.out.println("Escolha de classe invalida");
        }
        this.vidaAtual = this.hitPoints;
    }

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Gera os manaPontis
     * do personagem e valida se variavel classe e valida
     */
    private void geraMP() {
        switch (classe) {
            case 1:
                this.manaPoints = 3 + dado.rodaDado(2) + this.modInteligencia;//Guerreiro
                break;
            case 2:
                this.manaPoints = 6 + dado.rodaDado(4) + (this.modInteligencia * 2);//Mago
                break;
            case 3:
                this.manaPoints = 3 + dado.rodaDado(3) + this.modInteligencia + (this.modDestreza / 2);//Ladino
                break;
            default:
                classe = -1;
                System.out.println("Escolha de classe invalida");
        }
        this.manaAtual = this.manaPoints;
    }

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Gera os defesa do
     * personagem e valida se variavel classe e valida
     */
    private void geraDefesa() throws NullPointerException {
        switch (classe) {
            case 1:
                defesa = 10 + modDestreza + ((this.modForça / 2) - 1);//Guerreiro
                break;
            case 2:
                defesa = 10 + modDestreza;//Mago
                break;
            case 3:
                defesa = 10 + (modDestreza * 2);//Ladino
                break;
            default:
                classe = -1;
                System.out.println("Escolha de classe invalida");
        }
        try {
            this.defesa = defesa + this.armadura.getBonusDefesa();
        } catch (NullPointerException armaduraVazia) {
            ;
        }

    }

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Escolhe a classe
     * para o calculo dos status de combate ou realiza nova escolha de classe
     * caso o valor foi invalido
     *
     */

    public void escolhaClasse(int classe) throws NullPointerException {
        if (classe > 3 && classe <= 0) {
            System.out.println("Classe invalida por favor digite de numero " + 1 + "a " + 3 + "sendo: \n1-Guerreiro\n2=Mago\n3-Ladino");
            this.classe = -1;
        } else {
            if (this.classe != -1) {
                this.classe = classe;
                geraHP();
                geraMP();
                geraDefesa();
                geraSprite();
                try {
                    this.defesa = +this.armadura.getBonusDefesa();
                } catch (NullPointerException armaduraVazia) {
                    ;
                }
            }
        }

    }

    /**
     *
     * @author MATHEUS NP Data 05/03/21 ultima modfificação construtor
     */

    //Construtor com classe
    public Personagem(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, int classe, ItemArma arma, ItemArmadura armadura) {

        this.dado = new Dado();
        this.nomePersonagem = nomePersonagem;
        this.modForça = modForça;
        this.modInteligencia = modInteligencia;
        this.modDestreza = modDestreza;
        this.classe = classe;
        this.arma = arma;
        this.armadura = armadura;
        this.classe = classe;
        corrigeClasse(classe);
        ListaMagias = new ArrayList<AtackMagico>();
    }

    //construtor sem classe
    public Personagem(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, ItemArma arma, ItemArmadura armadura) {

        this.dado = new Dado();
        this.nomePersonagem = nomePersonagem;
        this.modForça = modForça;
        this.modInteligencia = modInteligencia;
        this.modDestreza = modDestreza;
        this.classe = classe;
        this.arma = arma;
        this.armadura = armadura;
        escolhaClasse(classe);
        ListaMagias = new LinkedList<AtackMagico>();
    }

    private void corrigeClasse(int classe) {
        if (classe < 1 || classe > 3) {
            this.classe = 1;
        }
        geraHP();
        geraMP();
        geraDefesa();
        geraSprite();
        geraSprite();
    }

    /**
     *
     * @author MATHEUS NP Data 14/02/21 ultima modfificação realiza ataqueFisico
     */
    public int ataqueFisico(int defesaInimiga) {

        int guardaDado = this.dado.rodaDado(20);
        if (modForça < modDestreza) {
            System.out.println("O dado girado foi de " + (guardaDado + modDestreza) + " e precisava de " + defesaInimiga);
            AuxiliarGeraTexto.setTextoAtaqueFisico((guardaDado + modDestreza), defesaInimiga);
            return this.arma.ataque(defesaInimiga, this.modDestreza);
        } else {
            System.out.println("O dado girado foi de " + (guardaDado + modForça) + " e precisava de " + defesaInimiga);
            AuxiliarGeraTexto.setTextoAtaqueFisico((guardaDado + modForça), defesaInimiga);
            return this.arma.ataque(defesaInimiga, this.modForça);
        }

    }

    /**
     *
     * @author MATHEUS NP Data 14/02/21 ultima modfificação realiza ATAQUEMAGICO
     */

    public int ataqueMagico(int defesaInimiga, AtackMagico magia) {

        if (this.manaPoints >= magia.getPM()) {
            int guardaDado = this.dado.rodaDado(20);
            if (guardaDado + this.modInteligencia > defesaInimiga) {
                AuxiliarGeraTexto.setTextoAtaqueMagico(guardaDado + this.modInteligencia, defesaInimiga);
                if (arma.getTipo() == 2) {
                    this.manaAtual = this.manaAtual -magia.getPM();
                    System.out.println("O dado girado foi de " + (guardaDado + this.modInteligencia) + " e precisava de " + defesaInimiga);
                    return magia.rodaDano(this.modInteligencia) + arma.getBonusAtack();
                } else {
                    this.manaAtual = this.manaAtual - magia.getPM();
                    System.out.println("O dado girado foi de " + (guardaDado + this.modInteligencia) + " e precisava de " + defesaInimiga);
                    return magia.rodaDano(this.modInteligencia);
                }
            } else {
                System.out.println("Sem Pontos de Mana suficientes para esta magia");
                AuxiliarGeraTexto.setTextoAtaqueMagico();
                return 0;
            }
        }
        return 0;
    }

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Descrição da
     * morte(sugerido cara criatura/montros ter uma diferente)
     */
    public void morte() {
        System.out.println("YOU DIE");
    }

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Calcula os pontos de
     * vida e verifica a morte do personagem
     */
    public void sofreAtack(int danoInimigo) {
        this.vidaAtual = this.vidaAtual - danoInimigo;
        if (this.vidaAtual <= 0) {
            this.morte();
        }
    }

    public AtackMagico ListaMagias(int i)throws NullPointerException{
        try {
            return ListaMagias.get(i);
        } catch (NullPointerException e) {
              throw new NullPointerException("Índice Incorreto");
        }
    }
    
    
    public void addMagia(AtackMagico magia){
            ListaMagias.add(magia);
    }
    
    public void removeMagia(int posição){
        this.ListaMagias.remove(posição);
    }
    
      
    public int getSizeListaMagias(){
        return ListaMagias.size();
    }
    
    
    public int listaMagiaRetornaIndicie(String nome){
        for (int i = 0; i < ListaMagias.size(); i++) {
            if(ListaMagias.get(i).getNomeMagia()== nome){
                return i;
            }
        }
        return -1;
    }

    //PARTE RESERVADA A INTERFACE GRAFICA
    protected void geraSprite() {
        sprite = new ImageIcon("res/jogador/guerreiro.png"); //Pasta onde esta a imagem
        switch (classe) {

            case 1:
                sprite = new ImageIcon("res/jogador/guerreiro.png"); //Pasta onde esta a imagem
                break;
            case 2:
                sprite = new ImageIcon("res/jogador/mago.png"); //Pasta onde esta a imagem
                break;
            case 3:
                sprite = new ImageIcon("res/jogador/ladino.png"); //Pasta onde esta a imagem
                break;
            default:
                sprite = new ImageIcon("res/jogador/guerreiro.png"); //Pasta onde esta a imagem
        }
    }

    protected void geraSpriteInimigo() {
        sprite = new ImageIcon("res/inimigos/orc_padrao.gif"); //Pasta onde esta a imagem
        switch (classe) {

            case 1:
                sprite = new ImageIcon("res/inimigos/orc_padrao.gif"); //Pasta onde esta a imagem
                break;
            case 2:
                sprite = new ImageIcon("res/inimigos/esqueleto_padrao.gif"); //Pasta onde esta a imagem
                break;
            case 3:
                sprite = new ImageIcon("res/inimigos/dark_elf_padrao.gif"); //Pasta onde esta a imagem
                break;
            default:
                sprite = new ImageIcon("res/inimigos/orc_padrao.gif"); //Pasta onde esta a imagem
        }
    }

    public void trocaAnimacaoInimigo(int pose) {
        if (classe == 1) {
            switch (pose) {
                case 0:
                    sprite = new ImageIcon("res/inimigos/orc_padrao.gif");
                    break;
                case 1:
                    sprite = new ImageIcon("res/inimigos/orc_ataque.gif");
                    break;
                case 2:
                    sprite = new ImageIcon("res/inimigos/orc_magia.gif");
                    break;
                case 3:
                    sprite = new ImageIcon("res/inimigos/orc_dano.gif");
                    break;
                default:
                    sprite = new ImageIcon("res/inimigos/orc_padrao.gif");
            }
        }
        if (classe == 2) {
            switch (pose) {
                case 0:
                    sprite = new ImageIcon("res/inimigos/esqueleto_padrao.gif");
                    break;
                case 1:
                    sprite = new ImageIcon("res/inimigos/esqueleto_ataque.gif");
                    break;
                case 2:
                    sprite = new ImageIcon("res/inimigos/esqueleto_magia.gif");
                    break;
                case 3:
                    sprite = new ImageIcon("res/inimigos/esqueleto_dano.gif");
                    break;
                default:
                    sprite = new ImageIcon("res/inimigos/esqueleto_padrao.gif");
            }
        }
        if (classe == 3) {
            switch (pose) {
                case 0:
                    sprite = new ImageIcon("res/inimigos/dark_elf_padrao.gif");
                    break;
                case 1:
                    sprite = new ImageIcon("res/inimigos/dark_elf_ataque.gif");
                    break;
                case 2:
                    sprite = new ImageIcon("res/inimigos/dark_elf_magia.gif");
                    break;
                case 3:
                    sprite = new ImageIcon("res/inimigos/dark_elf_dano.gif");
                    break;
                default:
                    sprite = new ImageIcon("res/inimigos/dark_elf_padrao.gif");
            }
        }
    }

    public void trocaAnimacaoJogador(int pose) {
        if (classe == 1) {
            switch (pose) {
                case 0:
                    sprite = new ImageIcon("res/jogador/guerreiro_padrao.gif");
                    break;
                case 1:
                    sprite = new ImageIcon("res/jogador/guerreiro_ataque.gif");
                    break;
                case 2:
                    sprite = new ImageIcon("res/jogador/guerreiro_magia.gif");
                    break;
                case 3:
                    sprite = new ImageIcon("res/jogador/guerreiro_dano.gif");
                    break;
                default:
                    sprite = new ImageIcon("res/jogador/guerreiro_padrao.gif");
            }
        }
        if (classe == 2) {
            switch (pose) {
                case 0:
                    sprite = new ImageIcon("res/jogador/mago_padrao.gif");
                    break;
                case 1:
                    sprite = new ImageIcon("res/jogador/mago_ataque.gif");
                    break;
                case 2:
                    sprite = new ImageIcon("res/jogador/mago_magia.gif");
                    break;
                case 3:
                    sprite = new ImageIcon("res/jogador/mago_dano.gif");
                    break;
                default:
                    sprite = new ImageIcon("res/jogador/mago_padrao.gif");
            }
        }
        if (classe == 3) {
            switch (pose) {
                case 0:
                    sprite = new ImageIcon("res/jogador/ladino_padrao.gif");
                    break;
                case 1:
                    sprite = new ImageIcon("res/jogador/ladino_ataque.gif");
                    break;
                case 2:
                    sprite = new ImageIcon("res/jogador/ladino_magia.gif");
                    break;
                case 3:
                    sprite = new ImageIcon("res/jogador/ladino_dano.gif");
                    break;
                default:
                    sprite = new ImageIcon("res/jogador/ladino_padrao.gif");
            }
        }
    }

    /**
     * @author MATHEUS NP Data 14/02/21 ultima modfificação Geters E Seters
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

    public void setClasse(int classe) {
        this.classe = classe;
        corrigeClasse(classe);
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
    public AtackMagico getAtackMagico(int i){
        return ListaMagias.get(i);
    }
    public int getSizeListMagias(){
        return ListaMagias.size();
    }
}
