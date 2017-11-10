import java.util.ArrayList;
import java.util.List;

public class Locador {

    private Historico historicoDeAlugueis = new Historico();
    private Pessoa pessoaLocador;
    private List<Carro> carrosDoLocador = new ArrayList<>();

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
        if(!carrosDoLocador.contains(c)) {
            c.setDonoDoCarro(this);
            carrosDoLocador.add(c);
            System.out.println(c + " " + c.getCor() + " " + c.getAno() + " cadastrado(a) com sucesso!");
        } else System.out.println("Carro já cadastrado!");
    }

    public Historico getHistoricoDeAlugueis() {
        return historicoDeAlugueis;
    }

    public Pessoa getPessoaLocador() {
        return pessoaLocador;
    }

    public List<Carro> getCarrosDoLocador() {
        return carrosDoLocador;
    }

}
