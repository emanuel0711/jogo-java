package main;

import personagens.*;
import util.*;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Boas-vindas
        System.out.println("Bem-vindo ao Jogo de Aventuras!");
        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();
        clearConsole(); // Limpar a tela após a entrada do nome

        // Escolha de classe
        System.out.println("Escolha sua classe:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");
        System.out.print("Digite o número da sua escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        clearConsole(); // Limpar a tela após a escolha de classe

        Personagembase personagem = null;
        switch (escolha) {
            case 1 -> {
                personagem = new Guerreiro(nome);
                System.out.println("Você escolheu ser um Guerreiro!");
            }
            case 2 -> {
                personagem = new Mago(nome);
                System.out.println("Você escolheu ser um Mago!");
            }
            case 3 -> {
                personagem = new Arqueiro(nome);
                System.out.println("Você escolheu ser um Arqueiro!");
            }
            default -> {
                personagem = new Guerreiro(nome);
                System.out.println("Escolha inválida. Você será um Guerreiro por padrão.");
            }
        }

        // Rolar os dados para cada atributo do personagem
        rolarAtributos(personagem, scanner);
        clearConsole(); // Limpar a tela após rolar os dados

        // Mostrar os atributos do personagem após rolar os dados
        personagem.mostrarStatus();

        // Escolha de caminho: Floresta ou Cidade
        System.out.println("\nAgora, escolha o seu caminho:");
        System.out.println("1 - Ir para a Floresta");
        System.out.println("2 - Ir para a Cidade");
        System.out.print("Digite sua escolha: ");
        int caminho = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        clearConsole(); // Limpar a tela após a escolha do caminho

        // Criando o monstro (Lobo)
        Monstro lobo = new Monstro("Lobo Feroz", 30, 10);

        switch (caminho) {
            case 1 -> {
                // Se escolher a Floresta, enfrentar o Lobo
                System.out.println("\nVocê foi para a Floresta e encontrou um Lobo Feroz!");
                System.out.println("Preparando-se para o combate...");
                batalhaComLobo(personagem, lobo); // Função para a batalha com o lobo
                System.out.println("\nApós a batalha, você segue em direção à Cidade.");
            }
            case 2 -> {
                // Se escolher a Cidade, ganhar +5 de Força
                personagem.setForca(personagem.getForca() + 5);
                System.out.println("\nVocê foi para a Cidade e ganhou +5 de Força!");
                System.out.println("Mas surge um lobo do chao");
                batalhaComLobo(personagem, lobo); // Função para a batalha com o lobo
            }
            default -> {
                System.out.println("Escolha inválida. Você será enviado para a Floresta.");
                batalhaComLobo(personagem, lobo); // Caso a escolha seja inválida, vai para o lobo
            }
        }

        // Após enfrentar o lobo, o jogador pode escolher um novo caminho
        System.out.println("\nApós a batalha, você pode escolher seu próximo passo:");
        System.out.println("1 - Ir para a Caverna");
        System.out.println("2 - Ir para a Montanha");
        System.out.print("Digite sua escolha: ");
        int novoCaminho = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        clearConsole(); // Limpar a tela após a escolha do novo caminho

        // Lógica para o novo caminho
        switch (novoCaminho) {
            case 1 -> {
                System.out.println("\nVocê entra na Caverna e encontra um novo desafio!");
                
            }
            case 2 -> {
                System.out.println("\nVocê escala a Montanha e encontra um inimigo mais forte!");
          
            }
            default -> {
                System.out.println("Escolha inválida. Você encontra um novo monstro no caminho!");
      
            }
        }

        // O último desafio: o Lobo Rei
        System.out.println("\nVocê chega ao seu destino final e encontra o Lobo Rei!");
        Monstro loboRei = new Monstro("Lobo Rei", 50, 20);
        batalhaComLoboRei(personagem, loboRei); // Função para o combate com o Lobo Rei

        scanner.close();
    }

    // Função para rolar os dados de atributos
    public static void rolarAtributos(Personagembase personagem, Scanner scanner) {
        // Rolar Força
        System.out.println("\nPressione Enter para rolar o dado de Força.");
        scanner.nextLine();  // Espera o jogador pressionar Enter
        int forca = Dados.rolarDado(1, 10) + 10;  // Exemplo de rolagem de dado
        personagem.setForca(forca);
        System.out.println("Força rolada: " + forca);
        clearConsole();
        // Rolar Vida
        System.out.println("\nPressione Enter para rolar o dado de Vida.");
        scanner.nextLine();  // Espera o jogador pressionar Enter
        int vida = Dados.rolarDado(1, 20) + 50;  // Exemplo de rolagem de dado
        personagem.setVida(vida);
        System.out.println("Vida rolada: " + vida);
        clearConsole();
        // Rolar Mana
        System.out.println("\nPressione Enter para rolar o dado de Mana.");
        scanner.nextLine();  // Espera o jogador pressionar Enter
        int mana = Dados.rolarDado(2, 6) + 10;  // Exemplo de rolagem de dado
        personagem.setMana(mana);
        System.out.println("Mana rolada: " + mana);
        clearConsole();
    }

    // Função para limpar o console
    public static void clearConsole() {
        try {
            
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar o console.");
        }
    }

    public static void batalhaComLobo(Personagembase personagem, Monstro lobo) {
        Scanner scanner = new Scanner(System.in);
    
        while (personagem.getVida() > 0 && lobo.getVida() > 0) {
            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar magia");
            System.out.println("3 - Fugir");
            System.out.print("Digite sua escolha: ");
            int acao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada
            clearConsole();
            switch (acao) {
                case 1:
                    personagem.atacar();
                    lobo.receberDano(personagem.getForca());
                    System.out.println("Lobo Feroz recebeu " + personagem.getForca() + " de dano e tem " + lobo.getVida() + " de vida restante.");
                    break;
                case 2:
                    personagem.usarMagia();
                    // Aqui, quando a magia for usada, o dano pode ser calculado e o monstro receberá o dano
                    lobo.receberDano(30);  // Dano da magia (ajuste conforme necessário)
                    System.out.println("Lobo Feroz recebeu 30 de dano de magia e tem " + lobo.getVida() + " de vida restante.");
                    break;
                case 3:
                    personagem.fugir();
                    break;
                default:
                    System.out.println("Ação inválida.");
            }
    
            // Lobo ataca de volta
            if (lobo.getVida() > 0) {
                System.out.println("\nO Lobo Feroz ataca!");
                personagem.setVida(personagem.getVida() - lobo.getAtaque());
                System.out.println(personagem.getNome() + " perdeu " + lobo.getAtaque() + " de vida. Vida restante: " + personagem.getVida());
            }
        }
    
        // Verifica o resultado da batalha
        if (personagem.getVida() <= 0) {
            System.out.println(personagem.getNome() + " foi derrotado pelo Lobo Feroz!");
        } else if (lobo.getVida() <= 0) {
            System.out.println("O Lobo Feroz foi derrotado!");
        }
    }
    

    // Função para a batalha com o Lobo Rei
    public static void batalhaComLoboRei(Personagembase personagem, Monstro loboRei) {
        Scanner scanner = new Scanner(System.in);

        while (personagem.getVida() > 0 && loboRei.getVida() > 0) {
            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar magia");
            System.out.println("3 - Fugir");
            System.out.print("Digite sua escolha: ");
            int acao = scanner.nextInt();
            scanner.nextLine(); 
            clearConsole();
            switch (acao) {
                case 1:
                    personagem.atacar();
                    loboRei.receberDano(personagem.getForca());
                    System.out.println("Lobo Rei recebeu " + personagem.getForca() + " de dano e tem " + loboRei.getVida() + " de vida restante.");
                    break;
                case 2:
                    personagem.usarMagia();
                    break;
                case 3:
                    personagem.fugir();
                    break;
                default:
                    System.out.println("Ação inválida.");
            }

            // Lobo Rei ataca de volta
            if (loboRei.getVida() > 0) {
                System.out.println("\nO Lobo Rei ataca!");
                personagem.setVida(personagem.getVida() - loboRei.getAtaque());
                System.out.println(personagem.getNome() + " perdeu " + loboRei.getAtaque() + " de vida. Vida restante: " + personagem.getVida());
            }
        }

        // Verifica o resultado da batalha
        if (personagem.getVida() <= 0) {
            System.out.println(personagem.getNome() + " foi derrotado pelo Lobo Rei!");
        } else if (loboRei.getVida() <= 0) {
            System.out.println("O Lobo Rei foi derrotado! Você venceu a jornada!");
        }
    }
}
