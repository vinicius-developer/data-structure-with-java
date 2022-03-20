package estruturaDados.listaDuplamenteLigada;

import intefaces.ExemploDeLista;


/**
 *
 * Uma lista duplamente ligada é um forma de aprimoramento
 * de ums lista ligada.
 *
 * Nesse caso nossas celulas passam a ter duas referências,
 * uma delas é para o próximo items e outra para o anterior.
 *
 * Nossa classe de lista também passa a armazenar o primeiro
 * elemente o último.
 *
 */
public class ListaDuplamenteLigada implements ExemploDeLista {

    private Celula ultimo;

    private Celula primeiro;

    private int quantidadeDeIntens = 0;

    @Override
    public void adicionaNoComeco(Object elemento) {

        if(this.quantidadeDeIntens == 0) {
            Celula celula = new Celula(elemento);
            this.ultimo = celula;
            this.primeiro = celula;
        } else {
            Celula celula = new Celula(elemento, this.primeiro);
            this.primeiro.setAnterior(celula);
            this.primeiro = celula;
        }

        this.quantidadeDeIntens++;
    }

    @Override
    public void adiciona(Object elemento) {

        if(this.quantidadeDeIntens == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula celula = new Celula(elemento);

            this.ultimo.setProximo(celula);

            celula.setAnterior(this.ultimo);

            this.ultimo = celula;

            this.quantidadeDeIntens++;

        }
    }


    private Celula pegaCelula(Integer posicao) {
        Celula celula = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            celula = celula.getProximo();
        }
        return celula;
    }

    @Override
    public void adiciona(int posicao, Object elemento) {
        if(posicao == 0) {
            this.adicionaNoComeco(elemento);
        } else if (posicao >= this.quantidadeDeIntens) {
            this.adiciona(elemento);
        } else {
            Celula anterior = pegaCelula(posicao-1);
            Celula proxima = pegaCelula(posicao);
            Celula nova = new Celula(elemento, proxima);

            proxima.setAnterior(nova);

            anterior.setProximo(nova);

            nova.setAnterior(anterior);

            this.quantidadeDeIntens++;
        }
    }

    @Override
    public Object pega(Integer posicao) {

        return this.pegaCelula(posicao);

    }

    @Override
    public void remove(Integer posicao) {
        if(posicao == 1) {
            this.removeDoComeco();
        } else if (posicao == this.quantidadeDeIntens - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao-1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            this.quantidadeDeIntens--;
        }
    }

    public void removeDoComeco() {
        this.primeiro = this.primeiro.getProximo();

        this.primeiro.setAnterior(null);

        this.quantidadeDeIntens--;
    }

    public void removeDoFim() {
        if(this.quantidadeDeIntens == 1) {
            this.removeDoComeco();
        } else {
            this.ultimo = this.ultimo.getAnterior();

            this.ultimo.setProximo(null);

            this.quantidadeDeIntens--;
        }
    }


    @Override
    public Integer tamanho() {

        return this.quantidadeDeIntens;

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
        if(this.quantidadeDeIntens == 0) {
            return "[]";
        }

        Celula atual = this.primeiro;

        StringBuilder stringBuilder = new StringBuilder("[");

        for(int i = 0; i < this.quantidadeDeIntens; i++) {
            stringBuilder.append(atual.getElemento());

            stringBuilder.append(", ");

            atual = atual.getProximo();
        }

        stringBuilder.append("]");

        return stringBuilder.toString();

    }

}
