package estruturaDados.conjunto;

/**
 * Conjunto de dados são listas que não aceitam
 * elementos repetidos.
 *
 * Para fazer com que a verificação nos elementos,
 * é implementado uma tabela de espalhamento dentro
 * do conjunto, então para verificar se o item existe,
 * precisamos passar por uma pequena quantidade de items
 * só referente aquele sub conjunto especifico e não em
 * relação ao todo
 *
 * O conjunto do java é implementado na interface Set e
 * a implementação e HashMap
 *
 */
public class ExecutaConjunto {

    public static void main(String[] args) {

        Conjunto conjunto = new Conjunto();

        conjunto.adiciona("Mauricio");

        System.out.println(conjunto);

        conjunto.adiciona("Carlos");

        conjunto.adiciona(" Carlos");

        System.out.println(conjunto);

        System.out.println(conjunto.contem("Carlos"));

        System.out.println(conjunto.contem("Sergio"));

        conjunto.remove("Carlos");

        System.out.println(conjunto);

    }

}
