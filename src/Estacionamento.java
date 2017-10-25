import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Status: " + c.getStatus());
            if (c.getStatus() == "Alugando")
                System.out.println("Locatario: " + c.getLocatarioDoCarro());
            System.out.println("\n---------------------------------\n");
        }
    }

    public void alugarCarro(Locatario l, Carro c, int valorInicialDoOdometro){
        AluguelERetorno a = new AluguelERetorno(c,l,valorInicialDoOdometro);
        c.setAluguelDoCarro(a);
    }

    public void retornarCarro(AluguelERetorno aluguel, int valorFinalDoOdometro){
        aluguel.setValorFinalDoOdometro(valorFinalDoOdometro);
        aluguel.getCarroAlugado().setStatus(false);
        aluguel.getCarroAlugado().setLocatarioDoCarro(null);
        aluguel.getLocatarioAlugando().getHistoricoDeAlugueis().getListaDeAlugueis().add(aluguel);
    }


    @Override
    public String toString() {
        return super.toString();
    }

}
