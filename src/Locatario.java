import java.util.ArrayList;
import java.util.List;

public class Locatario extends PessoaFisica{

    private String cnh;
    private Historico historicoDeAlugueis = new Historico();

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

    public Historico getHistoricoDeAlugueis() {
        return historicoDeAlugueis;
    }

}
