public class BinarySearchTree {
    No raiz;

    void inserir(int valor) {
        raiz = inserirValor(raiz, valor);
    }

    No inserirValor(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerdo =
                    inserirValor(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito =
                    inserirValor(atual.direito, valor);
        }

        return atual;
    }
}
