package personagens;

public class Mago implements Personagembase {
    private String nome;
    private int forca;
    private int vida;
    private int mana;
    

    public Mago(String nome) {
        this.nome = nome;
        this.forca = 10;  // Valor inicial
        this.vida = 100;  // Valor inicial
        this.mana = 50;   // Valor inicial
       
    }

    @Override
    public void atacar() {
        System.out.println(this.nome + " atacou com sua força!");
    }

    @Override
    public void usarMagia() {
        if (this.mana >= 10) {  // Verifica se o Mago tem mana suficiente
            int danoMagia = 30;  // Dano da magia (exemplo)
            this.mana -= 10;     // Diminui a mana
            System.out.println(this.nome + " lançou uma poderosa magia causando " + danoMagia + " de dano!");
            // Aplica dano ao inimigo, modificando a vida do monstro
            // Lógica do monstro recebendo dano vai ser feita no método de batalha
        } else {
            System.out.println(this.nome + " não tem mana suficiente para usar magia.");
        }
    }

    @Override
    public void fugir() {
        System.out.println(this.nome + " fugiu da batalha!");
    }

    @Override
    public void mostrarStatus() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Força: " + this.forca);
        System.out.println("Vida: " + this.vida);
        System.out.println("Mana: " + this.mana);
       
    }

    // Métodos de acesso aos atributos
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
