import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    private static final double CASE_SUCESSO = 2000.0;

    public static void main(String[] args) {
        String[] candidatos = {"Eviyn", "Suzana", "Pedro", "Caio", "Benedito"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            tentativasRealizadas++;
        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na tentativa " + tentativasRealizadas);
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas + " alcançado");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"Eviyn", "Suzana", "Pedro", "Caio", "Benedito"};
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice + 1) + " é " + candidatos[indice]);
        }
        System.out.println("A forma abreviada de interação for each");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"Felipe", "Marcia", "José", "Samuel", "Eviyn", "Suzana", "Pedro", "Caio", "Benedito"};
        int candidatoSelecionado = 0;
        int candidatoAtual = 0;

        while (candidatoSelecionado < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorAleatorio();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

            analisarCandidato(salarioPretendido);

            if (salarioPretendido < CASE_SUCESSO) {
                System.out.println("Candidato " + candidato + " foi selecionado para a vaga");
                candidatoSelecionado++;
            }

            candidatoAtual++;
        }
    }

    private static void analisarCandidato(double valorAleatorio) {
        if (valorAleatorio > CASE_SUCESSO) {
            System.out.println("Aguardando outros candidatos");
        } else if (valorAleatorio == CASE_SUCESSO) {
            System.out.println("Ligar para fazer contraproposta");
        } else {
            System.out.println("Ligar para candidato");
        }
    }

    private static double valorAleatorio() {
        return ThreadLocalRandom.current().nextDouble(1500.0, 2500.0);
    }
}
