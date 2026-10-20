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

    public void exibirEmOrdem(No atual) {
        // Se for a primeira chamada (quando passamos a raiz do lado de fora),
        // podemos apenas tratar a verificação do nó.
        if (atual != null) {
            exibirEmOrdem(atual.esquerdo); // visita o lado esquerdo
            System.out.print(atual.valor + " ");    // visita a raiz
            exibirEmOrdem(atual.direito);  // visita o lado direito
        }

        // se for em pré-ordem ou pós-ordem só altera a ordem da visita
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

    public No remover(No atual, int valor) {
        // Caso base: valor não encontrado ou árvore vazia
        if (atual == null) {
            return null;
        }

        // 1. Navegação para encontrar o nó
        if (valor < atual.valor) {
            atual.esquerdo = remover(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = remover(atual.direito, valor);
        } else {
            // Encontrou o nó a ser removido!

            // Caso 1 e Caso 2: Nó folha ou com apenas 1 filho
            if (atual.esquerdo == null) {
                return atual.direito;
            } else if (atual.direito == null) {
                return atual.esquerdo;
            }

            // Caso 3: Nó com 2 filhos (busca o menor valor da direita inline)
            No aux = atual.direito;
            while (aux.esquerdo != null) {
                aux = aux.esquerdo;
            }

            // Substitui o valor do nó atual pelo sucessor
            atual.valor = aux.valor;

            // Remove o sucessor que ficou duplicado
            atual.direito = remover(atual.direito, aux.valor);
        }

        return atual;
    }


}
