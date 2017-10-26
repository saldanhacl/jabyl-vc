import java.util.ArrayList;
import java.util.List;

public class Historico {

    List<AluguelERetorno> listaDeAlugueis = new ArrayList<>();

    public void getHistorico(){
        System.out.println("\n--------- HISTÓRICO ----------\n");
        for (AluguelERetorno a : listaDeAlugueis){
            System.out.println("Carro alugado: " + a.getCarroAlugado());
            System.out.println("Distância percorrida: " + a.getDistanciaPercorrida());
            System.out.println("\n----------------------------------\n");
        }
    }

    public List<AluguelERetorno> getListaDeAlugueis() {
        return listaDeAlugueis;
    }

}
