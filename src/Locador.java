import org.json.JSONArray;
import org.json.JSONObject;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Locador{

    private List<Carro> carrosDoLocador = new ArrayList<>();
    private Usuario pessoaLocador;

    public Locador() {
    }
        public Locador(PessoaFisica pessoaLocador) {
        this.pessoaLocador = pessoaLocador;
    }

    public Locador(PessoaJuridica pessoaLocador) {
        this.pessoaLocador = pessoaLocador;
    }

    @Override
    public String toString() {
        if (this.pessoaLocador instanceof PessoaFisica) return pessoaLocador + "";
        else return pessoaLocador.getNome();
    }

    public void cadastrarCarro(Carro c){
        if(!this.carrosDoLocador.contains(c)) {
            c.setDonoDoCarro(this);
            this.carrosDoLocador.add(c);
            System.out.println(c + " " + c.getCor() + " " + c.getAno() + " cadastrado(a) com sucesso!");
        } else System.out.println("Carro já cadastrado!");
    }

    public void cadastrarCarro(PrintStream body, Carro c){

        JSONObject json = new JSONObject();
        String status = "Carro ja registrado...";

        if(!this.carrosDoLocador.contains(c)) {
            c.setDonoDoCarro(this);
            this.carrosDoLocador.add(c);
            status = "Carro registrado com sucesso";
        }

        json.put("status", status);

        body.println(json);

    }


    public Usuario getPessoaLocador() {
        return pessoaLocador;
    }

    public void mostrarCarrosLocador(PrintStream body) {

        JSONArray json = new JSONArray();

        for (Carro c : carrosDoLocador) {
            System.out.println(c);
            json.put(c.toJson());
        }

        body.println(json);
    }

    public void setPessoaLocador(Usuario pessoaLocador) {
        this.pessoaLocador = pessoaLocador;
    }

    public List<Carro> getCarrosDoLocador() {
        return carrosDoLocador;
    }
}
