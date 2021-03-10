/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;

/**
 *
 * @author mathe
 */
public class GeraItensMagiaNpcs{
    
  ///ITEMS COMUNS  
    
    public ItemArma espadaCurta(){
        AtackFisico ataque= new AtackFisico("Corte", 6, 0, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Espada Curta simples", 1);
        return arma;
    }
    
    public ItemArma espadaLonga(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 1, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Espada Longa simples", 1);
        return arma;
    }
    
    public ItemArma adaga(){
        AtackFisico ataque= new AtackFisico("Perfuração", 4, 1, 1);
        ItemArma arma = new ItemArma(ataque, 4, "Adaga simples", 1);
        return arma;
    }
    
   public ItemArma cajado(){
        AtackFisico ataque= new AtackFisico("Impacto", 6, 0, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Cajado simples", 2);
        return arma;
   } 
   
   public ItemArma tacape(){
        AtackFisico ataque= new AtackFisico("Impacto", 10, 0, 1);
        ItemArma arma = new ItemArma(ataque, -2, "Tacape rudimentar", 1);
        return arma;
   }
   
   public ItemArma arco(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 1, 1);
        ItemArma arma = new ItemArma(ataque, -2, "Arco simples", 1);
        return arma;
   }
   
   public ItemArma lança(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 0, 1);
        ItemArma arma = new ItemArma(ataque, 1, "Lança simples", 1);
        return arma;
   }
   
    public ItemArma maca(){
        AtackFisico ataque= new AtackFisico("Impacto", 8, 1, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Maça simples", 1);
        return arma;
   }
    
   public ItemArma picareta(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 3, 1);
        ItemArma arma = new ItemArma(ataque, 1, "Picareta simples", 1);
        return arma;
   }
   
    public ItemArma tridende(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 0, 1);
        ItemArma arma = new ItemArma(ataque, 1, "Tridente simples", 1);
        return arma;
   }
    
    public ItemArma machadoCortaArvores(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 0, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Machado de um trabalhador", 1);
        return arma;
    }
    
     public ItemArma foice(){
        AtackFisico ataque= new AtackFisico("Corte", 12, 0, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Foice simples", 1);
        return arma;
    }
    
   
 
    
    
    ///////////////// ITENS +1 ARMAS
    
      public ItemArma foiceM1(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 0, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Foice +1", 1);
        return arma;
    }
     
     public ItemArma espadaMagica(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 0, 1);
        ItemArma arma = new ItemArma(ataque, 3, "Espada canalizadora de magia", 2);
        return arma;
    }
    
    
    public ItemArma espadaCurtaM1(){
        AtackFisico ataque= new AtackFisico("Corte", 6, 1, 1);
        ItemArma arma = new ItemArma(ataque, 1, "Espada Curta +1", 1);
        return arma;
    }
    
    public ItemArma espadaLongaM1(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 2, 1);
        ItemArma arma = new ItemArma(ataque, 1, "Espada +1", 1);
        return arma;
    }
    
    public ItemArma adagaM1(){
        AtackFisico ataque= new AtackFisico("Perfuração", 4, 2, 1);
        ItemArma arma = new ItemArma(ataque, 5, "Adaga +1", 1);
        return arma;
    }
    
   public ItemArma cajadoM1(){
        AtackFisico ataque= new AtackFisico("Impacto", 6, 1, 1);
        ItemArma arma = new ItemArma(ataque, 4, "Cajado +1", 2);
        return arma;
   } 
   
   public ItemArma tacapeM1(){
        AtackFisico ataque= new AtackFisico("Impacto", 10, 1, 1);
        ItemArma arma = new ItemArma(ataque, -1, "Tacape rudimentar +1", 1);
        return arma;
   }
   
   public ItemArma arcoM1(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 1, 1);
        ItemArma arma = new ItemArma(ataque, -1, "Arco +1", 1);
        return arma;
   }
   
   public ItemArma lançaM1(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 1, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Lança simples +1", 1);
        return arma;
   }
   
    public ItemArma macaM1(){
        AtackFisico ataque= new AtackFisico("Impacto", 8, 2, 1);
        ItemArma arma = new ItemArma(ataque, 1, "Maça +1", 1);
        return arma;
   }
    
   public ItemArma picaretaM1(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 3, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Picareta +1", 1);
        return arma;
   }
   
    public ItemArma tridendeM1(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 1, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Tridente +1", 1);
        return arma;
   }
    
    public ItemArma machadoCortaArvoresM1(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 1, 1);
        ItemArma arma = new ItemArma(ataque, 1, "Machado +1", 1);
        return arma;
    }
    
    
    
    
    
    /////////////////ITENS ARMAS +2
    
     public ItemArma espadaMagicaM2(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 0, 1);
        ItemArma arma = new ItemArma(ataque, 5, "Espada canalizadora de magia", 1);
        return arma;
    }
    
    
    
    
    public ItemArma espadaCurtaM2(){
        AtackFisico ataque= new AtackFisico("Corte", 6, 2, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Espada Curta +2", 1);
        return arma;
    }
    
    public ItemArma espadaLongaM2(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 2, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Espada Longa +2", 1);
        return arma;
    }
    
    public ItemArma adagaM2(){
        AtackFisico ataque= new AtackFisico("Perfuração", 4, 2, 1);
        ItemArma arma = new ItemArma(ataque, 6, "Adaga +2", 1);
        return arma;
    }
    
   public ItemArma cajadoM2(){
        AtackFisico ataque= new AtackFisico("Impacto", 6, 0, 1);
        ItemArma arma = new ItemArma(ataque, 8, "Cajado +2", 2);
        return arma;
   } 
   
   public ItemArma tacapeM2(){
        AtackFisico ataque= new AtackFisico("Impacto", 10, 2, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Tacape +2", 1);
        return arma;
   }
   
   public ItemArma arcoM2(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 3, 1);
        ItemArma arma = new ItemArma(ataque, 0, "Arco +2", 1);
        return arma;
   }
   
   public ItemArma lançaM2(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 2, 1);
        ItemArma arma = new ItemArma(ataque, 3, "Lança +2", 1);
        return arma;
   }
   
    public ItemArma macaM2(){
        AtackFisico ataque= new AtackFisico("Impacto", 8, 3, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Maça +2", 1);
        return arma;
   }
    
   public ItemArma picaretaM2(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 4, 1);
        ItemArma arma = new ItemArma(ataque, 3, "Picareta +2", 1);
        return arma;
   }
   
    public ItemArma tridendeM2(){
        AtackFisico ataque= new AtackFisico("Perfuração", 8, 2, 1);
        ItemArma arma = new ItemArma(ataque, 3, "Tridente +2", 1);
        return arma;
   }
    
    public ItemArma machadoCortaArvoresM2(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 2, 1);
        ItemArma arma = new ItemArma(ataque, 2, "Machado +2", 1);
        return arma;
    }
    
    
    
    
    
    
    ////////////////////////////////////// ITENS +3
    
     public ItemArma lavaborn(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 10, 2);
        ItemArma arma = new ItemArma(ataque, 8, "Espada flamejante com capcidade de canalizar magias", 2);
        return arma;
    }
    
    
     public ItemArma cimitara(){
        AtackFisico ataque= new AtackFisico("Corte", 8, 3, 2);
        ItemArma arma = new ItemArma(ataque, 8, "Cimitarra cravejada de joias", 1);
        return arma;
    }
    
    public ItemArma katana(){
        AtackFisico ataque= new AtackFisico("Corte", 10, 5, 2);
        ItemArma arma = new ItemArma(ataque, 3, "Katana Wado Ichimonji", 1);
        return arma;
    }
    
    public ItemArma adagaRegicida(){
        AtackFisico ataque= new AtackFisico("Perfuração", 4, 2, 3);
        ItemArma arma = new ItemArma(ataque, 8, "A Regicida", 1);
        return arma;
    }
    
   public ItemArma cajadoAluneth(){
        AtackFisico ataque= new AtackFisico("Impacto", 6, 0, 1);
        ItemArma arma = new ItemArma(ataque, 10, "Aluneth, o Grande Cajado", 2);
        return arma;
   } 
   
   public ItemArma frostmourne(){
        AtackFisico ataque= new AtackFisico("Corte,Frio", 12, 10, 2);
        ItemArma arma = new ItemArma(ataque, -6, "Frostmourne, a espada almadiçoada", 1);
        return arma;
   }
   
   public ItemArma armaDeFogo(){
        AtackFisico ataque= new AtackFisico("Perfuração", 10, 8, 3);
        ItemArma arma = new ItemArma(ataque, -4, "Arma de longa distancia que faz um barulhãoooo quando atita", 1);
        return arma;
   }
   
   
    public ItemArma macaAbençoada(){
        AtackFisico ataque= new AtackFisico("Impacto", 8, 6, 1);
        ItemArma arma = new ItemArma(ataque, 6, "Maça abençoada por um deus", 1);
        return arma;
   }
    
   public ItemArma ashbringer(){
        AtackFisico ataque= new AtackFisico("Corte", 10, 4, 1);
        ItemArma arma = new ItemArma(ataque, 10, "Ashbringer, a espada que guia seus ataques para a luz", 1);
        return arma;
   }
   
    public ItemArma tridendeDoDeusTritão(){
        AtackFisico ataque= new AtackFisico("Perfuração", 12, 2, 2);
        ItemArma arma = new ItemArma(ataque, 4, "Tridente do deus tritão ARLONG", 1);
        return arma;
   }
    
    public ItemArma marteloDeHoots(){
        AtackFisico ataque= new AtackFisico("Corte", 10, 5, 2);
        ItemArma arma = new ItemArma(ataque, 4, "Martelo do heroi Hoots", 1);
        return arma;
    
    }
    
    
    
    
    
    
    
    //////////////////////////////////////////////////////////////////////////// ARMADURAS
    
    public ItemArmadura armaduraAcolchoada(){
        ItemArmadura armadura= new ItemArmadura("Leve", 1, "Armadura Acolchoada");
        return armadura;
    }
    
    public ItemArmadura brunea(){
        ItemArmadura armadura= new ItemArmadura("Media", 3, "Brunea");
        return armadura;
    }
    
    public ItemArmadura lorigaSegmentada(){
        ItemArmadura armadura= new ItemArmadura("Pesada", 5, "Loriga segmentada");
        return armadura;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////ARMADURA +1
    
    public ItemArmadura armaduraCouro(){
        ItemArmadura armadura= new ItemArmadura("Leve", 2, "Armadura couro");
        return armadura;
    }
    
    public ItemArmadura cotaDeMalha(){
        ItemArmadura armadura= new ItemArmadura("Media", 4, "Conta de malha");
        return armadura;
    }
    
    public ItemArmadura meiaArmadura(){
        ItemArmadura armadura= new ItemArmadura("Pesada", 6, "Meia Armadura");
        return armadura;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////ARMADURA +2
    
    public ItemArmadura couroBatido(){
        ItemArmadura armadura= new ItemArmadura("Leve", 3, "Armadura couro couroBatido");
        return armadura;
    }
    
    public ItemArmadura couraça(){
        ItemArmadura armadura= new ItemArmadura("Media", 5, "Couraça");
        return armadura;
    }
    
    public ItemArmadura armaduraCompleta(){
        ItemArmadura armadura= new ItemArmadura("Pesada", 7, "Armadura complta");
        return armadura;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////ARMADURA +3
    
    public ItemArmadura mantoSagrado(){
        ItemArmadura armadura= new ItemArmadura("Leve", 6, "Uma coloração vermelha e preta");
        return armadura;
    }
    
    public ItemArmadura armaduraDeMithril(){
        ItemArmadura armadura= new ItemArmadura("Media", 8, "Armadura um material extremamente raro");
        return armadura;
    }
    
    public ItemArmadura armaduraDeAdamantium(){
        ItemArmadura armadura= new ItemArmadura("Pesada", 6, "Armadura de uma material vindo das estrelas");
        return armadura;
    }
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////// ITENS CONSUMIVEIS
    
    public ItemConsumivel pocaoHpPequena(){
        ItemConsumivel consumivel= new ItemConsumivel(1, 6, "Poção de cura pequena");
        return consumivel;
    }
    
    public ItemConsumivel pocaoHpMedia(){
        ItemConsumivel consumivel= new ItemConsumivel(1, 10, "Poção de cura media");
        return consumivel;
    }
    
    
    public ItemConsumivel pocaoHpGrande(){
        ItemConsumivel consumivel= new ItemConsumivel(1, 14, "Poção de cura pequena");
        return consumivel;
    }
    
    public ItemConsumivel pocaoMpPequena(){
        ItemConsumivel consumivel= new ItemConsumivel(2, 6, "Poção de mana pequena");
        return consumivel;
    }
    
    public ItemConsumivel pocaoMpMedia(){
        ItemConsumivel consumivel= new ItemConsumivel(2, 8, "Poção de mana media");
        return consumivel;
    }
    
    public ItemConsumivel pocaoMpGrande(){
        ItemConsumivel consumivel= new ItemConsumivel(2, 10, "Poção de mana grande");
        return consumivel;
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////MAGIAS
    
    ////////////////////////////////////////////////////////////////////////////////MAGIAS TIER 1
    public AtackMagico adagaMental(){
        AtackMagico magia = new AtackMagico("Adaga mental", 1, 6, 1, 1);
        return magia;
    }
    
    public AtackMagico explosaoDeChamas(){
        AtackMagico magia = new AtackMagico("Explosão de Chamas", 1, 4, 0, 2);
        return magia;
    }
    
    public AtackMagico toqueChocante(){
        AtackMagico magia = new AtackMagico("Toque Chocante", 1, 8, 0, 1);
        return magia;
    }
    
    public AtackMagico cranioVoadorVladisslav(){
        AtackMagico magia = new AtackMagico("Crânio Voador de Vladislav", 2, 12, 0, 1);
        return magia;
    }
    
    public AtackMagico bolaDeFogo(){
        AtackMagico magia = new AtackMagico("Bola de Fogo", 2,6 , 0, 2);
        return magia;
    }
    
    public AtackMagico relampago(){
        AtackMagico magia = new AtackMagico("Relâmpago", 2, 8, 2, 1);
        return magia;
    }
    
    
    
    
    
  //////////////////////////////////////////////////////////////////////////// magias tier 2
    
    
    
    
    public AtackMagico erupcaoGlacial(){
        AtackMagico magia = new AtackMagico("Erupção Glacial", 4, 6, 2, 3);
        return magia;
    }
    
    public AtackMagico lancaIgneaAleph(){
        AtackMagico magia = new AtackMagico("Lança Ígnea de Aleph", 4, 8, 2, 2);
        return magia;
    }
    
    public AtackMagico ferverSangue(){
        AtackMagico magia = new AtackMagico("Ferver Sangue", 4, 6, 4, 2);
        return magia;
    }
    
    public AtackMagico relampagoFlamejanteReynard(){
        AtackMagico magia = new AtackMagico("Relâmpago Flamejante de Raynard", 5, 8, 8, 2);
        return magia;  
    }
    
     public AtackMagico raioPolar(){
        AtackMagico magia = new AtackMagico("Raio Polar", 5, 12, 6, 1);
        return magia;
    }
     
      public AtackMagico talhoInvisivelEdauros(){
        AtackMagico magia = new AtackMagico("Talho Invisivel Edauros", 5, 8, 0, 3);
        return magia;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////// MAGIAS TIER 3
    
      
      
      
      
    public AtackMagico barragemElementalVectorius() {
        AtackMagico magia = new AtackMagico("Barragem Elememntal de Vectorius", 8, 10, 2, 4);
        return magia;
    }
   
    public AtackMagico mataDragão() {
        AtackMagico magia = new AtackMagico("Mata-Dragão", 8, 6, 8, 6);
        return magia;
    }
    
    public AtackMagico toqueMortal() {
        AtackMagico magia = new AtackMagico("Toque Mortal", 8, 20, 2, 2);
        return magia;
    }
    
    public AtackMagico coleraAzgher() {
        AtackMagico magia = new AtackMagico("Cólera de Azgher", 8, 12, 0, 3);
        return magia;
    }
    
    
    
  /////////////////////////////////////////////////////////////////////////////////////////////// NPCS
    
    public NpcInimigo esqueleto() {
        NpcInimigo npc = new NpcInimigo(2, "Os ossos começam a tremer e derrpende aquilo que estava vivo se desfaz", "Esqueleto com espada", 1, 0, 1, 3,
                this.espadaCurta(), this.armaduraAcolchoada());
        return npc;
    }

    public NpcInimigo esqueletoArqueiro() {
        NpcInimigo npc = new NpcInimigo(2, "Os ossos começam a tremer e derrpende aquilo que estava vivo se desfaz.", "Esqueleto com arco", 0, 0, 2, 3,
                this.arco(), this.armaduraAcolchoada());
        return npc;
    }

    public NpcInimigo orc() {
        NpcInimigo npc = new NpcInimigo(4, "A criatura deixa cair sua arma no chão, logo depois elas cai junto.", "Orc", 3, 0, 1, 3,
                this.machadoCortaArvores(), this.lorigaSegmentada());
        return npc;
    }
    
    public NpcInimigo Minotauro() {
        NpcInimigo npc = new NpcInimigo(4, "Derrepende você escuta um a terra tremer e você percebe aquela criatura no chão.", "Minotauro", 3, 0, 0, 1,
                this.machadoCortaArvoresM1(), this.lorigaSegmentada());
        return npc;
    }
     
    public NpcInimigo goblin() {
        NpcInimigo npc = new NpcInimigo(4, "O pequenino some de sua vista, rapidamente você verifica seus bolsos *esta tudo aqui* e você percebe a criatura no seus pés.",
                "Goblin", 0, 1, 3, 3,this.adaga(), this.armaduraAcolchoada());
        return npc;
    }
    
    public NpcInimigo aranhaGigante() {
        NpcInimigo npc = new NpcInimigo(4, "Aquela criatura asquerosa tenta correr subir em suas teais mais acaba caindo.",
                "Aranha Gigante", 3, 1, 0, 3,this.picareta(), this.armaduraCouro());
        return npc;
    }
    
    public NpcInimigo orcChefe() {
        NpcInimigo npc = new NpcInimigo(8, "A criatura deixa cair sua arma no chão, logo depois elas cai junto.", "Orc Chefe", 4, 1, 2, 3,
                this.lançaM1(), this.meiaArmadura());
        return npc;
    }
    
    public NpcInimigo elfoArqueiro() {
        NpcInimigo npc = new NpcInimigo(6, "A criatura esguia coloca a mãona barriga e cai no chão desacordado.", "Elfo Arqueiro", 1, 3, 4, 3,
                this.arcoM1(), this.couroBatido());
        return npc;
    }
    
    public NpcInimigo elfoMago() {
        NpcInimigo npc = new NpcInimigo(6, "A criatura esguia coloca a mãona barriga e cai no chão desacordado.", "Elfo Mago", 0, 5, 2, 2,
                this.cajadoM1(), this.couroBatido());
        return npc;
    }
    
   public NpcInimigo bandido(){
       NpcInimigo npc = new NpcInimigo(6, "O homem cai no chão de bruços.", "Bandido", 1, 2, 4, 3,
                this.adagaM1(), this.couroBatido());
        return npc;
   }
   
   public NpcInimigo centauro(){
       NpcInimigo npc = new NpcInimigo(8, "Aquela criatura gigantescca faz uma ultima investida para cima de você e cai durante o percurso sem vida.", "Centauro", 4, 0, 3, 1,
                this.espadaLongaM1(), this.meiaArmadura());
        return npc;
   }
    
    public NpcInimigo lobo(){
       NpcInimigo npc = new NpcInimigo(6, "A criatura se deita no chão e encolhece", "Centauro", 2, 0, 3, 1,
                this.adagaM2(), this.couroBatido());
        return npc;
   }
    
    public NpcInimigo ogro(){
        NpcInimigo npc = new NpcInimigo(10, "Aquela gigantesca criatura cai no chão depois de muito esforço e você suspira.", "Ogro", 6, 0, 1, 1,
                this.adagaM2(), this.couroBatido());
        return npc;
    }
    
    public NpcInimigo necromante(){
        NpcInimigo npc = new NpcInimigo(8, "Aqeuele sujeito esquisito meio corcunda mal se aguenta mais em pé tenta se apoiar na sua arma mas vai ao chão.", "necromante",
                2, 5, 0, 2,
                this.espadaMagica(), this.couroBatido());
        return npc;
    }
    
    public NpcInimigo zumbi(){
        NpcInimigo npc = new NpcInimigo(4, "A criatura fedorenta começa a se desfazer na sua frente primeiro caindo um dos braços depois a cabeça.", "Zumbi",
                2, -1, 0, 1,this.foice(), this.brunea());
        return npc;
    }
    
    public NpcInimigo dragao(){
        NpcInimigo npc = new NpcInimigo(12, "A criatura começa a voar para tentar escapar mas suas asas rasgadas pelos seus ataques não à ajudam e logo ela cai do céu sem vida."
                , "Zumbi",6, 4, 2, 1,this.picaretaM2(), this.lorigaSegmentada());
        return npc;
    }
    
    
    
    
    
    
    
    
}


      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

