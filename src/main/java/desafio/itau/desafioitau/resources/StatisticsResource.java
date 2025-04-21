package desafio.itau.desafioitau.resources;

import desafio.itau.desafioitau.dto.StatisticsDto;
import desafio.itau.desafioitau.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping(value = "/estatistica")
public class StatisticsResource {

    private final TransactionService transactionService;

    public StatisticsResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsDto> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsDto(stats));
    }
}
