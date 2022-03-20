package estruturaDados.armazenamentoSequencial;

public class Aluno {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object aluno) {
       Aluno outro = (Aluno) aluno;

       return outro.getNome()
               .equals(this.nome);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
