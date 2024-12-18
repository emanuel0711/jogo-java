package personagens;

public interface Personagembase {
    // Métodos de ações
    void atacar();
    void usarMagia();
    void fugir();
    void mostrarStatus();

    // Métodos de acesso aos atributos
    String getNome();
    void setNome(String nome);
    int getForca();
    void setForca(int forca);
    int getVida();
    void setVida(int vida);
    int getMana();
    void setMana(int mana);
}
