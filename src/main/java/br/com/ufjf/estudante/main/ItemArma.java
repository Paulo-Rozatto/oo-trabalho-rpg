package br.com.ufjf.estudante.main;


import br.com.ufjf.estudante.main.AtackFisico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathe
 */
public class ItemArma extends Item{
    
    protected AtackFisico danoArma;//
    protected int bonusAtack;//para variara de +1 para uma arama de boa qualidade e +3 para uma arma de qualidade absurda
    public Dado dado;//classe abstrata para ajudar na implementação;
    protected int tipo;//1- para aramas sem efeito magico e 2- para armas com efeito magico
   

    public ItemArma(AtackFisico danoArma, int bonusAtack, String nome,int tipo) {
        super(nome);
        this.dado = new Dado();
        this.danoArma = danoArma;
        this.bonusAtack = bonusAtack;
        this.tipo=tipo;
        this.modelo = 1;//0 = consumivel, 1=arma, 2=armadura
    }
  
    public int ataque(int defesaInimiga, int modficador) {

        int guardaDado = this.dado.rodaDado(20);

        if (guardaDado + modficador + bonusAtack > defesaInimiga) {
            if (guardaDado == 20) {
                System.out.println("O dado girado foi um critico!!!!!");
                AuxiliarGeraTexto.setDescricaoAtaqueFisico(0, 0, 0);
                return this.danoArma.rodaDano(modficador) * 2;
            } else {
                System.out.println("O dado girado foi de " + (guardaDado + modficador) + " e precisava de " + defesaInimiga);
                AuxiliarGeraTexto.setDescricaoAtaqueFisico(1, (guardaDado + modficador) , defesaInimiga);
                return this.danoArma.rodaDano(modficador);
            }
        } else {
            System.out.println("O ataque não acertou o inimigo o dado tirado foi " + guardaDado);
            AuxiliarGeraTexto.setDescricaoAtaqueFisico(2, guardaDado, 0);
            return 0;
        }

    }

    public int getBonusAtack() {
        return bonusAtack;
    }

    public int getTipo() {
        return tipo;
    }

    public int getDanoArma() {
        return danoArma.getDano();
    }
    
    public int getDanoBase(){
        return danoArma.getDanoB();
    }
    
    public int getNumDados(){
        return danoArma.getNumDados();
    }
    
    public String getTipoDano(){
        return danoArma.getNomeAtack();
    }
    
    
}


