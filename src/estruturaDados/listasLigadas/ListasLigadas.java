package estruturaDados.listasLigadas;

import intefaces.ExemploDeLista;

/**
 * Uma lista ligada também consegue gardar
 * dados de forma sequencial, mas desta forma
 * é mais fácil de modificar dados armazenado no
 * meio dela
 *
 * Funcionamento
 *
 * Em um vetor os elementos estão ao lado do outro
 * na memoria
 *
 * Em uma lista ligada os elementos estão em diversos
 * pontos diferentes e esses pontos serão acessados
 * através de refência em cada uma dos itens, então
 * o item um tera um referência para onde está o item
 * dois e o item dois terá um refência para o item anterior
 * e para o próximo item.
 *
 */
public class ListasLigadas implements ExemploDeLista {

    private Celula primeiro = null;

    private Celula ultimo = null;

    private Integer totalDeElementos = 0;

    @Override
    public void adicionaNoComeco(Object elemento) {
        Celula novo = new Celula(elemento, this.primeiro);

        this.primeiro = novo;

        if(this.totalDeElementos == 0) {
            this.ultimo = this.primeiro;
        }

        this.totalDeElementos++;
    }

    @Override
    public void adiciona(Object elemento) {

        if(this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula novo = new Celula(elemento, null);

            this.ultimo.setProximo(novo);

            this.ultimo = novo;

            this.totalDeElementos++;
        }

    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }


    private Celula pegaCelula(int posicao) {
        if(!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posicao impossivel");
        }

        Celula atual = this.primeiro;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }

    @Override
    public void adiciona(int posicao, Object elemento) {
        if(posicao == 0 ) {
            this.adicionaNoComeco(elemento);
        } else if(posicao == this.totalDeElementos) {
            this.adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao-1);

            Celula novaCelula = new Celula(elemento, anterior.getProximo());

            anterior.setProximo(novaCelula);

            this.totalDeElementos++;
        }

    }

    @Override
    public Object pega(Integer posicao) {

        return this.pegaCelula(posicao).getElemento();

    }

    public void removeDoComeco() {
        if(this.totalDeElementos == 0) {
            throw new IllegalArgumentException("lista vazia");
        }

        this.primeiro = this.primeiro.getProximo();

        this.totalDeElementos--;

        if(this.totalDeElementos == 0) {
            this.ultimo = null;
        }
    }

    @Override
    public void remove(Integer posicao) {

        if(posicao == 0) {
            this.removeDoComeco();
        }  else {
            Celula anterior = this.pegaCelula(posicao - 1);

            Celula removida = this.pegaCelula(posicao);

            anterior.setProximo(removida.getProximo());

            this.totalDeElementos--;
        }

    }

    @Override
    public Integer tamanho() {
        return this.totalDeElementos;
    }

    @Override
    public boolean contem(Object o) {
        Celula elemento = this.primeiro;

        while (elemento != null) {
            if(elemento.getElemento().equals(o)) {
                return true;
            }

            elemento = elemento.getProximo();
        }

        return false;
    }

    @Override
    public String toString() {
        if(this.totalDeElementos == 0) {
            return "[]";
        }

        Celula atual = this.primeiro;

        StringBuilder stringBuilder = new StringBuilder("[");

        for(int i = 0; i < this.totalDeElementos; i++) {
            stringBuilder.append(atual.getElemento());

            stringBuilder.append(", ");

            atual = atual.getProximo();
        }

        stringBuilder.append("]");

        return stringBuilder.toString();

    }
}
