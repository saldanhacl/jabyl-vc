import org.json.JSONObject;

import java.io.PrintStream;

public class Carro {

    private String placa;
    private String cor;
    private String ano;
    private String modelo;
    private boolean estahAlugado;
    private boolean estahReservado;
    private Locatario locatarioDoCarro;
    private AluguelERetorno aluguelDoCarro;
    private Locador donoDoCarro;
    private Estacionamento estacionamentoAtual;

    public Carro() {
    }

    public Carro(String placa) {
        this.setPlaca(placa);
    }

    public Carro(String placa, String cor, String ano, String modelo) {
        this.setPlaca(placa);
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
        else return "Nao";
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

    public void setEstahReservado(boolean estahReservado){
        this.estahReservado = estahReservado;
    }

    public void setEstahReservado(PrintStream body, boolean estahReservado) {

        JSONObject json = new JSONObject();
        String status = "Nao foi possivel reservar o carro.";

        if (this.getEmAluguel().equals("Sim"))
            status += " Carro esta alugado.";
        else if (this.getEstahReservado().equals("Sim"))
            status += " Carrro esta reservado";

        else status = "Carro reservado com sucesso!";
        this.estahReservado = estahReservado;

        json.put("status", status);
        body.println(json);
    }

    public String getEstahReservado() {
        if (this.estahReservado) return "Sim";
        else return "Nao";
    }

    public Estacionamento getEstacionamentoAtual() {
        return estacionamentoAtual;
    }

    public void setEstacionamentoAtual(Estacionamento estacionamentoAtual) {
        this.estacionamentoAtual = estacionamentoAtual;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public JSONObject toJson(){

        JSONObject json = new JSONObject();

        json.put("Dono", this.donoDoCarro);
        json.put("Modelo", this.modelo);
        json.put("Placa", this.placa);
        json.put("Ano", this.ano);
        json.put("Cor", this.cor);
        json.put("Alugado", this.getEmAluguel());
        json.put("Reservado", this.getEstahReservado());


        return json;
    }

}
