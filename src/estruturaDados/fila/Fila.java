package estruturaDados.fila;

import java.util.LinkedList;
import java.util.List;

/**
 * Uma fila é ao contrário da pilha
 * ou seja o primeiro a entrar em uma fila
 * é o primeiro que irá sair dela.
 */
public class Fila {

    private final List<String> list = new LinkedList<String>();

    public void adiciona(String item) {
        this.list.add(item);
    }

    public String remove() {
        return this.list.remove(0);
    }

    public boolean vazio() {
        return this.list.isEmpty();
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}
