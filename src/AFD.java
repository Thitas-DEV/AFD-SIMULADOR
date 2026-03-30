import java.util.*;

public class AFD {

    private int numEstados;
    private int estadoInicial;
    private Set<Integer> estadosFinais;
    private Set<Character> alfabeto;
    private Map<String, Integer> tabelaTransicao;

    public AFD(int numEstados, int estadoInicial, Set<Integer> estadosFinais, Set<Character> alfabeto) {
        this.numEstados = numEstados;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.alfabeto = alfabeto;
        this.tabelaTransicao = new HashMap<>();
    }

    public void adicionarTransicao(int estado, char simbolo, int destino) {
        tabelaTransicao.put(estado + "," + simbolo, destino);
    }

    public int getTransicao(int estado, char simbolo) {
        return tabelaTransicao.getOrDefault(estado + "," + simbolo, -1);
    }

    public boolean isFinal(int estado) {
        return estadosFinais.contains(estado);
    }

    public boolean simboloValido(char c) {
        return alfabeto.contains(c);
    }

    public int getNumEstados() { return numEstados; }
    public int getEstadoInicial() { return estadoInicial; }
    public Set<Integer> getEstadosFinais() { return estadosFinais; }
    public Set<Character> getAlfabeto() { return alfabeto; }
}
