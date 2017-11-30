public class PessoaFisica extends Usuario {

    private String cpf;
    private String rg;
    private String sobrenome;
    private String dataDeNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String telefone, String email, String senha,
                        String cpf, String rg, String sobrenome, String dataDeNascimento) {
        super(nome, telefone, email, senha);
        this.cpf = cpf;
        this.rg = rg;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return super.toString() + " " +  this.sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

}
