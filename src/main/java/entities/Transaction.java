package entities;

import java.time.OffsetDateTime;

/**
 * Entidade que representa uma transação financeira.
 * <p>
 * Esta classe encapsula as informações de uma transação, incluindo o valor e a data/hora em que a transação ocorreu.
 * A transação é representada por um valor numérico e um carimbo de data/hora.
 * </p>
 *
 * @author Pierri Alexander Vidmar
 * @since 04/2025
 */
public class Transaction {
    private double valor;
    private OffsetDateTime dataHora;

    /**
     * Constrói um objeto {@link Transaction} com o valor e a data/hora fornecidos.
     * <p>
     * Este construtor inicializa a transação com o valor e a data/hora passados como parâmetros.
     * </p>
     *
     * @param valor    O valor da transação (valor monetário da transação).
     * @param dataHora A data e hora em que a transação foi realizada.
     */
    public Transaction(final double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    /**
     * Retorna o valor da transação.
     *
     * @return O valor da transação.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Retorna a data e hora da transação.
     *
     * @return A data e hora em que a transação ocorreu.
     */
    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
