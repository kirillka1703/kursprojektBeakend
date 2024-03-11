package dev.vorstu.controllers;

import dev.vorstu.dto.StatisticDTO;
import dev.vorstu.entity.Statistic;
import dev.vorstu.services.EventService;
import dev.vorstu.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistic")
public class StatisticController {

    private final StatisticService statisticService;
    private final EventService eventService;

    @Autowired
    public StatisticController(StatisticService statisticService, EventService eventService) {
        this.statisticService = statisticService;
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<StatisticDTO> createStatistic(@RequestBody StatisticDTO statisticDTO) {
        Statistic statistic = statisticService.createStatistic(statisticDTO);
        StatisticDTO createdStatisticDTO = statisticService.convertToDTO(statistic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStatisticDTO);
    }
    @GetMapping
    public ResponseEntity<List<StatisticDTO>> getAllStatistics() {
        List<StatisticDTO> statistics = statisticService.getAllStatistics();

        for (StatisticDTO statistic : statistics) {
            statistic.setQuantity(String.valueOf(statistic.getQuantity()));
        }

        return ResponseEntity.ok(statistics);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistic(@PathVariable Long id) {
        statisticService.deleteStatistic(id);
        return ResponseEntity.noContent().build();
    }
}