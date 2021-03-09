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
    
    
    
}
