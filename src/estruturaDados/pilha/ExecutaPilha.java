package estruturaDados.pilha;

public class ExecutaPilha {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.insere("vinicius");

        System.out.println(pilha);

        pilha.insere("edu");

        System.out.println(pilha);

        pilha.insere("carlos");

        System.out.println(pilha);

        String nome = pilha.remove();

        System.out.println(nome);
        System.out.println(pilha);


    }

}
