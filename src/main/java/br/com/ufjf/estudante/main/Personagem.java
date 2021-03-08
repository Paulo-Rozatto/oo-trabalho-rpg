/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
 */
package br.com.ufjf.estudante.main;

import javax.swing.ImageIcon;

/**
 *
 * @author MATHEUS NP Data 12/02/21 ultima modfificação Classe base para montros
 * e jogador
 */
public class Personagem {

    private String nomePersonagem;//nome da criatura/player

    private int hitPoints;//pontos de vida
    private int manaPoints;//pontos de mana     
    private int defesa;//defesa da criatura/player

    private int modForça;// modficador de força da criatura/player
    private int modInteligencia;//modificador de inteligencia da criatura/player
    private int modDestreza;// modificador de destreza da criatura/player

    AtackFisico atackFisico;//calcula o dano do ataque fisico(Classe que vai ser usada em intens não vai estar aqui no projeto final)
    AtackMagico atackMagico;//calcula o dano do ataque magico(Classe que vai ser usada em intens não vai estar aqui no projeto final)
    Dado dado;//Dado para rolar os valores na classe
    int classe;//classe escolhida pela criatura/player para gerar valores de combate
    //Itens[] mochila;// implementação futura
    //Itens arma;// implementação futura
    //itens armadura;// implementação futura

    private ImageIcon sprite;//Imagem do personagem

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Gera os hitPoints do
     * personagem valida e se variavel classe e valida
     */
    private void geraHP() {
        switch (classe) {
            case 1:
                hitPoints = 5 + dado.rodaDado(8) + (modForça * 2);//Guerreiro
                break;
            case 2:
                hitPoints = 3 + dado.rodaDado(6) + modForça + (modInteligencia / 2);//Mago
                break;
            case 3:
                hitPoints = 5 + dado.rodaDado(6) + modForça;//Ladino
                break;
            default:
                classe = -1;
                System.out.println("Escolha de classe invalida");
        }
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
    }

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Gera os defesa do
     * personagem e valida se variavel classe e valida
     */
    private void geraDefesa() {
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

    }

    /**
     *
     * @author MATHEUS NP Data 12/02/21 ultima modfificação Escolhe a classe
     * para o calculo dos status de combate ou realiza nova escolha de classe
     * caso o valor foi invalido
     */

    public void escolhaClasse(int classe) {
        if (classe > 3) {
            System.out.println("Classe invalida por favor digite de numero " + 1 + "a " + 3 + "sendo: \n1-Guerreiro\n2=Mago\n3-Ladino");
            this.classe = -1;
        } else {
            if (this.classe != -1) {
                this.classe = classe;
                geraHP();
                geraMP();
                geraDefesa();

                geraSprite();
            }
        }

    }

    /**
     *
     * @author MATHEUS NP Data 15/02/21 ultima modfificação construtor
     */

    public Personagem(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, AtackFisico atackFisico, AtackMagico atackMagico, int classe) {
        this.nomePersonagem = nomePersonagem;
        this.modForça = modForça;
        this.modInteligencia = modInteligencia;
        this.modDestreza = modDestreza;
        this.atackFisico = atackFisico;
        this.atackMagico = atackMagico;
        this.classe = classe;
        this.dado = new Dado();
        escolhaClasse(classe);

    }

    /**
     *
     * @author MATHEUS NP Data 14/02/21 ultima modfificação realiza ataqueFisico
     */
    public int ataqueFisico(int defesaInimiga) {

        int guardaDado = this.dado.rodaDado(20);
        if (modForça < modDestreza && guardaDado + this.modDestreza > defesaInimiga) {
            System.out.println("O dado girado foi de " + (guardaDado + modDestreza) + " e precisava de " + defesaInimiga);
            return this.atackFisico.rodaDano(modDestreza);
        }
        if (guardaDado + this.modForça > defesaInimiga) {
            System.out.println("O dado girado foi de " + (guardaDado + modForça) + " e precisava de " + defesaInimiga);
            return this.atackFisico.rodaDano(modForça);
        } else {
            System.out.println("O ataque não acertou o inimigo o dado tirado foi " + guardaDado);
            return 0;
        }
    }

    /**
     *
     * @author MATHEUS NP Data 14/02/21 ultima modfificação realiza ATAQUEMAGICO
     */

    public int ataqueMagico(int defesaInimiga) {
        int guardaDado = this.dado.rodaDado(20);
        if (this.manaPoints >= this.atackMagico.getPM()) {
            if (guardaDado + this.modInteligencia > defesaInimiga) {
                this.manaPoints = -this.atackMagico.getPM();
                System.out.println("O dado girado foi de " + (guardaDado + this.modInteligencia) + " e precisava de " + defesaInimiga);
                return this.atackMagico.rodaDano(this.modInteligencia);
            } else {
                System.out.println("Sem Pontos de Mana suficientes para esta magia");
                return 0;
            }
        } else {
            return 0;
        }
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
        this.hitPoints = this.hitPoints - danoInimigo;
        if (this.hitPoints <= 0) {
            this.morte();
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

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setModForça(int modForça) {
        this.modForça = modForça;
    }

    public void setModInteligencia(int modInteligencia) {
        this.modInteligencia = modInteligencia;
    }

    public void setModDestreza(int modDestreza) {
        this.modDestreza = modDestreza;
    }

    //PARTE RESERVADA A INTERFACE GRAFICA
    private void geraSprite() {
        sprite = new ImageIcon("res\\jogador\\guerreiro_padrao.gif"); //Pasta onde esta a imagem
        switch (classe) {

            case 1:
                sprite = new ImageIcon("res/jogador/guerreiro_padrao.gif"); //Pasta onde esta a imagem
                break;
            case 2:
                sprite = new ImageIcon("res/jogador/mago_padrao.gif"); //Pasta onde esta a imagem
                break;
            case 3:
                sprite = new ImageIcon("res/jogador/ladino_padrao.gif"); //Pasta onde esta a imagem
                break;
            default:
                sprite = new ImageIcon("res/jogador/guerreiro_padrao.gif"); //Pasta onde esta a imagem
        }
    }

    protected void geraSpriteInimigo() {
        sprite = new ImageIcon("res\\inimigos\\orc_padrao.gif"); //Pasta onde esta a imagem
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
        if(classe ==2){
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
        if(classe ==3){
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
        if(classe ==2){
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
        if(classe ==3){
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

}
