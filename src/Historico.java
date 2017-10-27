import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<AluguelERetorno> listaDeAlugueis = new ArrayList<>();
    private boolean ehLocatario;
    private boolean ehLocador;
    private boolean ehEstacionamento;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Historico(boolean ehLocatario, boolean ehLocador, boolean ehEstacionamento) {
        this.ehLocatario = ehLocatario;
        this.ehLocador = ehLocador;
        this.ehEstacionamento = ehEstacionamento;
    }

    public void getHistorico(){
        System.out.println("\n--------- HISTÓRICO ----------\n");
        for (AluguelERetorno a : listaDeAlugueis){
            if (!ehLocatario){
                System.out.println("Locatário: " + a.getLocatarioAlugando());
            }
            if (!ehLocador){
                System.out.println("Locador: " + a.getCarroAlugado().getDonoDoCarro());
            }
            if (!ehEstacionamento){
                System.out.println("Estacionamento: " + a.getCarroAlugado().getEstacionamentoAtual());
            }
            System.out.println("Carro alugado: " + a.getCarroAlugado());
            System.out.println("Distância percorrida: " + a.getDistanciaPercorrida());
            System.out.println("Data do aluguel: " + dateFormat.format(a.getDataDoAlguel()));
            System.out.println("Data do retorno: " + dateFormat.format(a.getDataDoRetorno()));
            System.out.println("\n----------------------------------\n");
        }
    }

    public List<AluguelERetorno> getListaDeAlugueis() {
        return listaDeAlugueis;
    }

}
