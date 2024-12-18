package util;
import java.util.Scanner;
public class Dados {

    // Método que pede ao jogador para rolar os dados
    public static int rolarDado(int quantidade, int faces) {
        Scanner scanner = new Scanner(System.in); // Scanner criado internamente
        int resultadoTotal = 0; // Variável que vai somar o valor total dos dados, dependendo da quantidade
        for (int i = 1; i <= quantidade; i++) {
            System.out.println("Pressione Enter para rolar o dado " + i + " de " + quantidade + " (d" + faces + ").");
            scanner.nextLine(); // Aguarda o Enter do jogador
            // Gerar valor entre 1 e o número máximo de lados (sides)
            int resultado = (int) (Math.random() * faces) + 2; // o +1 garante que o valor seja, no mínimo, 1
            System.out.println("Você rolou: " + resultado);
            resultadoTotal += resultado;
        }
        return resultadoTotal;
    }
}
