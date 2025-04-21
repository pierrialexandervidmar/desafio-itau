package desafio.itau.desafioitau.dto;

import java.util.DoubleSummaryStatistics;

/**
 * Classe DTO (Data Transfer Object) para representar as estatísticas de transações.
 * <p>
 * Este DTO encapsula as estatísticas como contagem, soma, média, valor mínimo e máximo de
 * um conjunto de transações, extraídas de um objeto {@link DoubleSummaryStatistics}.
 * </p>
 *
 * @author Pierri Alexander Vidmar
 * @since 04/2025
 */
public class StatisticsDto {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    /**
     * Constrói um objeto {@link StatisticsDto} a partir das estatísticas fornecidas.
     * <p>
     * Este construtor recebe um objeto {@link DoubleSummaryStatistics} e inicializa os
     * campos do DTO com os valores das estatísticas, como contagem, soma, média, valor mínimo
     * e máximo.
     * </p>
     *
     * @param statistics O objeto {@link DoubleSummaryStatistics} contendo as estatísticas.
     */
    public StatisticsDto(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.min = statistics.getMin();
        this.max = statistics.getMax();
    }

    /**
     * Retorna a contagem de elementos nas estatísticas.
     *
     * @return A contagem de elementos (número de transações).
     */
    public long getCount() {
        return count;
    }

    /**
     * Retorna a soma dos valores das transações.
     *
     * @return A soma dos valores.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Retorna a média dos valores das transações.
     *
     * @return A média dos valores.
     */
    public double getAvg() {
        return avg;
    }

    /**
     * Retorna o valor mínimo das transações.
     *
     * @return O valor mínimo.
     */
    public double getMin() {
        return min;
    }

    /**
     * Retorna o valor máximo das transações.
     *
     * @return O valor máximo.
     */
    public double getMax() {
        return max;
    }
}
