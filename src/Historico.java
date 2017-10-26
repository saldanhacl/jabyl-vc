import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<AluguelERetorno> listaDeAlugueis = new ArrayList<>();
    private boolean ehLocador;

    public Historico(boolean ehLocador) {
        this.ehLocador = ehLocador;
    }

    public void getHistorico(){
        System.out.println("\n--------- HISTÓRICO ----------\n");
        for (AluguelERetorno a : listaDeAlugueis){
            if (ehLocador){
                System.out.println("Locatário: " + a.getLocatarioAlugando());
            }
            System.out.println("Carro alugado: " + a.getCarroAlugado());
            System.out.println("Distância percorrida: " + a.getDistanciaPercorrida());
            System.out.println("\n----------------------------------\n");
        }
    }

    public List<AluguelERetorno> getListaDeAlugueis() {
        return listaDeAlugueis;
    }

    public boolean getEhLocador() {
        return ehLocador;
    }
}
