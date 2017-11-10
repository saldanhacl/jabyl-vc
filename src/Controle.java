import org.json.JSONObject;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Controle {

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

    private void cadastrarLocador(Locador l){

        if(!listaDeLocadores.contains(l)) {
            listaDeLocadores.add(l);
            System.out.println("Locador(a) " + l + " cadastrado(a) com sucesso!");
        } else System.out.println("Locador já cadastrado!");

    }



    private void cadastrarEstacionamento(Estacionamento e){

        if(!listaDeEstacionamentos.contains(e)) {
            listaDeEstacionamentos.add(e);
            System.out.println("Estacionamento " + e + " cadastrado(a) com sucesso!");
        } else System.out.println("Estacionamento já cadastrado!");

    }

    private void cadastrarCarroNosDados(Carro c){
        if(!listaDeCarros.contains(c)) {
            listaDeCarros.add(c);
            System.out.println("Carro " + c + " cadastrado nos dados com sucesso!");
        } else System.out.println("Carro já cadastrado nos dados...");

    }


    public void validarUsuario(PrintStream body, String email, String senha){

        JSONObject json = new JSONObject();
        String tipo = "";
        String status = "Email ou senha incorretos";

        for (Locatario l : listaDeLocatarios){
            if (l.autenticar(email,senha)) {
                status = "OK";
                tipo = "locatario";
            }
        }

        for (Estacionamento e : listaDeEstacionamentos){
            if (e.autenticar(email,senha)) {
                status = "OK";
                tipo = "estacionamento";
            }
        }

        for (Locador l : listaDeLocadores){
            if (l.getPessoaLocador().autenticar(email,senha)) {
                status = "OK";
                tipo = "locador";
            }
        }

        json.put("status", status);
        json.put("tipo", tipo);
        json.put("operacao", "realizarLogin");

        body.println(json);

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

    public List<Locador> getListaDeLocadores() {
        return listaDeLocadores;
    }

    public Controle iniciarControle() {

        Controle c = new Controle();

        c.cadastrarEstacionamento(new Estacionamento("Park", "31992006338", "park@gmail.com", "1234",
                "31442325000158"));

        c.cadastrarEstacionamento(new Estacionamento("EstAqui", "34988754087", "estaqui@gmail.com", "1234",
                "81453227000194"));

        Locatario l1 = new Locatario("Danilo", "38982741538", "danilo@gmail.com","1234",
                "11762914670", "310554019", "Silva", "07/06/1996"
                ,"94604268637");

        c.cadastrarLocatario(l1);

        c.cadastrarLocatario(new Locatario("Gabriel", "32992321210", "gabriel@gmail.com","1234",
                "24212742659", "135189718", "Martins", "12/02/1995"
                ,"94604268637"));

        PessoaFisica p1 = new PessoaFisica("Stefany", "31987103842", "stefany@gmail.com", "YJGgnCdM2a",
                "14995895655", "253400041", "Cavalcanti", "21/04/1995");

        PessoaFisica p2 = new PessoaFisica("Cesar", "34988244706", "cesar@gmail.com", "0i3sUJr8BE",
                "87296830689", "288296102", "Araujo", "02/06/1995");

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

        c.getListaDeEstacionamentos().get(0).registrarCarro(c1);
        c.getListaDeEstacionamentos().get(0).registrarCarro(c2);
        c.getListaDeEstacionamentos().get(0).registrarCarro(c3);
        c.getListaDeEstacionamentos().get(0).registrarCarro(c4);

        c.getListaDeEstacionamentos().get(0).alugarCarro(l1,c1,100);
        c.getListaDeEstacionamentos().get(0).retornarCarro(c1,200);
        c.getListaDeEstacionamentos().get(0).alugarCarro(l1,c2,10);
        c.getListaDeEstacionamentos().get(0).retornarCarro(c2,50);
        c.getListaDeEstacionamentos().get(0).alugarCarro(l1,c3,32);
        c.getListaDeEstacionamentos().get(0).retornarCarro(c3,48);
        c.getListaDeEstacionamentos().get(0).alugarCarro(l1,c1,1456);
        c.getListaDeEstacionamentos().get(0).retornarCarro(c1,1480);


        return c;

    }

}
