package personagens;

public class Monstro {
    private String nome;
    private int vida;
    private int ataque;

    // Construtor
    public Monstro(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    // Métodos de acesso
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque; // Esse método retorna o ataque do monstro
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    // Método para o monstro receber dano
    public void receberDano(int dano) {
        this.vida -= dano;
    }
}
