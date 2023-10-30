import java.util.Random;

public class Main {
    static Random rnd = new Random(-2147483647);
    public static void main(String[] args) {
        int tamanhoTabela = 10;
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

        int soma = 0;
        for (int i = 0; i < 5; i++) {
            tempo = System.currentTimeMillis();
            hash1.buscarRestoDivisao(valores[i]);
            tempo = System.currentTimeMillis() - tempo;
            soma += tempo;
            System.out.println("\n\nTempo Busca Resto Divisão: " + tempo);
        } System.out.println("\nMédia Tempo Busca Resto Divisão: " + soma * .2d);

        soma = 0;
        for (int i = 0; i < 5; i++) {
            tempo = System.currentTimeMillis();
            hash2.buscarSomaDosAlgarismos(valores[i]);
            tempo = System.currentTimeMillis() - tempo;
            soma += tempo;
            System.out.println("\nTempo Busca Soma Algarismos: " + tempo);
        } System.out.println("\nMédia Tempo Busca Soma Algarismos: " + soma * .2d);

        soma = 0;
        for (int i = 0; i < 5; i++) {
            tempo = System.currentTimeMillis();
            hash3.buscarDobramento(valores[i]);
            tempo = System.currentTimeMillis() - tempo;
            soma += tempo;
            System.out.println("\nTempo Busca Dobramento: " + tempo);
        } System.out.println("\nMédia Tempo Busca Dobramento: " + soma * .2d);
    }
}
