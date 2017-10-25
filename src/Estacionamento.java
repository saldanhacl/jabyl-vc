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
            System.out.println("Carro " + c + " cadastrado(a) com sucesso!");
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
            System.out.println("---------------------------------\n");
        }
    }

    public void alugarCarro(Locatario l, Carro c, int valorInicialDoOdometro){
        Aluguel a = new Aluguel(c,l,valorInicialDoOdometro);
        l.getHistoricoDeAlugueis().add(a);
    }

    public void retornarCarro(Carro c, int valorFinalDoOdometro){
        Retorno r = new Retorno(c,valorFinalDoOdometro);
    }


    @Override
    public String toString() {
        return super.toString();
    }

}
