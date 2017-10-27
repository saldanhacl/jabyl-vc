public class AluguelERetorno {

    private Carro carroAlugado;
    private Locatario locatarioAlugando;
    private int valorIncialDoOdometro;
    private int valorFinalDoOdometro;

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
}
