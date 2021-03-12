/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
*/
package br.com.ufjf.estudante.main;
import java.util.*;

/**
 *
 * @author MATHEUS NP
 * Data 15/02/21 ultima modfificação
 * sub-Classe de personagem
 */
public class Jogador extends Personagem {
    private int level;//level atual
    private int barraDeExp;//experiencia atual para passar de level
    private int proxLevel;//experiencia a conquistada para poder passar de level
    protected ArrayList <ItemArma> mochilaArma;//
    protected ArrayList <ItemConsumivel> mochilaConsumivel;
    protected ArrayList <ItemArmadura> mochilaArmaduras;
    protected GeraItensMagiaNpcs gerador;
    protected static ItemConsumivel itemConsumivel;
    
    private int indiceArmaEquipada;
    private int indiceArmaduraEquipada;
/**
 *
 * @author MATHEUS NP
 * Data 15/02/21 ultima modfificação
 * construtor
 */

    public Jogador(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, int classe, ItemArma arma, ItemArmadura armadura) {
        super(nomePersonagem, modForça, modInteligencia, modDestreza, classe, arma, armadura);
        this.level = 1;
        this.barraDeExp = 0;
        this.proxLevel=10;
        this.indiceArmaEquipada = 0;
        this.indiceArmaduraEquipada = 0;
        this.mochilaArma= new ArrayList<ItemArma>(10);
        this.mochilaArmaduras= new ArrayList<ItemArmadura>(10);
        this.mochilaConsumivel= new ArrayList<ItemConsumivel>(15);
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoHpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoHpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoHpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoHpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoHpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoHpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoMpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoMpMedia());
        this.addMochilaConsumivel(GeraItensMagiaNpcs.pocaoMpMedia());
        
        this.addMochilaArma(arma);
        this.addMochilaArmaduras(armadura);
        
        this.addMochilaArma(GeraItensMagiaNpcs.espadaCurta());
        this.addMochilaArma(GeraItensMagiaNpcs.espadaCurta());
        this.addMochilaArma(GeraItensMagiaNpcs.adagaM2());
        
        this.addMochilaArmaduras(GeraItensMagiaNpcs.armaduraAcolchoada());
        this.addMochilaArmaduras(GeraItensMagiaNpcs.armaduraAcolchoada());
        this.addMochilaArmaduras(GeraItensMagiaNpcs.brunea());
            
        }    

    public int getIndiceArmaEquipada() {
        return indiceArmaEquipada;
    }

    public void setIndiceArmaEquipada(int indiceArmaEquipada) {
        this.indiceArmaEquipada = indiceArmaEquipada;
    }

    public int getIndiceArmaduraEquipada() {
        return indiceArmaduraEquipada;
    }

    public void setIndiceArmaduraEquipada(int indiceArmaduraEquipada) {
        this.indiceArmaduraEquipada = indiceArmaduraEquipada;
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
            this.proxLevel = (int) (this.proxLevel + (this.proxLevel * 0.5));
            int guardaDado = 0;
            switch (super.classe) {
                case 1:
                    guardaDado = dado.rodaDado(8);
                    super.setHitPoints(super.getHitPoints() + guardaDado + super.getModForça());
                    System.out.println("Você ganhou " + (guardaDado + super.getModForça()) + "de pontos de vida atualmente você tem : " + super.getHitPoints());
                    guardaDado = dado.rodaDado(3);
                    super.setManaPoints(super.getManaAtual() + guardaDado);
                    System.out.println("Você ganhou " + guardaDado + " de pontos de mana atualmente você tem : " + super.getManaAtual());
                    break;
                case 2:
                    guardaDado = dado.rodaDado(6);
                    super.setHitPoints(super.getHitPoints() + guardaDado);
                    System.out.println("Você ganhou " + (guardaDado + super.getModForça()) + "de pontos de vida atualmente você tem : " + super.getHitPoints());
                    guardaDado = dado.rodaDado(6);
                    super.setManaPoints(super.getManaAtual() + guardaDado + (super.getModInteligencia() / 2));
                    System.out.println("Você ganhou " + (guardaDado + super.getModInteligencia() / 2) + " de pontos de mana atualmente você tem : " + super.getManaAtual());
                    break;
                case 3:
                    guardaDado = dado.rodaDado(8);
                    super.setHitPoints(super.getHitPoints() + guardaDado + (super.getModForça() / 2));
                    System.out.println("Você ganhou " + (guardaDado + (super.getModForça() / 2)) + "de pontos de vida atualmente você tem : " + super.getHitPoints());
                    guardaDado = dado.rodaDado(4);
                    super.setManaPoints(super.getManaAtual() + guardaDado + (super.getModInteligencia() / 2));
                    System.out.println("Você ganhou " + (guardaDado + super.getModInteligencia() / 2) + " de pontos de mana atualmente você tem : " + super.getManaAtual());
                    break;
                default:
            }
        }
        else
           System.out.println("Classe invalida");
    }
    
    
    
    public int getLevel(){
        return this.level;
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
    @Override
    public void setArmadura(ItemArmadura novaArmadura){
        super.setDefesa(super.getDefesa()-super.armadura.getBonusDefesa()+novaArmadura.getBonusDefesa());
        super.setArmadura(novaArmadura);
    }
    
     @Override
    public void setArma(ItemArma arma) {
        this.arma = arma;
    }
    
    public void usarConsumivel(ItemConsumivel consumivel, int posiçãomochila) {
        switch (consumivel.getTipo()) {
            case 1:
                if (super.getHitPoints() >= super.getVidaAtual() + consumivel.valorBonus) {
                    super.setVidaAtual(super.getVidaAtual() + consumivel.valorBonus);
                } else {
                    super.setVidaAtual(super.getHitPoints());
                }
                break;
            case 2:
                if (super.getManaPoints() >= super.getManaAtual() + consumivel.valorBonus) {
                    super.setManaAtual(super.getManaAtual() + consumivel.valorBonus);
                } else {
                    super.setManaAtual(super.getManaPoints());
                }
                break;
        }
        removeItemConsumivel(posiçãomochila);
 
    }
    public void addMochilaConsumivel(ItemConsumivel item) throws NullPointerException {
        try {
            mochilaConsumivel.add(item);
        } catch (NullPointerException e) {
            throw new NullPointerException("Mochila cheia");
        }

    }
    public void removeItemConsumivel(int posição){
        this.mochilaConsumivel.remove(posição);
    }
     
    public int getMochilaConsumivelSize(){
        return mochilaConsumivel.size();
    }
    
    public ItemConsumivel getMochilaItemConsumivel(int indice){
        try {
            return mochilaConsumivel.get(indice);
        } catch (NullPointerException e) {
            throw new NullPointerException("Índice Incorreto");
        }
    }
    
    public int retornaIndiceItemConsumivel(String nome){
        //Ainda nao foi testada
        for (int i = 0; i < mochilaConsumivel.size(); i++) {
            if(mochilaConsumivel.get(i).getNome() == nome){
                return i;
            }
        }
        return -1;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    
    
    
    
    public void addMochilaArmaduras(ItemArmadura item) throws NullPointerException {
        try {
            mochilaArmaduras.add(item);
        } catch (NullPointerException e) {
            
            throw new NullPointerException("Mochila cheia");
        }

    }
    public void removeItemArmaduras(int posição){
        this.mochilaArmaduras.remove(posição);
    }
    
      
    public int getMochilaArmadura(){
        return mochilaArmaduras.size();
    }
    public ItemArmadura getMochilaItemArmadura(int indice)throws NullPointerException{
        try {
            return mochilaArmaduras.get(indice);
        } catch (NullPointerException e) {
            throw new NullPointerException("Índice Incorreto");
        }
    }
    
    public int retornaIndiceItemArmadura(String nome){
        //Ainda nao foi testada
        for (int i = 0; i < mochilaArmaduras.size(); i++) {
            if(mochilaArmaduras.get(i).getNome() == nome){
                return i;
            }
        }
        return -1;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
     public void addMochilaArma(ItemArma item) throws NullPointerException {
        try {
            mochilaArma.add(item);
        } catch (NullPointerException e) {
            throw new NullPointerException("Mochila cheia");
        }

    }
    public void removeItemArma(int posição){
        this.mochilaArma.remove(posição);
    }
    
      
    public int getMochilaArma(){
        return mochilaArma.size();
    }
    public ItemArma getMochilaItemArma(int indice) throws NullPointerException{
        try {
            return mochilaArma.get(indice);
        } catch (NullPointerException e) {
            throw new NullPointerException("Índice Incorreto");
        }
    }
    
    public int retornaIndiceItemArma(String nome){
        //Ainda nao foi testada
        for (int i = 0; i < mochilaArmaduras.size(); i++) {
            if(mochilaArmaduras.get(i).getNome() == nome){
                return i;
            }
        }
        return -1;
    }
    
//    private String nomePersonagem;//nome da criatura/player
//
//    private int hitPoints;//pontos de vida maximo
//    private int vidaAtual;//pontos de vida atuais
//    private int manaPoints;//pontos de mana maximo
//    private int manaAtual;//pontos de mana atuais
//    private int defesa;//defesa da criatura/player
//
//    protected int modForça;// modficador de força da criatura/player
//    protected int modInteligencia;//modificador de inteligencia da criatura/player
//    protected int modDestreza;// modificador de destreza da criatura/player
//
//    public Dado dado;//Dado para rolar os valores na classe
//    protected int classe;//classe escolhida pela criatura/player para gerar valores de combate
//    protected ItemArma arma;// implementação futura
//    protected ItemArmadura armadura;// implementação futura
//    public List<AtackMagico> ListaMagias;
    
//     public Jogador(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, int classe, ItemArma arma, ItemArmadura armadura) {
//        super(nomePersonagem, modForça, modInteligencia, modDestreza, classe, arma, armadura);
    
    @Override
    public String toString() {
        String dados;
        
        dados = "Nome: " + this.getNomePersonagem() + "\n" +
                "Hitpoints: " + this.getHitPoints() + "\n" +
                "VidaAtual: " + this.getVidaAtual() + "\n" +
                "ManaPoints: " + this.getManaPoints() + "\n" +
                "ManaAtual: " + this.getManaAtual() + "\n" +
                "Defesa: " + this.getDefesa() + "\n" +
                "Forca: " + this.getModForça() + "\n" +
                "Inteligencia: " + this.getModInteligencia() + "\n" +
                "Destreza: " + this.getModDestreza() + "\n" +
                "Classe: " + this.getClasse() + "\n" +
                "ArmaInicio:\n" + this.getArma().toString() + "\n" +
                "ArmaFim\n" +
                "ArmaduraInicio\n" +
                this.getArmadura().toString() + "\n" +
                "ArmaduraFim\n" +
                "Level: " + this.level + "\n" +
                "BarraXp: " + this.barraDeExp + "\n" +
                "ProxLevel: " + this.proxLevel + "\n";
        
        dados += "MochilaArmaInicio:\n";
        for(ItemArma arma : this.mochilaArma) {
            dados += "ArmaInicio\n";
            dados += arma.toString() + "\n";
            dados += "ArmaFim\n";
        }
        dados += "MochilaArmaFim\n";
        
         dados += "MochilaArmaduraInicio:\n";
        for(ItemArmadura armadura : this.mochilaArmaduras) {
            dados += "ArmaduraIncicio\n";
            dados += armadura.toString() + "\n";
            dados += "ArmaduraFim\n";
        }
        dados += "MochilaArmaduraFim\n";
        
        dados += "MochilaConsumivelInicio:\n";
        for(ItemConsumivel consumivel : this.mochilaConsumivel) {
            dados += "ConsumivelIncio:\n";
            dados += consumivel.toString() + "\n";
            dados += "ConsumivelFim\n";
        }
        dados += "MochilaConsumivelFim\n";
        
        return dados;
    }
}
