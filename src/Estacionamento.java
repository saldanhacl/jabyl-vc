import org.json.JSONArray;
import org.json.JSONObject;

import java.io.PrintStream;
import java.util.*;

public class Estacionamento extends PessoaJuridica{

    private List<Carro> carrosNoEstacionamento = new ArrayList<>();


    public Estacionamento() {
    }

    public Estacionamento(String nome, String telefone, String email, String senha, String cnpj) {
        super(nome, telefone, email, senha, cnpj);
    }

    public JSONObject toJson(){

        JSONObject json = new JSONObject();

        json.put("nome", this.getNome());
        json.put("telefone", this.getTelefone());
        json.put("email", this.getEmail());
        json.put("cnpj", this.getCnpj());


        return json;
    }

    public void registrarCarro(Carro c){
        if(!carrosNoEstacionamento.contains(c)) {
            carrosNoEstacionamento.add(c);
            c.setEstacionamentoAtual(this);
            System.out.println(c + " " + c.getCor() + " " + c.getAno() + " registrado com sucesso!");
        } else System.out.println("Carro já registrado!");
    }

    public void registrarCarro(PrintStream body, Carro c){

        JSONObject json = new JSONObject();
        String status = "Carro ja registrado...";

        if(!carrosNoEstacionamento.contains(c)) {
            carrosNoEstacionamento.add(c);
            c.setEstacionamentoAtual(this);
            status = "Carro registrado com sucesso";
        }

        json.put("status", status);

        body.println(json);


    }

    public void removerCarro(PrintStream body, Carro c){

        JSONObject json = new JSONObject();
        String status = "Carro nao encontrado";

        if (c.getEmAluguel().equals("Sim"))
            status = "Carro esta alugado";
        else {

            for(int i=0; i < carrosNoEstacionamento.size(); i++){
                if (carrosNoEstacionamento.get(i).getPlaca().equals(c.getPlaca())) {
                    carrosNoEstacionamento.remove(i);
                    status = "Carro devolvido com sucesso!";
                }
            }
        }

        json.put("status", status);
        body.println(json);

    }


    public void mostrarCarrosNoEstacionamento(PrintStream body){


        JSONArray json = new JSONArray();

        for (Carro c : carrosNoEstacionamento){
            json.put(c.toJson());
        }

        body.println(json);

    }

    public void alugarCarro(Locatario l, Carro c, int odometroInicial){

        AluguelERetorno a = new AluguelERetorno(c,l,odometroInicial);
        a.setDataDoAluguel(new Date());
        c.setAluguelDoCarro(a);

    }

    public void alugarCarro(PrintStream body, Locatario l, Carro c, String odometroInicial){

        JSONObject json = new JSONObject();
        String status = "Carro ja esta alugado";
        int odometro = Integer.parseInt(odometroInicial);

        if (odometro < 0){
            status = "Odometro nao pode ser negativo";
        } else {

            if (c.getEmAluguel().equals("Nao")) {
                AluguelERetorno a = new AluguelERetorno(c, l, odometro);
                a.setDataDoAluguel(new Date());
                c.setAluguelDoCarro(a);
                status = "Carro alugado com sucesso!";
            }

        }

        json.put("status", status);
        body.println(json);


    }

    public void retornarCarro(PrintStream body, Carro c, String odometroFinal){

        int odometro = Integer.parseInt(odometroFinal);
        JSONObject json = new JSONObject();
        String status = "Carro nao estava alugado...";
        AluguelERetorno aluguel = c.getAluguelDoCarro();


        if (odometro < aluguel.getValorIncialDoOdometro()){
            status = "Valor final do odometro nao pode ser menor do que o inicial";
        } else {

            if (c.getEmAluguel().equals("Sim")) {

                aluguel.setDataDoRetorno(new Date());
                aluguel.setValorFinalDoOdometro(odometro);
                aluguel.calcularPrecoAluguel();


                aluguel.getLocatarioAlugando().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
                c.getDonoDoCarro().getPessoaLocador().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
                super.getHistoricoDeAlugueis().getListaDeAlugueis().add(aluguel);

                c.setEstahReservado(false);
                c.setEstahAlugado(false);

                status = "Carro retornado com sucesso!";
            }
        }

        json.put("status", status);
        body.println(json);

    }

    public void retornarCarro(Carro c, int odometroFinal){

        c.getAluguelDoCarro().setDataDoRetorno(new Date());
        c.getAluguelDoCarro().setValorFinalDoOdometro(odometroFinal);
        AluguelERetorno aluguel = c.getAluguelDoCarro();
        aluguel.calcularPrecoAluguel();

        aluguel.getLocatarioAlugando().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
        c.getDonoDoCarro().getPessoaLocador().getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());
        super.getHistoricoDeAlugueis().getListaDeAlugueis().add(c.getAluguelDoCarro());

        c.setEstahReservado(false);
        c.setEstahAlugado(false);


    }

}
