import org.json.JSONArray;
import org.json.JSONObject;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Estacionamento extends PessoaJuridica{

    private List<Carro> carrosNoEstacionamento = new ArrayList<>();
    private Historico historicoDeAlugueis = new Historico(false,false,true);


    public Estacionamento(String nome, String telefone, String email, String senha, String cnpj) {
        super(nome, telefone, email, senha, cnpj);
    }

    public void registrarCarro(Carro c){
        if(!carrosNoEstacionamento.contains(c)) {
            carrosNoEstacionamento.add(c);
            c.setEstacionamentoAtual(this);
            System.out.println(c + " " + c.getCor() + " " + c.getAno() + " registrado com sucesso!");
        } else System.out.println("Carro já registrado!");
    }

    public void mostrarCarrosNoEstacionamento(PrintStream body){

        JSONArray json = new JSONArray();

        for (Carro c : carrosNoEstacionamento){
            json.put(c.toJson());
        }

        body.println(json);

    }

    public void alugarCarro(Locatario l, Carro c){

        Scanner in = new Scanner(System.in);
        int odometro;

        System.out.println("Digite o valor inicial do odômetro: ");
        System.out.print("-> ");
        odometro = in.nextInt();

        AluguelERetorno a = new AluguelERetorno(c,l,odometro);
        a.setDataDoAlguel(new Date());
        c.setAluguelDoCarro(a);
        System.out.println("\n*********Carro alugado com sucesso!************\n");

    }

    public void retornarCarro(Carro c){

        Scanner in = new Scanner(System.in);

        int odometro;

        System.out.println("Digite o valor final do odômetro: ");
        System.out.print("-> ");
        odometro = in.nextInt();

        c.getAluguelDoCarro().setDataDoRetorno(new Date());

        c.getAluguelDoCarro().setValorFinalDoOdometro(odometro);

        c.getLocatarioDoCarro().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
        c.getDonoDoCarro().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
        this.historicoDeAlugueis.getListaDeAlugueis().add(c.getAluguelDoCarro());

        c.setEstahReservado(false);
        c.setEstahAlugado(false);
        c.setLocatarioDoCarro(null);

        System.out.println("\n*********Carro retornado com sucesso!************\n");


    }

    public Historico getHistoricoDeAlugueis() {
        return historicoDeAlugueis;
    }
}
