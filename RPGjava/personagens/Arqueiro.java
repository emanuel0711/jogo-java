package personagens;

import util.Dados;

public class Arqueiro implements Personagembase {
    private String nome;
    private int forca;
    private int vida;
    private int mana;

    public Arqueiro(String nome) {
        this.nome = nome;
        this.forca = Dados.rolarDado(1, 8) + 8;   // Rola um dado de 8 lados e soma 8
        this.vida = Dados.rolarDado(1, 18) + 40; // Rola um dado de 18 lados e soma 40
        this.mana = Dados.rolarDado(1, 10) + 10; // Rola um dado de 10 lados e soma 10
    }

    @Override
    public void atacar() {
        System.out.println(nome + " dispara uma flecha precisa, causando " + forca + " de dano!");
    }

    @Override
    public void usarMagia() {
        if (mana > 5) {
            System.out.println(nome + " usa uma flecha encantada, consumindo 5 de mana!");
            mana -= 5;  // Consome 5 de mana por uso de magia
        } else {
            System.out.println(nome + " não tem mana suficiente para usar magia!");
        }
    }

    @Override
    public void fugir() {
        System.out.println(nome + " usa sua agilidade para fugir rapidamente do combate!");
    }

    @Override
    public void mostrarStatus() {
        System.out.println("Classe: Arqueiro | Nome: " + nome + " | Vida: " + vida + " | Força: " + forca + " | Mana: " + mana);
    }

    // Métodos de acesso
    @Override
    public String getNome() { return nome; }
    @Override
    public void setNome(String nome) { this.nome = nome; }
    @Override
    public int getForca() { return forca; }
    @Override
    public void setForca(int forca) { this.forca = forca; }
    @Override
    public int getVida() { return vida; }
    @Override
    public void setVida(int vida) { this.vida = vida; }
    @Override
    public int getMana() { return mana; }
    @Override
    public void setMana(int mana) { this.mana = mana; }
}
