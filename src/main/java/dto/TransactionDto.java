package dto;

import jakarta.validation.constraints.*;

import java.time.OffsetDateTime;

public class TransactionDto {

    @NotNull(message = "Campo valor não pode ser nulo")
    @DecimalMin(value = "0.01", message = "Valor mínimo é 0.01")
    @Digits(integer = 10, fraction = 2, message = "Deve ter no máximo 2 casas decimais")
    private Double valor;

    @NotNull(message = "Campo Data/Hora não pode ser nulo")
    @FutureOrPresent(message = "Data não pode ser no passado")
    private OffsetDateTime dataHora;

    public TransactionDto(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
