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
            System.out.print("\n-> ");
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
                    int escolhaLoc;
                    int escolhaCar;
                    int odometro;

                    System.out.println("Escolha o Locatário");
                    System.out.print("\n-> ");
                    escolhaLoc = in.nextInt();
                    System.out.println(Dados.listaDeLocatarios.get(escolhaLoc));

                    System.out.println("Escolha o Carro");
                    Dados.listaDeEstacionamentos.get(0).mostrarCarrosNoEstacionamento();
                    System.out.print("\n-> ");
                    escolhaCar = in.nextInt();
                    System.out.println("Digite o valor inicial do odômetro: ");

                    System.out.print("\n-> ");
                    odometro = in.nextInt();

                    Dados.listaDeEstacionamentos.get(0).alugarCarro(Dados.listaDeLocatarios.get(escolhaLoc), Dados.listaDeCarros.get(escolhaCar),
                                                                    odometro);

                    System.out.println("Carro alugado com sucesso!");

                    Dados.listaDeLocatarios.get(escolhaLoc).mostrarHistorico();

                    break;
                case 4:
                    int escolhaCar2;
                    int odometro2;

                    System.out.println("Escolha o Carro");
                    Dados.listaDeEstacionamentos.get(0).mostrarCarrosNoEstacionamento();
                    System.out.print("\n-> ");
                    escolhaCar2 = in.nextInt();
                    System.out.println("Digite o valor final do odômetro: ");

                    System.out.print("\n-> ");
                    odometro2 = in.nextInt();

                    Dados.listaDeEstacionamentos.get(0).retornarCarro(Dados.listaDeCarros.get(escolhaCar2), odometro2);

                    System.out.println("Carro retornado com sucesso!");
                    break;

            }
        }
    }
}
