package controller;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import model.*;

public class ServicosController implements Serializable {
    @Serial
    private static final long serialVersionUID = 5453432785989660583L;

    private static int devolucoesKey = 0;

    private final Map<UUID, Reserva> reservas;
    private final Map<UUID, Locacao> locacoes;
    private final Map<Integer, Devolucao> devolucoes;

    public ServicosController() {
        reservas = new TreeMap<>();
        locacoes = new TreeMap<>();
        devolucoes = new TreeMap<>();
    }

    public void addReserva(
            Categoria categoria,
            Date inicioLocacao,
            Date finalLocacao,
            Cliente cliente,
            List<String> seguros
    ) {
        UUID uuid = UUID.randomUUID();
        Reserva reserva = new Reserva(uuid, categoria, inicioLocacao, finalLocacao, cliente);
        for (String seguro : seguros) {
            reserva.addSeguro(MainController.getCatalogoController().getSeguro(seguro));
        }
        reservas.put(reserva.getUuid(), reserva); // insere novo objeto categoria no map
        MainController.save();
    }

    public void addLocacao(String reservaUUID, Veiculo veiculo, int km) {
        UUID key = UUID.fromString(reservaUUID);
        Reserva reserva = reservas.get(key);
        Locacao locacao = new Locacao(reserva, veiculo, km);
        locacoes.put(key, locacao);
        MainController.save();
    }

    public void addDevolucao(int km, Pagamento pagamento) {
        Devolucao d = new Devolucao(km, pagamento);
        devolucoes.put(devolucoesKey, d);
        devolucoesKey++;
        MainController.save();
    }

    public ComboBoxModel<String> getDefaultComboBoxModelForReservas() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Reserva reserva : reservas.values()) {
            model.addElement(reserva.getUuid().toString());
        }
        return model;
    }

    public DefaultComboBoxModel<Locacao> getDefaultComboBoxModelForLocacoes() {
        DefaultComboBoxModel<Locacao> model = new DefaultComboBoxModel<>();
        for (Locacao locacao : locacoes.values()) {
            model.addElement(locacao);
        }
        return model;
    }

    public double getTotalDiarias(Locacao locacao) {

        Date inicio = locacao.getReserva().getInicioLocacao();
        Date fim = locacao.getReserva().getFinalLocacao();

        int periodoLocacao = (int) ((fim.getTime() - inicio.getTime()) / (1000 * 60 * 60 * 24));

        long totalDiarias = (long) (periodoLocacao * locacao.getReserva().getValorTarifa());

        return totalDiarias;
    }

    public double getTotalLocacao(Locacao locacao) {
        double valorTotal = 0;
        double valorTarifaDiaria = locacao.getReserva().getCategoria().getTarifaDiaria();
        int periodoLocacao = locacao.getReserva().getPeridoLocacao();
        List<Seguro> seguros = locacao.getReserva().getSeguros();

        for (Seguro seguro : seguros) {
            valorTotal += periodoLocacao * seguro.getPercentualTarifa() * valorTarifaDiaria;
        }

        valorTotal += locacao.getReserva().getValorTarifa();

        return valorTotal;
    }

    public double getTotalSeguros(Locacao locacao) {
        double valorTotal = 0;
        double valorTarifaDiaria = locacao.getReserva().getCategoria().getTarifaDiaria();
        int periodoLocacao = locacao.getReserva().getPeridoLocacao();
        List<Seguro> seguros = locacao.getReserva().getSeguros();

        for (Seguro seguro : seguros) {
            valorTotal += periodoLocacao * seguro.getPercentualTarifa() * valorTarifaDiaria;
        }

        return valorTotal;
    }

    public List<String> getListaFormatedReservas() {

        List<String> lista = new ArrayList<>();

        for (Reserva reserva : reservas.values())
            lista.add(String.format("%s\t%s\t%s\t%s", reserva.getUuid(), reserva.getCategoria(),
                    reserva.getInicioLocacao(), reserva.getFinalLocacao()));

        return lista;
    }

    public List<String> getListaFormatedLocacoes() {

        List<String> lista = new ArrayList<>();

        for (Locacao locacao : locacoes.values())
            lista.add(String.format("%s\t%s\t%s\t%s", locacao.getReserva(), locacao.getVeiculo(), locacao.getData(),
                    locacao.getKm()));

        return lista;
    }

    public Reserva getReservaByUUID(String reservaUUID) {
        UUID key = UUID.fromString(reservaUUID);
        return reservas.get(key);
    }
}
