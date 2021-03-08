/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.janelas;

import br.com.ufjf.estudante.main.GrupoInimigo;
import br.com.ufjf.estudante.main.GrupoJogador;
import br.com.ufjf.estudante.main.Jogador;
import br.com.ufjf.estudante.main.NpcInimigo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luiz
 */
public class Painel_Animacao extends JPanel {

    //Descricao dos atributos comentado no contrutor
    private int larguraPainel;
    private int alturaPainel;
    private int posicao;
    private int ladoJogador;
    private int ladoInimigo;
    private int quadrosAtacante;
    private int poseAtacante;
    private int quadrosAlvo;
    private int poseAlvo;
    private int largSprite;
    private int altSprite;
    private int alvoJogador;
    private int atacanteJogador;
    private int alvoInimigo;
    private int atacanteInimigo;
    private int frameJogador;
    private int frameInimigo;

    boolean animacao;

    private List<Jogador> jogador;
    private List<NpcInimigo> inimigo;

    public Painel_Animacao(int largura, int altura, List<Jogador> jogador, List<NpcInimigo> inimigos) {
//        System.out.println("INICIALIZOU PAINEL");
        //INFORMACAO PARA CORTAR A TABELA DE SPRITES
        this.ladoJogador = 3;
        this.ladoInimigo = 1;
        this.quadrosAlvo = 0;
        this.poseAlvo = 0;
        this.quadrosAtacante = 0;
        this.poseAtacante = 0;
        //frames eh a posicao do quadro de uma linha que o jogador ou o inimigo esta 
        this.frameJogador = 0;
        this.frameInimigo = 0;
        this.largSprite = 64;
        this.altSprite = 64;
        //TAMANHO DO PAINEL
        this.larguraPainel = largura;
        this.alturaPainel = altura;
        //LISTA DE PERSONAGENS
        this.jogador = jogador;
        this.inimigo = inimigos;
        //INDICE DOS PERSONAGENS COM ANIMACAO ESPECIAL
        this.alvoJogador = -1;
        this.atacanteJogador = -1;
        this.alvoInimigo = -1;
        this.atacanteInimigo = -1;
        //DEFINE SE ESTA ACONTECENDO UMA ANIMACAO
        this.animacao = false;
        //COR ONDE FICA OS BOTOES
        this.setBackground(Color.gray);

//        System.out.println("Posicao x jogador1: " + jogador.get(0).getPosX());
    }

    //ESSA FUNÇÃO DESENHA AS IMAGENS NA TELA, PARA CHAMALA, UTILIZAR "repaint()"
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        System.out.println(" alvojogador: "+alvoJogador+" alvoinimigo: "+alvoInimigo+" atacantejogador: "+atacanteJogador+" atacanteinimigo: "+atacanteInimigo+" animacao: "+animacao);
        Graphics2D graficos = (Graphics2D) g;
        graficos.setColor(Color.blue);
        graficos.fillRect(0, 50, larguraPainel, alturaPainel);//Desenha cor do fundo

        if (alvoJogador == -1 && atacanteJogador == -1 && alvoInimigo == -1 && atacanteInimigo == -1) {
            animacao = false;//Nao Esta acontecendo animacao
        } else {
            animacao = true;//esta acontecendo animacao
        }
        if(jogador.size()<=0){
            alvoJogador = -1;
            atacanteJogador = -1;
        }
        if(inimigo.size()<=0){
            alvoInimigo = -1;
            atacanteInimigo = -1;
        }

        //DESENHA JOGADORES NA TELA
        for (int i = 0; i < jogador.size(); i++) {
            int x = jogador.get(i).getPosX();
            int y = jogador.get(i).getPosY();
            Image referencia = jogador.get(i).getTabelaSprite();

            //DESENHA JOGADOR SEM ANIMACAO
            if (i != alvoJogador && i != atacanteJogador) {

                graficos.drawImage(referencia,//Imagem
                        //  LUGAR ONDE SERA DESENHADO: (x1 ate x2, y1 ate y2)
                        x, y, x + largSprite, y + altSprite,//x1,y1,x2,y2
                        //  LOCAL QUE A IMAGEM BASE SERA CORTADA
                        0, altSprite * ladoJogador,
                        largSprite, altSprite * ladoJogador + altSprite, this);//x,y,Largura,Altura
            }
            //DESENHA ANIMACAO DE ATAQUE/MAGIA/ITEM DO JOGADOR
            if (i == atacanteJogador) {//Inicia animacao de ataque
                if (frameJogador <= quadrosAtacante) {
                    graficos.drawImage(referencia,//Imagem
                            //  LUGAR ONDE SERA DESENHADO: (x1 ate x2, y1 ate y2)
                            x, y, x + largSprite, y + altSprite,//x1,y1,x2,y2
                            //  LOCAL QUE A IMAGEM BASE SERA CORTADA
                            frameJogador * largSprite, (altSprite * ladoJogador) + (altSprite * poseAtacante * 4),
                            frameJogador * largSprite + largSprite, (altSprite * ladoJogador) + (altSprite * poseAtacante * 4) + altSprite, this);//x,y,Largura,Altura
                    frameJogador++;
                } else {
                    frameJogador = 0;
                    atacanteJogador = -1;
                }

            }
            //DESENHA ANIMACAO DE DANO DO JOGADOR
            if (i == alvoJogador) {//Animcao de dano
                if (frameJogador < quadrosAlvo) {
                    graficos.drawImage(referencia,//Imagem
                            //  LUGAR ONDE SERA DESENHADO: (x1 ate x2, y1 ate y2)
                            x, y, x + largSprite, y + altSprite,//x1,y1,x2,y2
                            //  LOCAL QUE A IMAGEM BASE SERA CORTADA
                            frameJogador * largSprite, altSprite * (poseAlvo) * 4,
                            frameJogador * largSprite + largSprite, altSprite * (poseAlvo) * 4 + altSprite, this);//x,y,Largura,Altura
                    frameJogador++;
                } else {
                    frameJogador = 0;
                    alvoJogador = -1;
                }
            }
        }

        //DESENHA INIMIGOS NA TELA
        for (int i = 0; i < inimigo.size(); i++) {//Desenha os inimigos na tela...
            int x = inimigo.get(i).getPosX();
            int y = inimigo.get(i).getPosY();
            Image referencia = inimigo.get(i).getTabelaSprite();
            //DESENHA INIMIGOS SEM ANIMACAO
            if (i != alvoInimigo && i != atacanteInimigo) {//Desenha sem nenhuma animacao

                graficos.drawImage(referencia,//Imagem
                        //  LUGAR ONDE SERA DESENHADO: (x1 ate x2, y1 ate y2)
                        x, y, x + largSprite, y + altSprite,//x1,y1,x2,y2
                        //  LOCAL QUE A IMAGEM BASE SERA CORTADA
                        0, altSprite * ladoInimigo,
                        largSprite, altSprite * ladoInimigo + altSprite, this);//x,y,Largura,Altura
            }
            //DESENHA ANIMACAO DE ATAQUE/MAGIA/ITEM DO INIMIGO
            if (i == atacanteInimigo) {//Inicia animacao de ataque
                if (frameInimigo <= quadrosAtacante) {
                    graficos.drawImage(referencia,//Imagem
                            //  LUGAR ONDE SERA DESENHADO: (x1 ate x2, y1 ate y2)
                            x, y, x + largSprite, y + altSprite,//x1,y1,x2,y2
                            //  LOCAL QUE A IMAGEM BASE SERA CORTADA
                            frameInimigo * largSprite, (altSprite * ladoInimigo) + (altSprite * poseAtacante * 4),
                            frameInimigo * largSprite + largSprite, (altSprite * ladoInimigo) + (altSprite * poseAtacante * 4) + altSprite, this);//x,y,Largura,Altura
                    frameInimigo++;
                } else {
                    frameInimigo = 0;
                    atacanteInimigo = -1;
                }

            }
            //DESENHA ANIMCAO DE DANO NO INIMIGO
            if (i == alvoInimigo) {//Animcao de dano
                if (frameInimigo < quadrosAlvo) {
                    graficos.drawImage(referencia,//Imagem
                            //  LUGAR ONDE SERA DESENHADO: (x1 ate x2, y1 ate y2)
                            x, y, x + largSprite, y + altSprite,//x1,y1,x2,y2
                            //  LOCAL QUE A IMAGEM BASE SERA CORTADA
                            frameInimigo * largSprite, altSprite * (poseAlvo) * 4,
                            frameInimigo * largSprite + largSprite, altSprite * (poseAlvo) * 4 + altSprite, this);//x,y,Largura,Altura
                    frameInimigo++;
                } else {
                    frameInimigo = 0;
                    alvoInimigo = -1;
                }
            }
        }

    }

    //CLASSES PARA ALTERAR ANIMACAO: 
    
    public void ataqueJogador(int ind_atacante, int ind_alvo) {
        if (!animacao) {//Se nao estiver acontecendo nenhuma animacao
            if (ind_atacante < jogador.size() && ind_atacante >= 0 && ind_alvo < inimigo.size() && ind_alvo >= 0) {
                animacao = true;
                atacanteJogador = ind_atacante;
                poseAtacante = 1;//de 4 em 4 linhas da tabela de sprite muda a posicao
                quadrosAtacante = 7;//coluna da tabela de sprites

                alvoInimigo = ind_alvo;
                poseAlvo = 5;//linha da tabela de sprite
                quadrosAlvo = 5;//coluna da tabela de sprites
            }
        }
    }
    
    public void magiaJogador(int ind_atacante, int ind_alvo) {
        if (!animacao) {//Se nao estiver acontecendo nenhuma animacao
            if (ind_atacante < jogador.size() && ind_atacante >= 0 && ind_alvo < inimigo.size() && ind_alvo >= 0) {
                animacao = true;
                atacanteJogador = ind_atacante;
                poseAtacante = 0;//de 4 em 4 linhas da tabela de sprite muda a posicao
                quadrosAtacante = 6;//coluna da tabela de sprites

                alvoInimigo = ind_alvo;
                poseAlvo = 5;//linha da tabela de sprite
                quadrosAlvo = 5;//coluna da tabela de sprites
            }
        }
    }
    
    public void itemJogador(int ind_jogador) {
        if (!animacao) {//Se nao estiver acontecendo nenhuma animacao
            if (ind_jogador < jogador.size() && ind_jogador >= 0) {
                animacao = true;
                atacanteJogador = ind_jogador;
                poseAtacante = 0;//de 4 em 4 linhas da tabela de sprite muda a posicao
                quadrosAtacante = 6;//coluna da tabela de sprites
            }
        }
    }

    public void ataqueInimigo(int ind_atacante, int ind_alvo){
        if (!animacao) {//Se nao estiver acontecendo nenhuma animacao
            if (ind_atacante < inimigo.size() && ind_atacante >= 0 && ind_alvo < jogador.size() && ind_alvo >= 0) {
                animacao = true;
                atacanteInimigo = ind_atacante;
                poseAtacante = 1;//de 4 em 4 linhas da tabela de sprite muda a posicao
                quadrosAtacante = 7;//coluna da tabela de sprites

                alvoJogador = ind_alvo;
                poseAlvo = 5;//linha da tabela de sprite
                quadrosAlvo = 5;//coluna da tabela de sprites
            }
        }
    }
    
    public void magiaInimigo(int ind_atacante, int ind_alvo){
        if (!animacao) {//Se nao estiver acontecendo nenhuma animacao
            if (ind_atacante < inimigo.size() && ind_atacante >= 0 && ind_alvo < jogador.size() && ind_alvo >= 0) {
                animacao = true;
                atacanteInimigo = ind_atacante;
                poseAtacante = 0;//de 4 em 4 linhas da tabela de sprite muda a posicao
                quadrosAtacante = 6;//coluna da tabela de sprites

                alvoJogador = ind_alvo;
                poseAlvo = 5;//linha da tabela de sprite
                quadrosAlvo = 5;//coluna da tabela de sprites
            }
        }
    }
    
    public void itemInimigo(int ind_inimigo){
        if (!animacao) {//Se nao estiver acontecendo nenhuma animacao
            if (ind_inimigo < inimigo.size() && ind_inimigo >= 0) {
                animacao = true;
                atacanteInimigo = ind_inimigo;
                poseAtacante = 0;//de 4 em 4 linhas da tabela de sprite muda a posicao
                quadrosAtacante = 6;//coluna da tabela de sprites
            }
        }
    }

    public boolean isAnimacao() {
        return animacao;
    }

    public void zeraAnimacao() {
        this.alvoJogador = -1;
        this.atacanteJogador = -1;
        this.alvoInimigo = -1;
        this.atacanteInimigo = -1;
        this.frameInimigo = 0;
        this.frameJogador = 0;
        
        this.animacao = false;
        
    }



    
    
}
