public class Carro {

    private String placa;
    private String cor;
    private String ano;
    private String modelo;
    private String idRegistro;
    private boolean estahAlugado;
    private boolean estahReservado;
    private Locatario locatarioDoCarro;
    private AluguelERetorno aluguelDoCarro;

    public Carro(String placa, String cor, String ano, String modelo) {
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.modelo = modelo;
        this.estahAlugado = false;
        this.estahReservado = false;
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

    public String getEmAluguel() {
        if (this.estahAlugado) return "Sim";
        else return "Não";
    }

    public void setEstahAlugado(boolean estahAlugado) {
        this.estahAlugado = estahAlugado;
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

    public void setEstahReservado(boolean estahReservado) {
        this.estahReservado = estahReservado;
    }

    public String getEstahReservado() {
        if (this.estahReservado) return "Sim";
        else return "Não";
    }
}
