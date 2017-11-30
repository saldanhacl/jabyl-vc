public class Usuario {

    private Historico historicoDeAlugueis = new Historico();
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public boolean autenticar(String email, String senha){
        if (this.email.equals(email) && this.senha.equals(senha)){
            return true;
        } else return false;
    }

    public Historico getHistoricoDeAlugueis() {
        return historicoDeAlugueis;
    }

}
