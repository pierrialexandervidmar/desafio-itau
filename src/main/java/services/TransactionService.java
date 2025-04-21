package services;

import entities.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Serviço responsável pelo gerenciamento das transações.
 * <p>
 * Esta classe é responsável por adicionar transações, limpar as transações armazenadas e calcular
 * estatísticas baseadas nas transações dos últimos 60 segundos.
 * </p>
 *
 * @author Pierri Alexander Vidmar
 * @since 04/2025
 */
@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    /**
     * Adiciona uma nova transação à fila de transações.
     * <p>
     * Este método adiciona a transação fornecida à fila de transações, que é uma instância de
     * {@link ConcurrentLinkedQueue}.
     * </p>
     *
     * @param transaction A transação a ser adicionada.
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Limpa todas as transações armazenadas.
     * <p>
     * Este método remove todas as transações da fila, deixando-a vazia.
     * </p>
     */
    public void clearTransactions() {
        transactions.clear();
    }

    /**
     * Obtém as estatísticas das transações realizadas nos últimos 60 segundos.
     * <p>
     * Este método calcula as estatísticas das transações, como soma, média, valor mínimo, máximo
     * e contagem das transações que ocorreram nos últimos 60 segundos. Ele usa streams para filtrar,
     * mapear e calcular as estatísticas baseadas no valor de cada transação.
     * </p>
     *
     * @return Um objeto {@link DoubleSummaryStatistics} contendo as estatísticas das transações.
     */
    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();

        return transactions.stream()                         // 1. Criar um stream dos dados da lista
                .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60))) // 2. Filtrar só as transações dos últimos 60 segundos
                .mapToDouble(Transaction::getValor)           // 3. Pegar só o valor (double) de cada transação
                .summaryStatistics();                         // 4. Calcular estatísticas tipo soma, média, min, max, count
    }
}
