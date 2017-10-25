public class Retorno {

    private Carro carroRetornado;
    private int valorFinalDoOdometro;

    public Retorno(Carro carroRetornado, int valorFinalDoOdometro) {
        this.carroRetornado = carroRetornado;
        this.valorFinalDoOdometro = valorFinalDoOdometro;
        carroRetornado.setStatus(false);
        carroRetornado.setLocatarioDoCarro(null);
    }

    public Carro getCarroRetornado() {
        return carroRetornado;
    }

    public void setCarroRetornado(Carro carroRetornado) {
        this.carroRetornado = carroRetornado;
    }

    public int getValorFinalDoOdometro() {
        return valorFinalDoOdometro;
    }

    public void setValorFinalDoOdometro(int valorFinalDoOdometro) {
        this.valorFinalDoOdometro = valorFinalDoOdometro;
    }
}


