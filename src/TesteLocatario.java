import java.util.Scanner;

public class TesteLocatario {

    public static void main(String[] args) {

        Dados bd = new Dados();
        bd.criarCarros();
        bd.criarEstacionamentos();
        bd.criarLocatarios();

        Scanner in = new Scanner(System.in);
        int escolha = -1;

        System.out.println("\n-------------- LOCATÁRIO --------------\n");
        System.out.println("1 - Reservar Carro");
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
                    int est;
                    int car;

                    bd.mostrarEstacionamentos();

                    System.out.println("\nEscolha o estacionamento");
                    System.out.print("-> ");
                    est = in.nextInt();

                    Dados.listaDeEstacionamentos.get(est).registrarCarro(Dados.listaDeCarros.get(0));
                    Dados.listaDeEstacionamentos.get(est).mostrarCarrosNoEstacionamento();

                    System.out.println("\nEscolha o carro");
                    System.out.print("-> ");
                    car = in.nextInt();

                    if (Dados.listaDeEstacionamentos.get(est).getCarrosNoEstacionamento().get(car).getEstahReservado().equals("Não") &&
                            Dados.listaDeEstacionamentos.get(est).getCarrosNoEstacionamento().get(car).getEmAluguel().equals("Não")) {

                        Dados.listaDeEstacionamentos.get(est).getCarrosNoEstacionamento().get(car).setEstahReservado(true);
                        System.out.println("\n*********Carro reservado com sucesso!************\n");
                    }
                    break;

            }
        }
    }

}
