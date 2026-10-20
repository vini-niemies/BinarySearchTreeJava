public class BinarySearchTree {
    No raiz;

    void inserir(int valor) {
        raiz = inserir(raiz, valor); // isso permite inserir o primeiro nó, quando a raiz ainda é null
    }

    No inserir(No atual, int valor) {
        // atual = nó que o metodo tá analisando no momento
        // valor = novo valor a ser inserido na árvore

        if (atual == null) {  //chegamos na posição vazia
            return new No(valor);  // criamos o nó e devolvemos a sua referência
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserir(atual.esquerdo, valor);  // se o valor novo for menor que o valor analisado, ele vai atualizar o valor do nó esquerdo filho e guardar a referência (valor)

        } else if (valor > atual.valor) {
            atual.direito = inserir(atual.direito, valor); // se o valor novo for maior que o valor analisado, ele vai atualizar o valor do nó direito filho e guardar a referência (valor)
        }

        return atual; // retorna valor atual para guardar referência ao nó antigo
    }


    boolean buscar(No atual, int valor) {  // implementa boolean na busca porque só pode ser True/false
        if (atual == null) {
            return false;  // se atual for null, vai retornar false (valor não encontrado)
        }

        if (valor == atual.valor) {  // se o valor atual = valor procurado, vai retornar true (valor encontrado)
            return true;
        }

        if (valor < atual.valor) {
            return buscar(atual.esquerdo, valor);  // se o valor procurado < valor atual, o atual vira o filho esquerdo
        } else {
            return buscar(atual.direito, valor); // se o valor procurado > valor atual, o atual vira o filho direito
        }

        // metodo inserir devolve um nó para conectar o novo nó, enquanto o metodo buscar devolve boolean
    }

    No removerFolha(No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor < atual.valor) {
            atual.esquerdo = removerFolha(atual.esquerdo, valor); // valor menor = ir para a esquerda

        } else if (valor > atual.valor) {
            atual.direito = removerFolha(atual.direito, valor); // valor maior = ir para a direita

        } else {

            if (atual.esquerdo == null && atual.direito == null) {
                return null;
            }  // só remover o nó quando encontramos o valor correto
        }

        return atual;
    }

    public void exibirEmOrdem() {
        System.out.print("Árvore atual: ");
        exibirEmOrdemRecursivo(raiz);  // chama o metodo privado e envia a raiz como ponto de partida
        System.out.println();
    }

    private void exibirEmOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.esquerdo); // visita o lado esquerdo
            System.out.print(atual.valor + " ");    // visita a raiz
            exibirEmOrdemRecursivo(atual.direito);  // visita o lado direito

            // se for em pré-ordem ou pós-ordem só altera a ordem da visita
        }
    }

}
