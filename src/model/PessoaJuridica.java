package model;

import java.io.Serial;
import java.io.Serializable;

public class PessoaJuridica extends Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 9134452354819055383L;

    private final String cnpj;
    private String nomePessoaContato;

    public PessoaJuridica(String cnpj) {
        super();
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String nome, String email, String telefone, Endereco endereco, String cnpj, String nomePessoaContato) {
        super(nome, email, telefone, endereco);
        this.cnpj = cnpj;
        this.nomePessoaContato = nomePessoaContato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setNomePessoaContato(String nomePessoaContato) {
        this.nomePessoaContato = nomePessoaContato;
    }

    @Override
    public String getNomeContato() {
        return nomePessoaContato;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s", getCnpj(), getTelefone(), getEndereco(), getNomeContato(), getNome());
    }
}
