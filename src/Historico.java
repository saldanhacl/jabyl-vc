import org.json.JSONArray;
import org.json.JSONObject;

import java.io.PrintStream;
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

    public void mostrarHistorico(PrintStream body){

        JSONArray json = new JSONArray();

        for (AluguelERetorno a : listaDeAlugueis){
            json.put(a.toJSON());
        }

        body.println(json);
    }

    public List<AluguelERetorno> getListaDeAlugueis() {
        return listaDeAlugueis;
    }

}
