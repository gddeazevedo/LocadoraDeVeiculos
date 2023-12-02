package controller;

import java.io.Serial;
import java.io.Serializable;

import exception.CNHException;
import exception.CPFException;
import exception.EmailException;
import exception.ValidadeCNHException;
import model.Endereco;
import model.PessoaJuridica;
import model.PessoaFisica;
import model.Cliente;
import util.ClienteValidator;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClienteController implements Serializable {
    @Serial
    private static final long serialVersionUID = -8994132440460635970L;
    private final Map<String, PessoaFisica> pessoasF;
    private final Map<String, PessoaJuridica> pessoasJ;

    public ClienteController() {
        pessoasF = new TreeMap<>();
        pessoasJ = new TreeMap<>();
    }

    public void addPessoaFisica(
            String nome,
            String email,
            String telefone,
            String cpf,
            String numCNH,
            String validadeCNH,
            String rua,
            String numero,
            String cep
    ) throws CNHException, CPFException, EmailException, ValidadeCNHException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateValidadeCNH;
        try {
            dateValidadeCNH = formatter.parse(validadeCNH);
        } catch (Exception e) {
            throw new ValidadeCNHException("Erro ao converter a data");
        }
        ClienteValidator.validateCNH(numCNH);
        ClienteValidator.validateCPF(cpf);
        ClienteValidator.validateEmail(email);
        ClienteValidator.validateValidadeCNH(dateValidadeCNH);
        var endereco = new Endereco(rua, numero, cep);
        var cliente = new PessoaFisica(nome, email, telefone, endereco, cpf, numCNH, dateValidadeCNH);
        pessoasF.put(cpf, cliente);
        MainController.save();
    }

    public void addPessoaJuridica(
            String nome,
            String email,
            String telefone,
            String cnpj,
            String nomePessoaContato,
            String rua,
            String numero,
            String cep
    ) throws EmailException {
        ClienteValidator.validateEmail(email);
        var endereco = new Endereco(rua, numero, cep);
        var cliente = new PessoaJuridica(nome, email, telefone, endereco, cnpj, nomePessoaContato);
        pessoasJ.put(cnpj, cliente);
        MainController.save();
    }

    public Set<String> getListaPessoasF() {
        return pessoasF.keySet(); // retorna lista das chaves do map
    }

    public Set<String> getListaPessoasJ() {
        return pessoasJ.keySet(); // retorna lista das chaves do map
    }

    public List<String> getListaFormatedPessoasF() {

        List<String> lista = new ArrayList<>();

        for (PessoaFisica pessoas : pessoasF.values())
            lista.add(String.format("%s\t%s\t%s\t%s", pessoas.getCpf(), pessoas.getNome(), pessoas.getTelefone(),
                    pessoas.getEndereco()));

        return lista;
    }

    public List<String> getListaFormatedPessoasJ() {

        List<String> lista = new ArrayList<>();

        for (PessoaJuridica pessoas : pessoasJ.values())
            lista.add(String.format("%s\t%s\t%s\t%s\t%s", pessoas.getCnpj(), pessoas.getTelefone(),
                    pessoas.getEndereco(), pessoas.getNomeContato(), pessoas.getNome()));

        return lista;
    }

    public DefaultComboBoxModel<Cliente> getDefaultComboBoxModelForCliente() {
        DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel<>();
        for (PessoaFisica pessoa : pessoasF.values()) {
            model.addElement(pessoa);
        }
        for (PessoaJuridica pessoa : pessoasJ.values()) {
            model.addElement(pessoa);
        }
        return model;
    }
}
