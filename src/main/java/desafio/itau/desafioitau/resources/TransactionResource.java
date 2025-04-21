package desafio.itau.desafioitau.resources;

import desafio.itau.desafioitau.dto.TransactionDto;
import desafio.itau.desafioitau.entities.Transaction;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import desafio.itau.desafioitau.services.TransactionService;

import java.time.OffsetDateTime;

/**
 * Controller responsável pela gestão das transações.
 * <p>
 * Este controller fornece endpoints para a criação e exclusão de transações.
 * Ele valida as transações antes de adicioná-las e fornece uma maneira de limpar todas as transações.
 * </p>
 *
 * @author Pierri Alexander Vidmar
 * @since 04/2025
 */
@RestController
@RequestMapping
public class TransactionResource {

    private final TransactionService transactionService;

    /**
     * Construtor do controlador de transações.
     * <p>
     * O construtor recebe uma instância de {@link TransactionService} que é utilizada
     * para adicionar e limpar transações.
     * </p>
     *
     * @param transactionService Serviço utilizado para manipulação das transações.
     */
    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Cria uma nova transação.
     * <p>
     * Este método valida se a data da transação é no futuro, retornando um código de status
     * {@link HttpStatus#UNPROCESSABLE_ENTITY} caso a data seja inválida. Caso contrário,
     * a transação é criada com os dados fornecidos e um código de status {@link HttpStatus#CREATED}
     * é retornado.
     * </p>
     *
     * @param dto Objeto que contém os dados da transação a ser criada.
     * @return {@link ResponseEntity} com o status HTTP de sucesso ou erro.
     */
    @PostMapping(value = "/transacao")
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionDto dto) {
        if (dto.getDataHora().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionService.addTransaction(new Transaction(dto.getValor(), dto.getDataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Exclui todas as transações.
     * <p>
     * Este método limpa todas as transações armazenadas. Após a execução, ele retorna um status
     * de sucesso {@link HttpStatus#OK}.
     * </p>
     *
     * @return {@link ResponseEntity} com o status HTTP de sucesso.
     */
    @DeleteMapping(value = "/transacoes")
    public ResponseEntity<Void> deleteTransaction() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}

