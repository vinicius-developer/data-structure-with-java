package estruturaDados.armazenamentoSequencial;

public class Executa {

    public static void main(String[] args) {

        Aluno a1 = new Aluno("joao");
        Aluno a2 = new Aluno("Maria");

        ArmazenamentoSequencial vetor = new ArmazenamentoSequencial();

        vetor.adiciona(a1);
        vetor.adiciona(a2);

        System.out.println(vetor);

    }

}
