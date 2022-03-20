package estruturaDados.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Conjunto {

    private final ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();

    public Conjunto() {
        for(int i = 0; i < 26; i++) {
            tabela.add(new LinkedList<String>());
        }
    }

    public void adiciona(String palavra) {
        String trimWorld = palavra.trim();

        if(!this.contem(trimWorld)) {
            int indice = this.calculaIndiceDaTabela(trimWorld);

            List<String> lista = tabela.get(indice);

            lista.add(trimWorld);
        }

    }

    public void remove(String palavra) {
        String trimWorld = palavra.trim();

        if(this.contem(trimWorld)) {
            int indice = this.calculaIndiceDaTabela(trimWorld);

            List<String> lista = tabela.get(indice);

            lista.remove(palavra);
        }
    }

    public boolean contem(String palavra) {
        int indice = this.calculaIndiceDaTabela(palavra);

        return tabela.get(indice).contains(palavra);
    }

    private int calculaIndiceDaTabela(String palavra) {
        return palavra.toLowerCase().charAt(0) % 26;
    }

    @Override
    public String toString() {
        return this.tabela.toString();
    }
}
