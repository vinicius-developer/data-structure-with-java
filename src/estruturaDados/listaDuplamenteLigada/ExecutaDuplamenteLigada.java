package estruturaDados.listaDuplamenteLigada;

public class ExecutaDuplamenteLigada {

    public static void main(String[] args) {

        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();

        System.out.println(lista);
        lista.adicionaNoComeco("TESTE");
        System.out.println(lista);
        lista.adiciona("TESTE1");
        System.out.println(lista);
        lista.adiciona(1, "TESTE2");
        System.out.println(lista);
        lista.adiciona(4, "TESTE2");
        System.out.println(lista);
        lista.removeDoComeco();
        System.out.println(lista);
        lista.removeDoFim();
        System.out.println(lista);
        lista.adiciona("TESTE3");
        lista.remove(0);
        System.out.println(lista);

        System.out.println(lista.contem("TESTE3"));
        System.out.println(lista.contem("TESTE1"));


    }

}
