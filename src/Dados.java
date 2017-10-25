import java.util.ArrayList;
import java.util.List;

public class Dados {

    static List<Carro> listaDeCarros = new ArrayList<>();
    static List<Locatario> listaDeLocatarios = new ArrayList<>();
    static List<Estacionamento> listaDeEstacionamentos = new ArrayList<>();

    public void criarCarros(){
        listaDeCarros.add(new Carro("HGO7806", "Dourado", "2008", "Uno"));
    }

    public void criarLocatarios(){

        listaDeLocatarios.add(new Locatario("Danilo", "38982741538", "danilo@gmail.com","1234",
                "11762914670", "310554019", "Silva", "07/06/1996"
                ,"94604268637"));

        listaDeLocatarios.add(new Locatario("Lorena", "31989224351", "lorena@gmail.com","1234",
                "00593451600", "247003839", "Martins", "21/09/1996"
                ,"77141424536"));
    }

    public void criarEstacionamentos() {

        listaDeEstacionamentos.add(new Estacionamento("Park", "31992006338", "park@gmail.com", "1234",
                "31442325000158"));

    }

    public void mostrarCarros(){
        System.out.println("\n---------- CARROS ----------\n");
        for (Carro  c : listaDeCarros) {
            System.out.println("Carro #" + listaDeCarros.indexOf(c));
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

    public void mostrarLocatarios(){

        System.out.println("\n---------- LOCATÁRIOS ----------\n");
        for (Locatario l : listaDeLocatarios) {
            System.out.println("Locatario #" + listaDeLocatarios.indexOf(l));
            System.out.println("Nome: " + l.getNome() + " " + l.getSobrenome());
            System.out.println("Email: " + l.getEmail());
            System.out.println("Data de Nascimento: " + l.getDataDeNascimento());
            System.out.println("Telefone: " + l.getTelefone());
            System.out.println("CPF: " + l.getCpf());
            System.out.println("RG: " + l.getRg());
            System.out.println("CNH: " + l.getCnh());
            System.out.println("---------------------------------\n");
        }
    }

    public void mostrarEstacionamentos(){

        System.out.println("\n---------- ESTACIONAMENTOS ----------\n");
        for (Estacionamento e : listaDeEstacionamentos) {
            System.out.println("Estacionamento #" + listaDeEstacionamentos.indexOf(e));
            System.out.println("Nome: " + e.getNome());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Telefone: " + e.getTelefone());
            System.out.println("CNPJ: " + e.getCnpj());
            System.out.println("---------------------------------\n");
        }
    }
}


