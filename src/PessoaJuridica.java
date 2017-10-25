public class PessoaJuridica extends Pessoa{

    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String email, String senha,
                          String cnpj) {
        super(nome, telefone, email, senha);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


}
