package controller;

import exception.CategoriaException;
import model.*;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class CatalogoController implements Serializable {
    @Serial
    private static final long serialVersionUID = 1945660933431033557L;

    private final Map<String, Categoria> categorias;
    private final Map<String, Seguro> seguros;
    private final Map<String, Veiculo> veiculos;

    public CatalogoController() {
        categorias = new TreeMap<>();
        seguros = new TreeMap<>();
        veiculos = new TreeMap<>();
    }

    public void addCategoria(String nome, double tarifaDiaria) {
        Categoria categoria = new Categoria(nome, tarifaDiaria);
        categorias.put(nome, categoria);
        MainController.save();
    }

    public void addVeiculo(
            String placa,
            String anoFabricacao,
            String cor,
            String nomeModelo,
            String anoModelo,
            String fabricanteModelo,
            Categoria categoria,
            EStatusVeiculo status,
            double km
    ) throws CategoriaException {
        Modelo modelo = new Modelo(nomeModelo, anoModelo, fabricanteModelo);
        Veiculo veiculo = new Veiculo(placa, anoFabricacao, cor, modelo, status, km);
        veiculo.setCategoria(categoria);
        categoria.addVeiculo(veiculo);
        veiculos.put(placa, veiculo);
        MainController.save();
    }

    public void addSeguro(String categoria, String tipo, double percentualTarifa) {
        var seguro = new Seguro(tipo, percentualTarifa);
        categorias.get(categoria).addSeguro(seguro);
        seguros.put(tipo, seguro);
        MainController.save();
    }

    public Set<String> getCategorias() {
        return categorias.keySet(); // retorna lista das chaves do map
    }

    public Set<String> getVeiculos() {
        return veiculos.keySet(); // retorna lista das chaves do map
    }

    public Set<String> getSeguros() {
        return seguros.keySet();
    }

    public List<Seguro> getSegurosByCategoria(String categoria) {
        return categorias.get(categoria).getSeguros();
    }

    public Seguro getSeguro(String seguro) {
        return seguros.get(seguro);
    }

    public DefaultComboBoxModel<Categoria> getDefaultComboBoxModelForCategoria() {
        DefaultComboBoxModel<Categoria> model = new DefaultComboBoxModel<>();
        for (Categoria categoria : categorias.values()) {
            model.addElement(categoria);
        }
        return model;
    }

    public DefaultComboBoxModel<Veiculo> getDefaultComboBoxModelForVeiculo() {
        DefaultComboBoxModel<Veiculo> model = new DefaultComboBoxModel<>();

        veiculos.forEach((_placa, veiculo) -> {
            var status = veiculo.getStatus();
            if (status == EStatusVeiculo.DISPONIVEL) {
                model.addElement(veiculo);
            }
        });

        return model;
    }

    public DefaultComboBoxModel<Veiculo> getDefaultComboBoxModelForVeiculoFromCategoria(Categoria categoria) {
        DefaultComboBoxModel<Veiculo> model = new DefaultComboBoxModel<>();

        categoria.getVeiculos().forEach(veiculo -> {
            var status = veiculo.getStatus();
            if (status == EStatusVeiculo.DISPONIVEL) {
                model.addElement(veiculo);
            }
        });

        return model;
    }

    public List<String> getListaFormatedCategorias() {
        List<String> lista = new ArrayList<>();

        for (Categoria categorias : categorias.values())
            lista.add(String.format("%s\t%f", categorias.getNome(), categorias.getTarifaDiaria()));

        return lista;
    }

    public List<String> getListaFormatedVeiculos() {

        List<String> lista = new ArrayList<>();

        for (Veiculo veiculo : veiculos.values())
            lista.add(veiculo.getFormattedInfo());

        return lista;
    }

    public List<String> getListaFormatedSeguros() {

        List<String> lista = new ArrayList<>();

        for (Seguro seguros : seguros.values())
            lista.add(String.format("%s\t%f", seguros.getTipo(), seguros.getPercentualTarifa()));

        return lista;
    }
}
