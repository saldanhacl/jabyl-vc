import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {

    static Scanner in = new Scanner(System.in);
    List<Locatario> listaDeLocatarios = new ArrayList<>();
    List<Estacionamento> listaDeEstacionamentos = new ArrayList<>();
    List<Carro> listaDeCarros = new ArrayList<>();

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

    public void cadastrarCarro(Carro c){
        if(!listaDeCarros.contains(c)) {
            listaDeCarros.add(c);
            System.out.println("Carro " + c + " cadastrado(a) com sucesso!");
        } else System.out.println("Carro já cadastrado!");
    }


    public void mostrarCarros(){
        System.out.println("\n---------- CARROS ----------\n");
        for (Carro  c : listaDeCarros) {
            System.out.println("ID #" + listaDeCarros.indexOf(c));
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("Cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Placa: " + c.getPlaca());
            System.out.println("Em aluguel: " + c.getEmAluguel());
            System.out.println("Reservado: " + c.getEstahReservado());
            System.out.println("---------------------------------\n");
        }
    }

    public void mostrarLocatarios(){

        System.out.println("\n---------- LOCATÁRIOS ----------\n");
        for (Locatario l : listaDeLocatarios) {
            System.out.println("ID #" + listaDeLocatarios.indexOf(l));
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
            System.out.println("ID #" + listaDeEstacionamentos.indexOf(e));
            System.out.println("Nome: " + e.getNome());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Telefone: " + e.getTelefone());
            System.out.println("CNPJ: " + e.getCnpj());
            System.out.println("---------------------------------\n");
        }
    }

    public void controlarEstacionamento(){

        int escolhaEst = -1;
        int escolhaMenu = -1;

        System.out.println("Digite o ID do Estacionamento");
        System.out.print("-> ");
        escolhaEst = in.nextInt();

        System.out.println("\n-------------- ESTACIONAMENTO --------------\n");


        while (true) {
            System.out.println("\n1 - Registrar Carro");
            System.out.println("2 - Mostrar Carros");
            System.out.println("3 - Alugar Carro");
            System.out.println("4 - Retornar Carro");
            System.out.println("0 - Voltar");
            System.out.println("\nO que deseja fazer?");
            System.out.print("-> ");
            escolhaMenu = in.nextInt();

            switch (escolhaMenu) {

                case 0:
                    System.out.println("\nAté logo!\n");
                    return;
                case 1:
                    this.mostrarCarros();
                    int escolhaCar = -1;

                    System.out.println("Escolha o carro que deseja registrar");
                    System.out.print("-> ");
                    escolhaCar = in.nextInt();
                    this.getListaDeEstacionamentos().get(escolhaEst).registrarCarro(this.listaDeCarros.get(escolhaCar));
                    break;
                case 2:
                    this.getListaDeEstacionamentos().get(escolhaEst).mostrarCarrosNoEstacionamento();
                    break;
                case 3:

                    int escolhaLoc;
                    int escolhaCarAluguel;

                    System.out.println("Digite o ID do Locatário");
                    System.out.print("-> ");
                    escolhaLoc = in.nextInt();

                    this.getListaDeEstacionamentos().get(escolhaEst).mostrarCarrosNoEstacionamento();
                    System.out.println("Escolha o Carro");
                    System.out.print("-> ");
                    escolhaCarAluguel = in.nextInt();

                    this.getListaDeEstacionamentos().get(escolhaEst).alugarCarro(this.getListaDeLocatarios().get(escolhaLoc),
                                                                                this.getListaDeCarros().get(escolhaCarAluguel));
                    break;
                case 4:

                    this.getListaDeEstacionamentos().get(escolhaEst).mostrarCarrosNoEstacionamento();
                    int escolhaCarRetorno = -1;

                    System.out.println("Escolha o Carro");
                    System.out.print("-> ");
                    escolhaCarRetorno = in.nextInt();

                    this.getListaDeEstacionamentos().get(escolhaEst).retornarCarro( this.getListaDeEstacionamentos().get(escolhaEst).getCarrosNoEstacionamento().get(escolhaCarRetorno));
                    break;

            }
        }
    }

    public void controlarDados(){

        int escolhaMenu = -1;

        System.out.println("\n-------------- CONTROLE DE DADOS --------------\n");

        while (true) {
            System.out.println("\n1 - Cadastrar Locatário");
            System.out.println("2 - Cadastrar Estacionamento");
            System.out.println("3 - Cadastrar Carro");
            System.out.println("4 - Mostrar Locatários");
            System.out.println("5 - Mostrar Estacionamentos");
            System.out.println("6 - Mostrar Carros");
            System.out.println("0 - Voltar");
            System.out.println("\nO que deseja fazer?");
            System.out.print("-> ");
            escolhaMenu = in.nextInt();

            switch (escolhaMenu) {

                case 0:
                    System.out.println("\nAté logo!\n");
                    return;
                case 1:

                    System.out.println("\n-------------- CADASTRO DE LOCATÁRIO --------------\n");

                    String nomeLoc;
                    String telefoneLoc;
                    String emailLoc;
                    String senhaLoc;
                    String cpfLoc;
                    String rgLoc;
                    String sobrenomeLoc;
                    String dataDeNascimentoLoc;
                    String cnhLoc;

                    System.out.print("\nNome: ");
                    nomeLoc = in.next();
                    System.out.print("Sobrenome: ");
                    sobrenomeLoc = in.next();
                    System.out.print("Telefone: ");
                    telefoneLoc = in.next();
                    System.out.print("Email: ");
                    emailLoc = in.next();
                    System.out.print("Senha: ");
                    senhaLoc = in.next();
                    System.out.print("CPF: ");
                    cpfLoc = in.next();
                    System.out.print("RG: ");
                    rgLoc = in.next();
                    System.out.print("CNH: ");
                    cnhLoc = in.next();
                    System.out.print("Data de nascimento: ");
                    dataDeNascimentoLoc = in.next();

                    Locatario locCadastrar = new Locatario(nomeLoc,telefoneLoc,emailLoc,senhaLoc,cpfLoc,rgLoc,sobrenomeLoc,dataDeNascimentoLoc,cnhLoc);
                    this.cadastrarLocatario(locCadastrar);

                    break;
                case 2:

                    System.out.println("\n-------------- CADASTRO DE ESTACIONAMENTO --------------\n");

                    String nomeEst;
                    String telefoneEst;
                    String emailEst;
                    String senhaEst;
                    String cnpjEst;

                    System.out.print("Nome: ");
                    nomeEst = in.next();
                    System.out.print("Telefone: ");
                    telefoneEst = in.next();
                    System.out.print("Email: ");
                    emailEst = in.next();
                    System.out.print("Senha: ");
                    senhaEst = in.next();
                    System.out.print("CNPJ: ");
                    cnpjEst = in.next();


                    Estacionamento estCadastrar = new Estacionamento(nomeEst,telefoneEst,emailEst,senhaEst,cnpjEst);
                    this.cadastrarEstacionamento(estCadastrar);

                    break;
                case 3:

                    System.out.println("\n-------------- CADASTRO DE CARRO --------------\n");

                    String placa;
                    String cor;
                    String ano;
                    String modelo;


                    System.out.print("Placa: ");
                    placa = in.next();
                    System.out.print("Cor: ");
                    cor = in.next();
                    System.out.print("Ano: ");
                    ano = in.next();
                    System.out.print("Modelo: ");
                    modelo = in.next();


                    Carro carCadastrar = new Carro(placa,cor,ano,modelo);
                    this.cadastrarCarro(carCadastrar);

                    break;
                case 4:
                    this.mostrarLocatarios();
                    break;
                case 5:
                    this.mostrarEstacionamentos();
                    break;
                case 6:
                    this.mostrarCarros();
                    break;

            }
        }
    }

    public void controlarLocatario(){

        int escolhaLoc = -1;
        int escolhaMenu = -1;

        System.out.println("Digite o ID do Locatário");
        System.out.print("-> ");
        escolhaLoc = in.nextInt();

        System.out.println("\n-------------- LOCATÁRIO --------------\n");

        while (true) {
            System.out.println("\n1 - Reservar Carro");
            System.out.println("2 - Mostrar histórico");
            System.out.println("0 - Voltar");
            System.out.println("\nO que deseja fazer?");
            System.out.print("\n-> ");
            escolhaMenu = in.nextInt();

            switch (escolhaMenu) {

                case 0:
                    System.out.println("\nAté logo!\n");
                    return;
                case 1:
                    int estacionamentoAtual;
                    int carroReservado;

                    System.out.println("\nEscolha o estacionamento");
                    System.out.print("-> ");
                    estacionamentoAtual = in.nextInt();

                    this.getListaDeEstacionamentos().get(estacionamentoAtual).mostrarCarrosNoEstacionamento();

                    System.out.println("\nEscolha o carro");
                    System.out.print("-> ");
                    carroReservado = in.nextInt();

                    if (this.getListaDeEstacionamentos().get(estacionamentoAtual).getCarrosNoEstacionamento().get(carroReservado).getEstahReservado().equals("Não") &&
                            this.getListaDeEstacionamentos().get(estacionamentoAtual).getCarrosNoEstacionamento().get(carroReservado).getEmAluguel().equals("Não")) {

                        this.getListaDeEstacionamentos().get(estacionamentoAtual).getCarrosNoEstacionamento().get(carroReservado).setEstahReservado(true);
                        System.out.println("\n*********Carro reservado com sucesso!************\n");
                    }
                    break;
                case 2:
                    this.getListaDeLocatarios().get(escolhaLoc).getHistoricoDeAlugueis().getHistorico();
                    break;
            }
        }
    }

    public List<Locatario> getListaDeLocatarios() {
        return listaDeLocatarios;
    }

    public List<Estacionamento> getListaDeEstacionamentos() {
        return listaDeEstacionamentos;
    }

    public List<Carro> getListaDeCarros() {
        return listaDeCarros;
    }

    public static void main(String[] args) {

        Controle c = new Controle();

        c.cadastrarEstacionamento(new Estacionamento("Park", "31992006338", "park@gmail.com", "1234",
                "31442325000158"));

        c.cadastrarLocatario(new Locatario("Danilo", "38982741538", "danilo@gmail.com","1234",
                "11762914670", "310554019", "Silva", "07/06/1996"
                ,"94604268637"));

        c.cadastrarCarro(new Carro("HGO7806", "Dourado", "2008", "Uno"));

        int escolha = -1;

        System.out.println("\n-------------- CONTROLE --------------\n");

        while (true) {
            System.out.println("\n1 - Estacionamento");
            System.out.println("2 - Locatário");
            System.out.println("3 - Dados");
            System.out.println("0 - Sair");
            System.out.println("\nO que deseja controlar?");
            System.out.print("-> ");
            escolha = in.nextInt();

            switch (escolha) {

                case 0:
                    System.out.println("\nAté logo!\n");
                    return;
                case 1:
                    c.controlarEstacionamento();
                    break;
                case 2:
                    c.controlarLocatario();
                    break;
                case 3:
                    c.controlarDados();
                    break;
            }
        }
    }

}
