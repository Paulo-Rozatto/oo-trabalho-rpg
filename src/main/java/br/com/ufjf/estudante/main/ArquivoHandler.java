/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
 */
package br.com.ufjf.estudante.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author paulo
 */
public class ArquivoHandler {

    public static boolean criarJogador(Jogador j) {
        try {
            File jogadores = new File("save");

            if (!jogadores.exists()) {
                jogadores.mkdir();
            }
            File arquivoJogador = new File("save/" + j.getNomePersonagem() + ".txt");
//
//            if (!arquivoJogador.exists()) {
//                arquivoJogador.mkdir();
//            }

            if (arquivoJogador.createNewFile()) {
                FileWriter writer = new FileWriter("save/" + j.getNomePersonagem() + ".txt");

                writer.write(j.toString());
                writer.close();
                return true;
            } else {
                System.out.println("Personagem de mesmo nome já criado");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao tentar criar o arquivo.");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean atualizaJogador(Jogador j) {
        try {
            FileWriter writer = new FileWriter("save/" + j.getNomePersonagem() + ".txt");

            writer.write(j.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao tentar atualizar o arquivo.");
            e.printStackTrace();
            return false;
        }
    }

    public static String[] listarJogadores() {
        File jogadores = new File("save");

        if (!jogadores.exists()) {
            jogadores.mkdir();
        }

        String lista[] = jogadores.list();
        jogadores = new File("test");

        for (int i = 0; i < lista.length; i++) {
            lista[i] = lista[i].substring(0, lista[i].length() - 4);
        }

        return lista;
    }

    public static Jogador lerJogador(String nome) {
        Jogador j;
        String nomePersonagem;
        int modForca, modInteligencia, modDestreza, classe;
        int hitPoints, vidaAtual, manaPoints, manaAtual, defesa, level, barraXp, proxLevel;
        ItemArma arma;
        ItemArmadura armadura = null;
        ItemConsumivel consumivel;

        try {
            File arquivoJogador = new File("save/" + nome + ".txt");
            Scanner reader = new Scanner(arquivoJogador);

            reader.next(); // "Nome:"
            nomePersonagem = reader.nextLine().trim(); // Pega o nome de fato e remove espaços antes e depois

            reader.next(); // "Hitpoits:"
            hitPoints = reader.nextInt();

            reader.next(); // "Vida atual: "
            vidaAtual = reader.nextInt();

            reader.next(); // "ManaPoints: "
            manaPoints = reader.nextInt();

            reader.next(); // "ManaAtual: "
            manaAtual = reader.nextInt();

            reader.next(); // "Defesa:"
            defesa = reader.nextInt();

            reader.next(); // Forca
            modForca = reader.nextInt();

            reader.next(); // "Inteligencia: "
            modInteligencia = reader.nextInt();

            reader.next(); // "Destreza: "
            modDestreza = reader.nextInt();

            reader.next(); // "Classe:"
            classe = reader.nextInt();

            reader.next(); // arma inicio
            arma = lerArma(reader);

            reader.next();
            armadura = lerArmadura(reader);

            reader.next(); // Level
            level = reader.nextInt();

            reader.next(); // BarraXp
            barraXp = reader.nextInt();

            reader.next(); // Prox Level
            proxLevel = reader.nextInt();

            j = new Jogador(nomePersonagem, modForca, modInteligencia, modDestreza, classe, arma, armadura);
            j.setHitPoints(hitPoints);
            j.setVidaAtual(vidaAtual);
            j.setManaPoints(manaPoints);
            j.setManaAtual(manaAtual);
            j.setDefesa(defesa);
            
            //Zerando itens da mochila
            for (int i = j.getMochilaConsumivelSize()-1; i >= 0; i--) {
                j.removeItemConsumivel(i);
            }
            for (int i = j.getMochilaArma()-1; i >= 0; i--) {
                j.removeItemArma(i);
            }
            for (int i = j.getMochilaArmadura()-1; i >= 0; i--) {
                j.removeItemArmaduras(i);
            }

            reader.next();
            while (!reader.next().equals("MochilaArmaFim")) {
                arma = lerArma(reader);
                if (arma != null) {
                    j.addMochilaArma(arma);
                }
            }

            reader.next();
            while (!reader.next().equals("MochilaArmaduraFim")) {
                armadura = lerArmadura(reader);
                if (armadura != null) {
                    j.addMochilaArmaduras(armadura);
                }
            }

            reader.next(); // mochilaConsumivelIncio
            while (!reader.next().equals("MochilaConsumivelFim")) {
                consumivel = lerConsumivel(reader);
                if (consumivel != null) {
                    j.addMochilaConsumivel(consumivel);
                }
            }

            reader.close();
            return j;
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao tentar ler arquivo do jogador " + nome);
            e.printStackTrace();
            return null;
        }
    }

    private static ItemConsumivel lerConsumivel(Scanner reader) throws FileNotFoundException {
        String nome, input;
        int tipo, bonus;

        input = reader.next();
        if (!input.equals("Nome:")) {
            System.out.println("Input invalido: " + input);
            return null;
        }

        nome = reader.nextLine().trim();

        reader.next();
        tipo = reader.nextInt();

        reader.next();
        bonus = reader.nextInt();

        reader.next();

        return new ItemConsumivel(tipo, bonus, nome);
    }

    private static ItemArmadura lerArmadura(Scanner reader) throws FileNotFoundException {
        String nome, tipo, input;
        int bonusDefesa;

        input = reader.next();
        if (!input.equals("Nome:")) {
            System.out.println("Input invalido: " + input);
            return null;
        }

        nome = reader.nextLine().trim();

        reader.next();
        tipo = reader.nextLine();

        reader.next();
        bonusDefesa = reader.nextInt();

        //armadura fim
        reader.next();

        return new ItemArmadura(tipo, bonusDefesa, nome);
    }

    private static ItemArma lerArma(Scanner reader) throws FileNotFoundException {
//        Scanner reader = new Scanner(arquivo);
        String nomeArma, input;
        int bonusAttack, tipo;
        AtackFisico ataque;

        input = reader.next();
        if (!input.equals("Nome:")) {
            System.out.println("Input invalido: " + input);
            return null;
        }

        nomeArma = reader.nextLine().trim();

        reader.next(); // "AtaqueInicio:
        ataque = lerAtackFisico(reader);

        reader.next();
        bonusAttack = reader.nextInt();

        reader.next();
        tipo = reader.nextInt();

        reader.next(); // ArmaFim

        return new ItemArma(ataque, bonusAttack, nomeArma, tipo);
    }

    private static AtackFisico lerAtackFisico(Scanner reader) throws FileNotFoundException {
        String nome;
        int dano, danoB, numDados;

        reader.next(); // "Nome: "
        nome = reader.nextLine();

        reader.next(); // "Dano:" 
        dano = reader.nextInt();

        reader.next(); // "DanoB: "
        danoB = reader.nextInt();

        reader.next(); // "NumDados: "
        numDados = reader.nextInt();

        reader.next(); // "AttackFim"

        return new AtackFisico(nome, dano, danoB, numDados);
    }
}
