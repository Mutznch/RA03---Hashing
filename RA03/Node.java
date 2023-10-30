public class Node {
    private Registro chave;
    private Node proximo;

    public Node(Registro chave) {
        this.chave = chave;
        proximo = null;
    }

    public void inserir(Registro chave) {
        Node no = new Node(chave);
        if (proximo == null) proximo = no;
        else if (chave.getCodigo() < proximo.getChave().getCodigo()) {
            no.setProximo(proximo);
            proximo = no;
        } else proximo.inserir(chave);
    }

    public boolean buscar(int elemento) {
        if (chave.getCodigo() == elemento) return true;
        if (proximo == null) return false;
        return proximo.buscar(elemento);
    }

    public Registro getChave() {
        return chave;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
