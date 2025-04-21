package desafio.itau.desafioitau.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.OffsetDateTime;

/**
 * DTO (Data Transfer Object) que representa os dados de uma transação.
 * <p>
 * Este DTO é utilizado para transferir os dados de uma transação, incluindo o valor e a data/hora.
 * Ele também realiza validações sobre os campos utilizando as anotações de validação do Jakarta Validation.
 * </p>
 *
 * @author Pierri Alexander Vidmar
 * @since 04/2025
 */
public class TransactionDto {

    @NotNull(message = "Campo valor não pode ser nulo")
    @DecimalMin(value = "0.01", message = "Valor mínimo é 0.01")
    @Digits(integer = 10, fraction = 2, message = "Deve ter no máximo 2 casas decimais")
    private Double valor;

    @NotNull(message = "Campo Data/Hora não pode ser nulo")
    @PastOrPresent(message = "Data não pode ser no futuro")
    private OffsetDateTime dataHora;

    /**
     * Constrói um objeto {@link TransactionDto} com o valor e a data/hora fornecidos.
     * <p>
     * O construtor inicializa os campos {@code valor} e {@code dataHora} com os valores fornecidos.
     * </p>
     *
     * @param valor    O valor da transação, que deve ser maior que 0.01 e com no máximo 2 casas decimais.
     * @param dataHora A data e hora da transação, que não pode ser no passado.
     */
    public TransactionDto(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    /**
     * Retorna o valor da transação.
     *
     * @return O valor da transação.
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Retorna a data e hora da transação.
     *
     * @return A data e hora da transação.
     */
    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
