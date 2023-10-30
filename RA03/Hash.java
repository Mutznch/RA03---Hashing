public class Hash {
    private Node[] tabela;
    private int tamanho;
    private int colisoes = 0;

    public Hash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Node[tamanho];
    }

    public void inserirRestoDivisao(Registro valor) {
        inserir(valor, valor.getCodigo() % tamanho);
    }

    public boolean buscarRestoDivisao(int valor) {
        return buscar(valor, valor % tamanho);
    }

    public void inserirSomaDosAlgarismos(Registro valor) {
        int hashed = 0;
        int j = 1;
        for (int i = 100000000; i >= 1; i = i / 10) {
            hashed += (valor.getCodigo() / i) % j;
            j = j * 10;
        } inserir(valor, hashed % tamanho);
    }

    public boolean buscarSomaDosAlgarismos(int valor) {
        int hashed = 0;
        int j = 1;
        for (int i = 100000000; i >= 1; i = i / 10) {
            hashed += (valor / i) % j;
            j = j * 10;
        } return buscar(valor, hashed % tamanho);
    }

    public void inserirDobramento(Registro valor) {
        int hashed = (valor.getCodigo() / 100000) + (valor.getCodigo() % 10000);
        inserir(valor, hashed % tamanho);
    }

    public boolean buscarDobramento(int valor) {
        int hashed = (valor / 100000) + (valor % 10000);
        return buscar(valor, hashed % tamanho);
    }

    private void inserir(Registro valor, int posicao) {
        if (tabela[posicao] == null)
            tabela[posicao] = new Node(valor);
        else {
            tabela[posicao].inserir(valor);
            colisoes++;
        }
    }

    private boolean buscar(int valor, int posicao) {
        if (tabela[posicao] == null) return false;
        return tabela[posicao].buscar(valor);
    }

    public Node[] getTabela() {
        return tabela;
    }

    public int getColisoes() {
        return colisoes;
    }
}
