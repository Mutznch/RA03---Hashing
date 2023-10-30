import java.util.Random;

public class Main {
    static Random rnd = new Random();
    public static void main(String[] args) {
        int tamanhoVetor = 10;
        int tamanhoTabela = 10;

        Hash hash = new Hash(tamanhoTabela);
        Registro[] vetor = new Registro[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++) {
            vetor[i] = new Registro(rnd.nextInt(100000000, 999999999));
            hash.inserirRestoDivisao(vetor[i]);
        }
    }
}
