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
    private Locador donoDoCarro;
    private Estacionamento estacionamentoAtual;

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

    public String getCor() {
        return cor;
    }

    public String getAno() {
        return ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEmAluguel() {
        if (this.estahAlugado) return "Sim";
        else return "Não";
    }

    public Locador getDonoDoCarro() {
        return donoDoCarro;
    }

    public void setDonoDoCarro(Locador donoDoCarro) {
        this.donoDoCarro = donoDoCarro;
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

    public Estacionamento getEstacionamentoAtual() {
        return estacionamentoAtual;
    }

    public void setEstacionamentoAtual(Estacionamento estacionamentoAtual) {
        this.estacionamentoAtual = estacionamentoAtual;
    }
}
