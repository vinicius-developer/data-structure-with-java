package intefaces;

public interface ExemploDeLista {

    void adicionaNoComeco(Object elemento);

    void adiciona(Object elemento);

    void adiciona(int posicao, Object elemento);

    Object pega(Integer posicao);

    void remove(Integer posicao);

    Integer tamanho();

    boolean contem(Object o);


}
