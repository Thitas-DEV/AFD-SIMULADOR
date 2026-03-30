import java.util.*;

public class Console {

    private Scanner sc;

    public Console() {
        this.sc = new Scanner(System.in);
    }

    public AFD construirAFD() {
        System.out.print("Numero de estados: ");
        int numEstados = lerInteiroPositivo();

        System.out.print("Estado inicial: ");
        int estadoInicial = lerEstado(numEstados);

        System.out.print("Quantos estados finais: ");
        int qtdFinais = lerInteiroPositivo();

        Set<Integer> estadosFinais = new HashSet<>();
        for (int i = 0; i < qtdFinais; i++) {
            System.out.print("Estado final " + (i + 1) + ": ");
            estadosFinais.add(lerEstado(numEstados));
        }

        System.out.print("Alfabeto (sem espacos, ex: ab01): ");
        Set<Character> alfabeto = new LinkedHashSet<>();
        for (char c : sc.next().trim().toCharArray()) {
            alfabeto.add(c);
        }

        AFD afd = new AFD(numEstados, estadoInicial, estadosFinais, alfabeto);

        System.out.println("\nDefina as transicoes (-1 para indefinida):");
        for (int q = 0; q < numEstados; q++) {
            for (char c : alfabeto) {
                System.out.print("  d(q" + q + ", " + c + ") = ");
                int destino;
                try {
                    destino = Integer.parseInt(sc.next().trim());
                } catch (NumberFormatException e) {
                    destino = -1;
                }
                if (destino != -1 && (destino < 0 || destino >= numEstados)) {
                    destino = -1;
                }
                afd.adicionarTransicao(q, c, destino);
            }
        }

        return afd;
    }

    public void exibirTabela(AFD afd) {
        System.out.println("\nTabela de transicoes:");
        System.out.print("       ");
        for (char c : afd.getAlfabeto()) System.out.printf("  %c  ", c);
        System.out.println();

        for (int q = 0; q < afd.getNumEstados(); q++) {
            boolean isInicial = q == afd.getEstadoInicial();
            boolean isFinal = afd.isFinal(q);

            String marcador;
            if (isInicial && isFinal) marcador = "->*q";
            else if (isInicial)       marcador = "-> q";
            else if (isFinal)         marcador = "  *q";
            else                      marcador = "   q";

            System.out.print(marcador + q + ": ");
            for (char c : afd.getAlfabeto()) {
                int dest = afd.getTransicao(q, c);
                System.out.print(dest == -1 ? "  -  " : "  q" + dest + " ");
            }
            System.out.println();
        }
        System.out.println("\n-> = inicial   * = final");
    }

    public void iniciarLoop(Simulador simulador) {
        while (true) {
            System.out.print("\nPalavra (ou 'sair'): ");
            String palavra = sc.next().trim();
            if (palavra.equalsIgnoreCase("sair")) break;
            simulador.simular(palavra);
        }
        sc.close();
    }

    private int lerInteiroPositivo() {
        while (true) {
            try {
                int v = Integer.parseInt(sc.next().trim());
                if (v > 0) return v;
                System.out.print("Valor invalido. Tente novamente: ");
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Tente novamente: ");
            }
        }
    }

    private int lerEstado(int total) {
        while (true) {
            try {
                int v = Integer.parseInt(sc.next().trim());
                if (v >= 0 && v < total) return v;
                System.out.print("Estado invalido. Tente novamente: ");
            } catch (NumberFormatException e) {
                System.out.print("Estado invalido. Tente novamente: ");
            }
        }
    }
}
