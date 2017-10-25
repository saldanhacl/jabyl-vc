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
            System.out.println(c + " " + c.getCor() + " " + c.getAno() + " cadastrado(a) com sucesso!");
        } else System.out.println("Carro já cadastrado!");
    }

    public void mostrarCarrosNoEstacionamento(){
        System.out.println("\n---------- CARROS ----------\n");
        for (Carro  c : carrosNoEstacionamento) {
            System.out.println("Carro #" + carrosNoEstacionamento.indexOf(c));
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("Cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Placa: " + c.getPlaca());
            System.out.println("Em aluguel: " + c.getEmAluguel());
            System.out.println("Reservado: " + c.getEstahReservado());
            System.out.println("\n---------------------------------\n");
        }
    }

    public void alugarCarro(){

        Scanner in = new Scanner(System.in);
        int escolhaLoc;
        int escolhaCar;
        int odometro;

        System.out.println("Digite o ID do Locatário");
        System.out.print("-> ");
        escolhaLoc = in.nextInt();
        System.out.println(Dados.listaDeLocatarios.get(escolhaLoc));

        Dados.listaDeEstacionamentos.get(0).mostrarCarrosNoEstacionamento();
        System.out.println("Escolha o Carro");
        System.out.print("-> ");
        escolhaCar = in.nextInt();

        System.out.println("Digite o valor inicial do odômetro: ");
        System.out.print("-> ");
        odometro = in.nextInt();

        AluguelERetorno a = new AluguelERetorno(this.getCarrosNoEstacionamento().get(escolhaCar),Dados.listaDeLocatarios.get(escolhaLoc),
                                                odometro);
        this.getCarrosNoEstacionamento().get(escolhaCar).setAluguelDoCarro(a);

        System.out.println("\n*********Carro alugado com sucesso!************\n");

    }

    public void retornarCarro(){

        Scanner in = new Scanner(System.in);

        int escolhaCar;
        int odometro;

        this.mostrarCarrosNoEstacionamento();
        System.out.println("Escolha o Carro");
        System.out.print("-> ");
        escolhaCar = in.nextInt();

        System.out.println("Digite o valor final do odômetro: ");
        System.out.print("-> ");
        odometro = in.nextInt();

        Dados.listaDeCarros.get(escolhaCar).getAluguelDoCarro().setValorFinalDoOdometro(odometro);
        Dados.listaDeCarros.get(escolhaCar).getLocatarioDoCarro().getHistoricoDeAlugueis().getListaDeAlugueis().add(Dados.listaDeCarros.get(escolhaCar).getAluguelDoCarro());
        Dados.listaDeCarros.get(escolhaCar).setEstahAlugado(false);
        Dados.listaDeCarros.get(escolhaCar).setLocatarioDoCarro(null);

        System.out.println("\n*********Carro retornado com sucesso!************\n");

        Dados.listaDeLocatarios.get(1).getHistoricoDeAlugueis().getHistorico();

    }

    public List<Carro> getCarrosNoEstacionamento() {
        return carrosNoEstacionamento;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
