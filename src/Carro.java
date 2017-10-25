public class Carro {

    private String placa;
    private String cor;
    private String ano;
    private String modelo;
    private String idRegistro;
    private boolean estahAlugado;
    private Locatario locatarioDoCarro;
    private AluguelERetorno aluguelDoCarro;

    public Carro(String placa, String cor, String ano, String modelo) {
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.modelo = modelo;
        this.estahAlugado = false;
    }

    @Override
    public String toString() {
        return  modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getStatus() {
        if (this.estahAlugado) return "Alugado";
        else return "Disponível";
    }

    public void setStatus(boolean status){
        this.estahAlugado = status;
    }

    public Locatario getLocatarioDoCarro() {
        return locatarioDoCarro;
    }

    public void setLocatarioDoCarro(Locatario locatarioDoCarro) {
        this.locatarioDoCarro = locatarioDoCarro;
    }

    public AluguelERetorno getAluguelDoCarro() {
        return aluguelDoCarro;
    }

    public void setAluguelDoCarro(AluguelERetorno aluguelDoCarro) {
        this.aluguelDoCarro = aluguelDoCarro;
    }
}
