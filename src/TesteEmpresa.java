import java.util.Scanner;

public class TesteEmpresa {

    public static void main(String[] args) {

        Dados bd = new Dados();
        bd.criarCarros();
        bd.criarEstacionamentos();
        bd.criarLocatarios();

        Controle controle = new Controle();
        Scanner in = new Scanner (System.in);
        int escolha = -1;

        System.out.println("\n-------------- CONTROLE --------------\n");
        System.out.println("1 - Mostrar Locatários");
        System.out.println("2 - Mostrar Estacionamentos");
        System.out.println("3 - Mostrar Carros");
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
                    bd.mostrarLocatarios();
                    break;
                case 2:
                    bd.mostrarEstacionamentos();
                    break;
                case 3:
                    bd.mostrarCarros();
                    break;

            }

        }

    }



}
