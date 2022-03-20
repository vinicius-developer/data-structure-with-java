package estruturaDados.pilha;

import java.util.LinkedList;
import java.util.List;

/**
 * Uma piplha consistem em uma estrutura de dados
 * bem simples que basicamente faz com que possamos
 * adicionar itens no final da uma pilha e sempre que
 * forma remover, removemos do fim.
 *
 * Para inserir e retira itens de uma pilha leva tempo
 * constante
 */
public class Pilha {

    private final List<String> nomes = new LinkedList<String>();

    public void insere(String nome) {
        nomes.add(nome);
    }

    public  String remove() {
        return this.nomes.remove(this.nomes.size() - 1);
    }

    public boolean vazia() {
        return this.nomes.isEmpty();
    }

    @Override
    public String toString() {
        return this.nomes.toString();
    }
}
