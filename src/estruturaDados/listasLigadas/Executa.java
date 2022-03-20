package estruturaDados.listasLigadas;

public class Executa {

    public static void main(String[] args) {

        ListasLigadas lista = new ListasLigadas();

        System.out.println(lista);
        lista.adicionaNoComeco("agua");
        System.out.println(lista);
        lista.adicionaNoComeco("macarrao");
        System.out.println(lista);
        lista.adicionaNoComeco("batata");
        System.out.println(lista);
        lista.adiciona("springles");
        System.out.println(lista);
        lista.adicionaNoComeco("rufles");
        System.out.println(lista);

        lista.adiciona(5,"casa");
        lista.adiciona("morro");

        System.out.println(lista);

        lista.remove(0);
        lista.remove(1);

        System.out.println(lista);
        System.out.println(lista.tamanho());



    }

}
