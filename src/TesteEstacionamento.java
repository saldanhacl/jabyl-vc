import java.util.Scanner;

public class TesteEstacionamento {

    public static void main(String[] args) {

        Dados bd = new Dados();
        bd.criarCarros();
        bd.criarEstacionamentos();
        bd.criarLocatarios();

        Scanner in = new Scanner(System.in);
        int escolha = -1;

        System.out.println("\n-------------- ESTACIONAMENTO --------------\n");
        System.out.println("1 - Registrar Carro");
        System.out.println("2 - Mostrar Carros");
        System.out.println("3 - Alugar Carro");
        System.out.println("4 - Retornar Carro");
        System.out.println("0 - Sair");

        while (true) {
            System.out.println("\nO que deseja fazer?");
            System.out.print("-> ");
            escolha = in.nextInt();

            switch (escolha) {

                case 0:
                    System.out.println("\nAté logo!\n");
                    return;
                case 1:
                    Dados.listaDeEstacionamentos.get(0).registrarCarro(Dados.listaDeCarros.get(0));
                    break;
                case 2:
                    Dados.listaDeEstacionamentos.get(0).mostrarCarrosNoEstacionamento();
                    break;
                case 3:
                    Dados.listaDeEstacionamentos.get(0).alugarCarro();
                    break;
                case 4:
                    Dados.listaDeEstacionamentos.get(0).retornarCarro();
                    break;

            }
        }
    }
}
