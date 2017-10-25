import java.util.ArrayList;
import java.util.List;

public class Locatario extends PessoaFisica{

    private String cnh;
    private List<Aluguel> historicoDeAlugueis = new ArrayList<>();

    public Locatario(String nome, String telefone, String email, String senha,
                     String cpf, String rg, String sobrenome, String dataDeNascimento,
                     String cnh) {
        super(nome, telefone, email, senha, cpf, rg, sobrenome, dataDeNascimento);
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return super.toString() + " CNH: " + this.cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public List<Aluguel> getHistoricoDeAlugueis() {
        return historicoDeAlugueis;
    }

    public void mostrarHistorico(){
        System.out.println("--------- HISTÓRICO ----------");
        for (Aluguel a : historicoDeAlugueis) {
            System.out.println("Carro alugado: " + a.getCarroAlugado());
            System.out.println("Odômetro inicial: " + a.getValorIncialDoOdometro());
        }
        System.out.println("-----------------------------------");
    }


}
