import org.json.JSONArray;
import org.json.JSONObject;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<AluguelERetorno> listaDeAlugueis = new ArrayList<>();

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
