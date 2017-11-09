import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AluguelERetorno {

    private Carro carroAlugado;
    private Locatario locatarioAlugando;
    private int valorIncialDoOdometro;
    private int valorFinalDoOdometro;
    private Date dataDoAlguel;
    private Date dataDoRetorno;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public AluguelERetorno(Carro carroAlugado, Locatario locatarioAlugando, int valorIncialDoOdometro) {
        this.carroAlugado = carroAlugado;
        this.locatarioAlugando = locatarioAlugando;
        this.valorIncialDoOdometro = valorIncialDoOdometro;
        carroAlugado.setEstahAlugado(true);
        carroAlugado.setLocatarioDoCarro(locatarioAlugando);
    }

    public Carro getCarroAlugado() {
        return carroAlugado;
    }

    public Locatario getLocatarioAlugando() {
        return locatarioAlugando;
    }

    public void setValorFinalDoOdometro(int valorFinalDoOdometro) {
        this.valorFinalDoOdometro = valorFinalDoOdometro;
    }

    public double getDistanciaPercorrida(){
        return valorFinalDoOdometro - valorIncialDoOdometro;
    }

    public Date getDataDoAlguel() {
        return dataDoAlguel;
    }

    public JSONObject toJSON(){

        JSONObject json = new JSONObject();

        json.put("locatario", locatarioAlugando);
        json.put("locador", carroAlugado.getDonoDoCarro());
        json.put("estacionamento", carroAlugado.getEstacionamentoAtual());
        json.put("carro", carroAlugado);
        json.put("distancia", getDistanciaPercorrida());
        json.put("dataAluguel", dateFormat.format(dataDoAlguel));
        json.put("dataRetorno", dateFormat.format(dataDoRetorno));

        return json;

    }

    public void setDataDoAlguel(Date dataDoAlguel) {
        this.dataDoAlguel = dataDoAlguel;
    }

    public Date getDataDoRetorno() {
        return dataDoRetorno;
    }

    public void setDataDoRetorno(Date dataDoRetorno) {
        this.dataDoRetorno = dataDoRetorno;
    }
}
