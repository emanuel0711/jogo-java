package personagens;

import util.Dados;

public class Guerreiro implements Personagembase {
    private String nome;
    private int forca;
    private int vida;
    private int mana;

    public Guerreiro(String nome) {
        this.nome = nome;
        this.forca = Dados.rolarDado(2, 15) + 10;  // Rola um dado de 10 lados e soma 10
        this.vida = Dados.rolarDado(3, 20) + 50;   // Rola um dado de 20 lados e soma 50
        this.mana = Dados.rolarDado(1, 5) + 5;     // Rola um dado de 5 lados e soma 5
    }

    @Override
    public void atacar() {
        System.out.println(nome + " ataca com sua espada, causando " + forca + " de dano!");
    }

    @Override
    public void usarMagia() {
        if (mana > 0) {
            System.out.println(nome + " usa um feitiço de ataque, consumindo " + mana + " de mana!");
            mana -= 5;  // Consome 5 de mana por uso de magia
        } else {
            System.out.println(nome + " não tem mana suficiente para usar magia!");
        }
    }

    @Override
    public void fugir() {
        // Como o personagem não pode fugir, podemos apenas descrever que a fuga falhou
        System.out.println(nome + " tenta fugir, mas não pode. A luta continua!");
    }

    @Override
    public void mostrarStatus() {
        System.out.println("Classe: Guerreiro | Nome: " + nome + " | Vida: " + vida + " | Força: " + forca + " | Mana: " + mana);
    }

    // Métodos de acesso aos atributos (Getters e Setters)
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getForca() {
        return forca;
    }

    @Override
    public void setForca(int forca) {
        this.forca = forca;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }
}
