package entities;

import java.time.OffsetDateTime;

public class Transaction {
    private double valor;
    private OffsetDateTime dataHora;

    // Se já estou passando os parametros no construtor, não uso o setter
    public Transaction(final double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
