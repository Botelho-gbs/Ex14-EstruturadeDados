class ABB {
    private Nodo raiz;

    public ABB() {
        this.raiz = null;
    }

    // Método para inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private Nodo inserirRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }

        return raiz;
    }

    // Método para buscar um valor na árvore
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (valor == raiz.valor) {
            return true;
        }

        return valor < raiz.valor ? buscarRecursivo(raiz.esquerda, valor) : buscarRecursivo(raiz.direita, valor);
    }

    // Método para imprimir a árvore (ordem simétrica)
    public void imprimir() {
        imprimirRecursivo(raiz);
    }

    private void imprimirRecursivo(Nodo raiz) {
        if (raiz != null) {
            imprimirRecursivo(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            imprimirRecursivo(raiz.direita);
        }
    }

    // Método para remover um valor da árvore
    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private Nodo removerRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = removerRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = removerRecursivo(raiz.direita, valor);
        } else {
            // Caso 1: Nodo com apenas um filho ou nenhum
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // Caso 2: Nodo com dois filhos
            raiz.valor = minValor(raiz.direita);
            raiz.direita = removerRecursivo(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    // Método auxiliar para encontrar o valor mínimo em uma árvore
    private int minValor(Nodo raiz) {
        int minv = raiz.valor;
        while (raiz.esquerda != null) {
            minv = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return minv;
    }

    public static void main(String[] args) {
        ABB arvore = new ABB();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Impressão da árvore em ordem:");
        arvore.imprimir();

        System.out.println("\n\nBusca por 40: " + arvore.buscar(40));
        System.out.println("Busca por 90: " + arvore.buscar(90));

        System.out.println("\nRemovendo 20");
        arvore.remover(20);
        System.out.println("Impressão da árvore em ordem:");
        arvore.imprimir();

        System.out.println("\nRemovendo 30");
        arvore.remover(30);
        System.out.println("Impressão da árvore em ordem:");
        arvore.imprimir();

        System.out.println("\nRemovendo 50");
        arvore.remover(50);
        System.out.println("Impressão da árvore em ordem:");
        arvore.imprimir();
    }
}
