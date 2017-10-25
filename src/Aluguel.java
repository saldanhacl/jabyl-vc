public class Aluguel {

    private Carro carroAlugado;
    private Locatario locatarioAlugando;
    private int valorIncialDoOdometro;

    public Aluguel(Carro carroAlugado, Locatario locatarioAlugando, int valorIncialDoOdometro) {
        this.carroAlugado = carroAlugado;
        this.locatarioAlugando = locatarioAlugando;
        this.valorIncialDoOdometro = valorIncialDoOdometro;
        carroAlugado.setStatus(true);
        carroAlugado.setLocatarioDoCarro(locatarioAlugando);
    }

    public Carro getCarroAlugado() {
        return carroAlugado;
    }

    public Locatario getLocatarioAlugando() {
        return locatarioAlugando;
    }

    public int getValorIncialDoOdometro() {
        return valorIncialDoOdometro;
    }
}
