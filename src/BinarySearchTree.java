public class BinarySearchTree {
    No raiz;

    void inserir(int valor) {
        raiz = inserirValor(raiz, valor); // isso permite inserir o primeiro nó, quando a raiz ainda é null
    }

    No inserirValor(No atual, int valor) {
        // atual = nó que o metodo tá analisando no momento
        // valor = novo valor a ser inserido na árvore

        if (atual == null) {  //chegamos na posição vazia
            return new No(valor);  // criamos o nó e devolvemos a sua referência
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserirValor(atual.esquerdo, valor);  // se o valor novo for menor que o valor analisado, ele vai atualizar o valor do nó esquerdo filho e guardar a referência (valor)

        } else if (valor > atual.valor) {
            atual.direito = inserirValor(atual.direito, valor); // se o valor novo for maior que o valor analisado, ele vai atualizar o valor do nó direito filho e guardar a referência (valor)
        }

        return atual; // retorna valor atual para guardar referência ao nó antigo
    }
}
