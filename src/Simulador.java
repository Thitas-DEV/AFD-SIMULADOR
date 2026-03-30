public class Simulador {

    private AFD afd;

    public Simulador(AFD afd) {
        this.afd = afd;
    }

    public void simular(String palavra) {
        for (char c : palavra.toCharArray()) {
            if (!afd.simboloValido(c)) {
                System.out.println("Simbolo '" + c + "' nao pertence ao alfabeto. REJEITADA.");
                return;
            }
        }

        int estadoAtual = afd.getEstadoInicial();
        System.out.println("Inicio: q" + estadoAtual);

        for (int i = 0; i < palavra.length(); i++) {
            char simbolo = palavra.charAt(i);
            int proximo = afd.getTransicao(estadoAtual, simbolo);

            if (proximo == -1) {
                System.out.println("d(q" + estadoAtual + ", " + simbolo + ") indefinida. REJEITADA.");
                return;
            }

            System.out.println("d(q" + estadoAtual + ", " + simbolo + ") = q" + proximo);
            estadoAtual = proximo;
        }

        if (afd.isFinal(estadoAtual)) {
            System.out.println("q" + estadoAtual + " e estado final. ACEITA.");
        } else {
            System.out.println("q" + estadoAtual + " nao e estado final. REJEITADA.");
        }
    }
}
