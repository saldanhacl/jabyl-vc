public class PessoaJuridica extends Usuario {

    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String telefone, String email, String senha,
                          String cnpj) {
        super(nome, telefone, email, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }


}
