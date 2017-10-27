import java.util.Date;

public class AluguelERetorno {

    private Carro carroAlugado;
    private Locatario locatarioAlugando;
    private int valorIncialDoOdometro;
    private int valorFinalDoOdometro;
    private Date dataDoAlguel;
    private Date dataDoRetorno;

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
