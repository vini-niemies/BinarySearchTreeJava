public class BinarySearchTree {
    No raiz;

    void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerdo =
                    inserirRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito =
                    inserirRecursivo(atual.direito, valor);
        }

        return atual;
    }
}
