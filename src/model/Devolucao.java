package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Devolucao implements Serializable {
    @Serial
    private static final long serialVersionUID = -7212899883439330664L;

    private final Date data;
    private final int km;
    private final EFormaPagamento pagamento;
    private final double valorPagamento;

    public Devolucao(int km, EFormaPagamento pagamento, double valorPagamento) {
        this.data = new Date();
        this.km = km;
        this.pagamento = pagamento;
        this.valorPagamento = valorPagamento;
    }

    public Date getData() {
        return data;
    }

    public int getKm() {
        return km;
    }

    public EFormaPagamento getPagamento() {
        return pagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

}
