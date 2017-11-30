import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import java.awt.*;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

public class Server implements Container{

    static Controle c = new Controle();

    public void handle(Request request, Response response) {
        try {
            Query query = request.getQuery();
            PrintStream body = response.getPrintStream();
            long time = System.currentTimeMillis();

            response.setValue("Content-Type", "application/json");
            response.setValue("Access-Control-Allow-Origin", "*");
            response.setValue("Server", "HelloWorld/1.0 (Simple 4.0)");
            response.setDate("Date", time);
            response.setDate("Last-Modified", time);

            String operacao = query.get("operacao");

            if (operacao == null){
                operacao = "";
            }

            switch (operacao){

                case "removerCarro":
                    Estacionamento estRemover = c.pesquisarEstacionamento(query.get("email"));
                    Carro carroRemovido = c.pesquisaCarro(query.get("placa"));
                    estRemover.removerCarro(body, carroRemovido);
                    break;
                case "reservarCarro":
                    Carro carReservar = c.pesquisaCarro(query.get("placa"));
                    carReservar.setEstahReservado(body, true);
                    break;
                case "registrarCarroLocador":
                    Carro novoCarro = new Carro(query.get("placa"), query.get("cor"), query.get("ano"), query.get("modelo"));
                    Locador l = c.pesquisarLocador(query.get("email"));
                    c.cadastrarCarroNosDados(body,l,novoCarro);
                    break;
                case "alugarCarro":
                    Locatario locAlugar = c.pesquisarLocatario(query.get("emailLocatario"));
                    Estacionamento estAlugar = c.pesquisarEstacionamento(query.get("email"));
                    Carro carroAlugar = c.pesquisaCarro(query.get("placa"));
                    estAlugar.alugarCarro(body, locAlugar, carroAlugar, query.get("odometro"));
                    break;
                case "retornarCarro":
                    Estacionamento estRetornar = c.pesquisarEstacionamento(query.get("email"));
                    Carro carroRetornar = c.pesquisaCarro(query.get("placa"));
                    estRetornar.retornarCarro(body, carroRetornar,query.get("odometro"));
                    break;
                case "registrarCarroEstacionamento":
                    Estacionamento estRegistro = c.pesquisarEstacionamento(query.get("email"));
                    Carro carroPesquisado = c.pesquisaCarro(query.get("placa"));
                    estRegistro.registrarCarro(body, carroPesquisado);
                    break;
                case "mostrarCarrosLocador":
                    c.mostrarCarrosLocador(body,query.get("email"));
                    break;
                case "mostrarCarrosNoEstacionamento":
                    Estacionamento est = c.pesquisarEstacionamento(query.get("email"));
                    est.mostrarCarrosNoEstacionamento(body);
                    break;
                case "realizarLogin":
                    c.validarUsuario(body,query.get("email"),query.get("senha"));
                    break;
                case "mostrarHistoricoEstacionamento":
                    Estacionamento estHist = c.pesquisarEstacionamento(query.get("email"));
                    estHist.getHistoricoDeAlugueis().mostrarHistorico(body);
                    break;
                case "mostrarHistoricoLocador":
                    Locador locHist = c.pesquisarLocador(query.get("email"));
                    locHist.getPessoaLocador().getHistoricoDeAlugueis().mostrarHistorico(body);
                    break;
                case "mostrarHistoricoLocatario":
                    Locatario locaHist = c.pesquisarLocatario(query.get("email"));
                    locaHist.getHistoricoDeAlugueis().mostrarHistorico(body);
                    break;
                case "mostrarEstacionamentos":
                    c.mostrarEstacionamentos(body);
                    break;
                case "nomeUsuario":
                    c.nomeUsuario(body, query.get("email"));
                    break;
            }

            body.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] list) throws Exception {
        // Se voc� receber uma mensagem
        // "Address already in use: bind error",
        // tente mudar a porta.

        c = c.iniciarControle();
        int porta = 7100;

        // Configura uma conex�o soquete para o servidor HTTP.
        Container container = new Server();
        ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
        Connection conexao = new SocketConnection(servidor);
        SocketAddress endereco = new InetSocketAddress(porta);
        conexao.connect(endereco);


        System.out.println("Tecle ENTER para interromper o servidor...");
        System.in.read();

        conexao.close();
        servidor.stop();

    }

    }

