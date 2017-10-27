import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estacionamento extends PessoaJuridica{

    private List<Carro> carrosNoEstacionamento = new ArrayList<>();

    public Estacionamento(String nome, String telefone, String email, String senha, String cnpj) {
        super(nome, telefone, email, senha, cnpj);
    }

    public void registrarCarro(Carro c){
        if(!carrosNoEstacionamento.contains(c)) {
            carrosNoEstacionamento.add(c);
            System.out.println(c + " " + c.getCor() + " " + c.getAno() + " registrado com sucesso!");
        } else System.out.println("Carro já registrado!");
    }

    public void mostrarCarrosNoEstacionamento(){
        System.out.println("\n---------- CARROS ----------\n");
        for (Carro  c : carrosNoEstacionamento) {
            System.out.println("Carro #" + carrosNoEstacionamento.indexOf(c));
            System.out.println("Dono: " + c.getDonoDoCarro().getPessoaLocador());
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("Cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Placa: " + c.getPlaca());
            System.out.println("Em aluguel: " + c.getEmAluguel());
            System.out.println("Reservado: " + c.getEstahReservado());
            System.out.println("\n---------------------------------\n");
        }
    }

    public void alugarCarro(Locatario l, Carro c){

        Scanner in = new Scanner(System.in);
        int odometro;

        System.out.println("Digite o valor inicial do odômetro: ");
        System.out.print("-> ");
        odometro = in.nextInt();

        AluguelERetorno a = new AluguelERetorno(c,l,odometro);
        c.setAluguelDoCarro(a);
        System.out.println("\n*********Carro alugado com sucesso!************\n");

    }

    public void retornarCarro(Carro c){

        Scanner in = new Scanner(System.in);

        int odometro;

        System.out.println("Digite o valor final do odômetro: ");
        System.out.print("-> ");
        odometro = in.nextInt();

        c.getAluguelDoCarro().setValorFinalDoOdometro(odometro);
        c.getLocatarioDoCarro().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
        c.getDonoDoCarro().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
        c.setEstahReservado(false);
        c.setEstahAlugado(false);
        c.setLocatarioDoCarro(null);

        System.out.println("\n*********Carro retornado com sucesso!************\n");


    }

}
