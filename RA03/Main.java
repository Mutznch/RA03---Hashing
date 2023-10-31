import java.util.Random;

public class Main {
    static Random rnd = new Random(-2147483647);
    public static void main(String[] args) {
        int tamanhoTabela = 100000;
        int tamanhoVetor = 5000000;

        Hash hash1 = new Hash(tamanhoTabela);
        Hash hash2 = new Hash(tamanhoTabela);
        Hash hash3 = new Hash(tamanhoTabela);
        Registro[] vetor = new Registro[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++) {
            vetor[i] = new Registro(rnd.nextInt(100000000, 999999999));
        }

        long tempo = System.currentTimeMillis();
        for (int i = 0; i < tamanhoVetor; i++) {
            hash1.inserirRestoDivisao(vetor[i]);
        } tempo = System.currentTimeMillis() - tempo;
        System.out.println("Tempo Inserção Resto Divisão: " + tempo +
                "\nNúmero de colisões: " + hash1.getColisoes());

        tempo = System.currentTimeMillis();
        for (int i = 0; i < tamanhoVetor; i++) {
            hash2.inserirSomaDosAlgarismos(vetor[i]);
        } tempo = System.currentTimeMillis() - tempo;
        System.out.println("\nTempo Inserção Soma Algarismos: " + tempo +
                "\nNúmero de colisões: " + hash2.getColisoes());

        tempo = System.currentTimeMillis();
        for (int i = 0; i < tamanhoVetor; i++) {
            hash3.inserirDobramento(vetor[i]);
        } tempo = System.currentTimeMillis() - tempo;
        System.out.println("\nTempo Inserção Dobramento: " + tempo +
                "\nNúmero de colisões: " + hash3.getColisoes());

        int[] valores = new int[5];
        valores[0] = 401800100;
        valores[1] = 990819876;
        valores[2] = 558990957;
        valores[3] = 501196423;
        valores[4] = 890049968;

        Hash.comparacoes = 0;
        tempo = System.currentTimeMillis();
        for (int i = 0; i < 5; i++)
            hash1.buscarRestoDivisao(valores[i]);
        tempo = System.currentTimeMillis() - tempo;
        System.out.println("\nTempo Busca Resto Divisão: " + tempo +
                "\nComparações Busca Resto Divisão: " + Hash.comparacoes);

        Hash.comparacoes = 0;
        tempo = System.currentTimeMillis();
        for (int i = 0; i < 5; i++)
            hash2.buscarSomaDosAlgarismos(valores[i]);
        tempo = System.currentTimeMillis() - tempo;
        System.out.println("\nTempo Busca Soma Algarismos: " + tempo +
                "\nComparações Busca Soma Algarismos: " + Hash.comparacoes);

        Hash.comparacoes = 0;
        tempo = System.currentTimeMillis();
        for (int i = 0; i < 5; i++)
            hash3.buscarDobramento(valores[i]);
        tempo = System.currentTimeMillis() - tempo;
        System.out.println("\nTempo Busca Dobramento: " + tempo +
                "\nComparações Busca Dobramento: " + Hash.comparacoes);
    }
}
