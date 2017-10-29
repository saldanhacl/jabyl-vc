import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {

    private static Scanner in = new Scanner(System.in);
    private List<Locatario> listaDeLocatarios = new ArrayList<>();
    private List<Locador> listaDeLocadores = new ArrayList<>();
    private List<Estacionamento> listaDeEstacionamentos = new ArrayList<>();
    private List<Carro> listaDeCarros = new ArrayList<>();

    private void cadastrarLocatario(Locatario l){

        if(!listaDeLocatarios.contains(l)) {
            listaDeLocatarios.add(l);
            System.out.println("Locatário(a) " + l.getNome() + " " + l.getSobrenome() + " cadastrado(a) com sucesso!");
        } else System.out.println("Locatário já cadastrado!");

    }

    private void cadastrarLocatario(){

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
    }

    private void cadastrarLocador(Locador l){

        if(!listaDeLocadores.contains(l)) {
            listaDeLocadores.add(l);
            System.out.println("Locador(a) " + l + " cadastrado(a) com sucesso!");
        } else System.out.println("Locador já cadastrado!");

    }

    private void cadastrarLocador(){

        int escolhaPessoa;

        System.out.println("Escolha o tipo de pessoa do Locador");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        escolhaPessoa = in.nextInt();

        if (escolhaPessoa == 1) {

            System.out.println("\n-------------- CADASTRO DE LOCADOR --------------\n");

            String nomeLocador;
            String telefoneLocador;
            String emailLocador;
            String senhaLocador;
            String cpfLocador;
            String rgLocador;
            String sobrenomeLocador;
            String dataDeNascimentoLocador;

            System.out.print("\nNome: ");
            nomeLocador = in.next();
            System.out.print("Sobrenome: ");
            sobrenomeLocador = in.next();
            System.out.print("Telefone: ");
            telefoneLocador = in.next();
            System.out.print("Email: ");
            emailLocador = in.next();
            System.out.print("Senha: ");
            senhaLocador = in.next();
            System.out.print("CPF: ");
            cpfLocador = in.next();
            System.out.print("RG: ");
            rgLocador = in.next();
            System.out.print("Data de nascimento: ");
            dataDeNascimentoLocador = in.next();

            PessoaFisica p = new PessoaFisica(nomeLocador, telefoneLocador, emailLocador, senhaLocador,
                    cpfLocador, rgLocador, sobrenomeLocador, dataDeNascimentoLocador);

            Locador locadorCadastrar = new Locador(p);
            this.cadastrarLocador(locadorCadastrar);

        } else {

            System.out.println("\n-------------- CADASTRO DE LOCADOR --------------\n");

            String nomeLocador;
            String telefoneLocador;
            String emailLocador;
            String senhaLocador;
            String cnpjLocador;

            System.out.print("\nNome: ");
            nomeLocador = in.next();
            System.out.print("Telefone: ");
            telefoneLocador = in.next();
            System.out.print("Email: ");
            emailLocador = in.next();
            System.out.print("Senha: ");
            senhaLocador = in.next();
            System.out.print("CNPJ: ");
            cnpjLocador = in.next();

            PessoaJuridica p = new PessoaJuridica(nomeLocador, telefoneLocador, emailLocador, senhaLocador, cnpjLocador);

            Locador locadorCadastrar = new Locador(p);
            this.cadastrarLocador(locadorCadastrar);
        }
    }

    private void cadastrarEstacionamento(Estacionamento e){

        if(!listaDeEstacionamentos.contains(e)) {
            listaDeEstacionamentos.add(e);
            System.out.println("Estacionamento " + e + " cadastrado(a) com sucesso!");
        } else System.out.println("Estacionamento já cadastrado!");

    }

    private void cadastrarEstacionamento(){

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

    }

    private void cadastrarCarroNosDados(Carro c){
        if(!listaDeCarros.contains(c)) {
            listaDeCarros.add(c);
            System.out.println("Carro " + c + " cadastrado nos dados com sucesso!");
        } else System.out.println("Carro já cadastrado nos dados...");

    }

    private Locatario escolherLocatário(){

        int escolhaLocatario;

        System.out.println("Digite o ID do Locatário");
        System.out.print("-> ");
        escolhaLocatario = in.nextInt();

        Locatario locatarioEscolhido = this.getListaDeLocatarios().get(escolhaLocatario);

        return locatarioEscolhido;

    }

    private Locador escolherLocador(){

        int escolhaLocador;

        System.out.println("Digite o ID do Locador");
        System.out.print("-> ");
        escolhaLocador = in.nextInt();

        Locador locadorEscolhido = this.getListaDeLocadores().get(escolhaLocador);

        return locadorEscolhido;

    }

    private Carro escolherCarro(){

        int escolhaCarro;

        System.out.println("Digite o ID do Carro");
        System.out.print("-> ");
        escolhaCarro = in.nextInt();

        Carro carroEscolhido = this.getListaDeCarros().get(escolhaCarro);

        return carroEscolhido;

    }

    private Estacionamento escolherEstacionamento(){

        int escolhaEstacionamento;

        System.out.println("Digite o ID do Estacionamento");
        System.out.print("-> ");
        escolhaEstacionamento = in.nextInt();

        Estacionamento EstacionamentoEscolhido = this.getListaDeEstacionamentos().get(escolhaEstacionamento);

        return EstacionamentoEscolhido;

    }

    private Carro cadastrarCarro(){
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
        return carCadastrar;
    }

    private void mostrarCarros(List<Carro> listaDeCarros){
        System.out.println("\n---------- CARROS ----------\n");
        for (Carro  c : listaDeCarros) {
            System.out.println("ID #" + listaDeCarros.indexOf(c));
            System.out.println("Dono: " + c.getDonoDoCarro().getPessoaLocador());
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("Cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Placa: " + c.getPlaca());
            System.out.println("Em aluguel: " + c.getEmAluguel());
            System.out.println("Reservado: " + c.getEstahReservado());
            System.out.println("---------------------------------\n");
        }
    }

    private void mostrarLocatarios(){

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

    private void mostrarLocadores(){

        System.out.println("\n---------- LOCADORES ----------\n");

        for (Locador l : listaDeLocadores) {
            if (l.getPessoaLocador() instanceof PessoaFisica) {
                System.out.println("ID #" + listaDeLocadores.indexOf(l));
                System.out.println("Nome: " + l.getPessoaLocador().getNome() + " " + ((PessoaFisica)l.getPessoaLocador()).getSobrenome());
                System.out.println("Email: " + l.getPessoaLocador().getEmail());
                System.out.println("Data de Nascimento: " + ((PessoaFisica)l.getPessoaLocador()).getDataDeNascimento());
                System.out.println("Telefone: " + l.getPessoaLocador().getTelefone());
                System.out.println("CPF: " + ((PessoaFisica)l.getPessoaLocador()).getCpf());
                System.out.println("RG: " + ((PessoaFisica)l.getPessoaLocador()).getRg());
                System.out.println("---------------------------------\n");
            } else {
                System.out.println("ID #" + listaDeLocadores.indexOf(l));
                System.out.println("Nome: " + l.getPessoaLocador().getNome());
                System.out.println("Email: " + l.getPessoaLocador().getEmail());
                System.out.println("Telefone: " + l.getPessoaLocador().getTelefone());
                System.out.println("CNPJ: " + ((PessoaJuridica)l.getPessoaLocador()).getCnpj());
                System.out.println("---------------------------------\n");
            }
        }
    }

    private void mostrarEstacionamentos(){

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

    private void controlarDados(){

        int escolhaMenu;

        System.out.println("\n-------------- CONTROLE DE DADOS --------------\n");

        while (true) {
            System.out.println("\n1 - Cadastrar Locatário");
            System.out.println("2 - Cadastrar Locador");
            System.out.println("3 - Cadastrar Estacionamento");
            System.out.println("4 - Mostrar Locatários");
            System.out.println("5 - Mostrar Locadores");
            System.out.println("6 - Mostrar Estacionamentos");
            System.out.println("7 - Mostrar Carros");
            System.out.println("0 - Voltar");
            System.out.println("\nO que deseja fazer?");
            System.out.print("-> ");
            escolhaMenu = in.nextInt();

            switch (escolhaMenu) {

                case 0:
                    System.out.println("\nVoltando...\n");
                    return;
                case 1:
                    this.cadastrarLocatario();
                    break;
                case 2:
                    this.cadastrarLocador();
                    break;
                case 3:
                    this.cadastrarEstacionamento();
                    break;
                case 4:
                    this.mostrarLocatarios();
                    break;
                case 5:
                    this.mostrarLocadores();
                    break;
                case 6:
                    this.mostrarEstacionamentos();
                    break;
                case 7:
                    this.mostrarCarros(this.listaDeCarros);
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }

    private void controlarLocatario(){

        int escolhaMenu;

        Locatario locatarioEscolhido = escolherLocatário();

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
                    System.out.println("\nVoltando...\n");
                    return;
                case 1:
                    System.out.println("Escolha um estacionamento");
                    Estacionamento estacionamentoReservarCarro = escolherEstacionamento();
                    estacionamentoReservarCarro.mostrarCarrosNoEstacionamento();

                    System.out.println("Escolha um carro para reservar");
                    Carro carroReservar = escolherCarro();

                    if (carroReservar.getEstahReservado().equals("Não") && carroReservar.getEmAluguel().equals("Não")) {
                        carroReservar.setEstahReservado(true);
                        System.out.println("\n*********Carro reservado com sucesso!************\n");
                    }
                    break;
                case 2:
                    locatarioEscolhido.getHistoricoDeAlugueis().getHistorico();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }


    private void controlarLocador(){

        int escolhaMenu;

        Locador locadorEscolhido = escolherLocador();

        System.out.println("\n-------------- LOCADOR --------------\n");

        while (true) {
            System.out.println("\n1 - Cadastrar Carro");
            System.out.println("2 - Mostrar histórico");
            System.out.println("3 - Mostrar Carros");
            System.out.println("0 - Voltar");
            System.out.println("\nO que deseja fazer?");
            System.out.print("\n-> ");
            escolhaMenu = in.nextInt();

            switch (escolhaMenu) {

                case 0:
                    System.out.println("\nVoltando...\n");
                    return;
                case 1:
                    Carro carroCadastrado = cadastrarCarro();
                    locadorEscolhido.cadastrarCarro(carroCadastrado);
                    this.cadastrarCarroNosDados(carroCadastrado);
                    break;
                case 2:
                    locadorEscolhido.getHistoricoDeAlugueis().getHistorico();
                    break;
                case 3:
                    locadorEscolhido.getCarrosDoLocador();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }

    private void controlarEstacionamento(){

        int escolhaMenu;

        Estacionamento estacionamentoEscolhido = escolherEstacionamento();

        System.out.println("\n-------------- ESTACIONAMENTO --------------\n");


        while (true) {
            System.out.println("\n1 - Registrar Carro");
            System.out.println("2 - Mostrar Carros");
            System.out.println("3 - Alugar Carro");
            System.out.println("4 - Retornar Carro");
            System.out.println("5 - Mostrar histórico");
            System.out.println("0 - Voltar");
            System.out.println("\nO que deseja fazer?");
            System.out.print("-> ");
            escolhaMenu = in.nextInt();

            switch (escolhaMenu) {
                case 0:
                    System.out.println("\nVoltando...\n");
                    return;
                case 1:
                    Locador locadorRegistrarCarro = escolherLocador();
                    this.mostrarCarros(locadorRegistrarCarro.getCarrosDoLocador());

                    System.out.println("Escolha o carro que deseja registrar");
                    Carro carroRegistrar = escolherCarro();
                    estacionamentoEscolhido.registrarCarro(carroRegistrar);
                    break;
                case 2:
                    estacionamentoEscolhido.mostrarCarrosNoEstacionamento();
                    break;
                case 3:
                    System.out.println("Escolha o locatário que irá alugar um carro");
                    Locatario locatarioAlugar = escolherLocatário();
                    estacionamentoEscolhido.mostrarCarrosNoEstacionamento();

                    System.out.println("Escolha o carro que deseja alugar");
                    Carro carroAlugar = escolherCarro();
                    estacionamentoEscolhido.alugarCarro(locatarioAlugar, carroAlugar);
                    break;
                case 4:
                    estacionamentoEscolhido.mostrarCarrosNoEstacionamento();

                    Carro carroRetornar = escolherCarro();
                    estacionamentoEscolhido.retornarCarro(carroRetornar);
                    break;
                case 5:
                    estacionamentoEscolhido.getHistoricoDeAlugueis().getHistorico();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }

    private List<Locatario> getListaDeLocatarios() {
        return listaDeLocatarios;
    }

    private List<Estacionamento> getListaDeEstacionamentos() {
        return listaDeEstacionamentos;
    }

    private List<Carro> getListaDeCarros() {
        return listaDeCarros;
    }

    private List<Locador> getListaDeLocadores() {
        return listaDeLocadores;
    }

    public static void main(String[] args) {

        Controle c = new Controle();

        c.cadastrarEstacionamento(new Estacionamento("Park", "31992006338", "park@gmail.com", "1234",
                "31442325000158"));

        c.cadastrarEstacionamento(new Estacionamento("EstAqui", "34988754087", "estaqui@gmail.com", "1234",
                "81453227000194"));

        c.cadastrarLocatario(new Locatario("Danilo", "38982741538", "danilo@gmail.com","1234",
                "11762914670", "310554019", "Silva", "07/06/1996"
                ,"94604268637"));

        c.cadastrarLocatario(new Locatario("Gabriel", "32992321210", "gabriel@gmail.com","1234",
                "24212742659", "135189718", "Martins", "12/02/1995"
                ,"94604268637"));

        PessoaFisica p1 = new PessoaFisica("Stefany", "31987103842", "stefany@gmail.com", "YJGgnCdM2a",
                                            "14995895655", "253400041", "Cavalcanti", "21/04/1995");

        PessoaFisica p2 = new PessoaFisica("César", "34988244706", "cesar@gmail.com", "0i3sUJr8BE",
                "87296830689", "288296102", "Araújo", "02/06/1995");

        PessoaJuridica pj = new PessoaJuridica("PUCMG", "31987424764", "puc@gmail.com", "1234", "34773391000107");

        Locador loc1 = new Locador(p1);
        Locador loc2 = new Locador(p2);
        Locador loc3 = new Locador(pj);

        Carro c1 = new Carro("HAW9853", "Vermelho", "2010", "Strada");
        Carro c2 = new Carro("GNH3515", "Vermelho", "2015", "Siena");
        Carro c3 = new Carro("HKS0096", "Marrom", "2004", "Doblo");
        Carro c4 = new Carro("HAW9853", "Verde", "2010", "Stilo");

        loc1.cadastrarCarro(c1);
        loc2.cadastrarCarro(c2);
        loc3.cadastrarCarro(c3);
        loc3.cadastrarCarro(c4);

        c.cadastrarCarroNosDados(c1);
        c.cadastrarCarroNosDados(c2);
        c.cadastrarCarroNosDados(c3);
        c.cadastrarCarroNosDados(c4);

        c.cadastrarLocador(loc1);
        c.cadastrarLocador(loc2);
        c.cadastrarLocador(loc3);

        int escolha;

        System.out.println("\n-------------- CONTROLE --------------\n");

        while (true) {
            System.out.println("\n1 - Estacionamento");
            System.out.println("2 - Locatário");
            System.out.println("3 - Locador");
            System.out.println("4 - Dados");
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
                    c.controlarLocador();
                    break;
                case 4:
                    c.controlarDados();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }

}
