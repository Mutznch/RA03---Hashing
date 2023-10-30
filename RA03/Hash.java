public class Hash {
    private Node[] tabela;
    private int tamanho;
    private int colisoes;

    public Hash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Node[tamanho];
        colisoes = 0;
    }

    public void inserirRestoDivisao(Registro valor) {
        inserir(valor, valor.getCodigo() % tamanho);
    }

    public boolean buscarRestoDivisao(int valor) {
        return buscar(valor, valor % tamanho);
    }

    public void inserirSomaDosAlgarismos(Registro valor) {
        int n = valor.getCodigo();
        int hashed = 0;
        while (n > 0) {
            hashed += n % 10;
            n /= 10;
        } inserir(valor, hashed % tamanho);
    }

    public boolean buscarSomaDosAlgarismos(int valor) {
        int hashed = 0;
        while (valor > 0) {
            hashed += valor % 10;
            valor /= 10;
        } return buscar(valor, hashed % tamanho);
    }

    public void inserirDobramento(Registro valor) {
        int hashed = (valor.getCodigo() / 10000) + (valor.getCodigo() % 10000);
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
