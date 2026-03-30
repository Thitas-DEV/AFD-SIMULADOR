public class Main {

    public static void main(String[] args) {
        Console console = new Console();

        AFD afd = console.construirAFD();

        console.exibirTabela(afd);

        Simulador simulador = new Simulador(afd);

        console.iniciarLoop(simulador);
    }
}
