package estruturaDados.armazenamentoSequencial;

import java.util.Arrays;

public class ArmazenamentoSequencial {

    private Aluno[] alunos = new Aluno[100];

    private int quantidadeDeItens = 0;

    public void adiciona(Aluno aluno) {
        this.garanteEspaco();

        this.alunos[this.quantidadeDeItens] = aluno;

        this.quantidadeDeItens++;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.quantidadeDeItens;
    }

    private void garanteEspaco() {
        if(this.quantidadeDeItens == alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length*2];
            for(int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];
            }

            this.alunos = novoArray;
        }
    }

    public void adiciona(int posicao, Aluno aluno) {

        this.garanteEspaco();

        if(!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("posicao invalida");
        }

        for(int i = this.quantidadeDeItens - 1; i >= posicao; i -= 1) {
            alunos[i+1] = alunos[i];
        }

        alunos[posicao] = aluno;

        this.quantidadeDeItens++;

    }

    private boolean posicaoOcuoada(int posicao) {
        return posicao >= 0 && posicao < this.quantidadeDeItens;
    }

    public Aluno pega(int posicao) {
        if (!this.posicaoOcuoada(posicao)) {
            throw  new IllegalArgumentException("posicao inexistente");
        }

        return this.alunos[posicao];
    }

    public void remove(int posicao) {
        for(int i = posicao; i < this.quantidadeDeItens; i++) {
            this.alunos[i] = this.alunos[i + 1];
        }

        this.quantidadeDeItens--;

        this.alunos[this.quantidadeDeItens] = null;

    }

    public boolean contem(Aluno aluno) {
        for(int i = 0; i < this.quantidadeDeItens; i++) {
            if(aluno.equals(this.alunos[i])) {
                return true;
            }
        }

        return false;
    }

    public int tamanho() {
        return this.quantidadeDeItens;
    }

    @Override
    public String toString() {
        return Arrays.toString(alunos);
    }

}
