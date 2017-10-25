import java.util.ArrayList;
import java.util.List;

public class Controle {

    List<Locatario> listaDeLocatarios = new ArrayList<>();
    List<Estacionamento> listaDeEstacionamentos = new ArrayList<>();

    public void cadastrarLocatario(Locatario l){

        if(!listaDeLocatarios.contains(l)) {
            listaDeLocatarios.add(l);
            System.out.println("Locatário(a) " + l.getNome() + " " + l.getSobrenome() + " cadastrado(a) com sucesso!");
        } else System.out.println("Locatário já cadastrado!");

    }

    public void cadastrarEstacionamento(Estacionamento e){

        if(!listaDeEstacionamentos.contains(e)) {
            listaDeEstacionamentos.add(e);
            System.out.println("Estacionamento " + e + " cadastrado(a) com sucesso!");
        } else System.out.println("Estacionamento já cadastrado!");

    }

    public void mostrarLocatarios(){

        System.out.println("\n---------- LOCATÁRIOS ----------\n");
        for (Locatario l : listaDeLocatarios) {
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
            System.out.println("Nome: " + e.getNome());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Telefone: " + e.getTelefone());
            System.out.println("CNPJ: " + e.getCnpj());
            System.out.println("---------------------------------\n");
        }
    }

}
