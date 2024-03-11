package dev.vorstu.services;

import dev.vorstu.dto.StatisticDTO;
import dev.vorstu.entity.Statistic;
import dev.vorstu.repositories.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class StatisticService {
    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public void deleteStatistic(Long id) {
        statisticRepository.deleteById(id);
    }

    public StatisticDTO convertToDTO(Statistic statistic) {
        StatisticDTO statisticDTO = new StatisticDTO();
        statisticDTO.setId(statistic.getId());
        statisticDTO.setQuantity(String.valueOf(statistic.getQuantity()));
        statisticDTO.setPeopleName(statistic.getPeopleName());
        statisticDTO.setMainevent(statistic.getMainevent());
        statisticDTO.setAllevent(statistic.getAllevent());

        return statisticDTO;
    }
    public Statistic createStatistic(StatisticDTO statisticDTO) {
        Statistic statistic = convertToEntity(statisticDTO);
        return statisticRepository.save(statistic);
    }
    public List<StatisticDTO> getAllStatistics() {
        List<Object[]> statistics = statisticRepository.getAllStatistics();
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        for (Object[] statistic : statistics) {
            StatisticDTO statisticDTO = convertToDTO((Statistic) statistic[0]);
            Long eventCount = (Long) statistic[1];
            statisticDTO.setQuantity(String.valueOf(eventCount.longValue()));
            statisticDTOs.add(statisticDTO);
        }

        return statisticDTOs;
    }
    private Statistic convertToEntity(StatisticDTO statisticDTO) {
        Statistic statistic = new Statistic();
        statistic.setId(statisticDTO.getId());
        statistic.setQuantity(statisticDTO.getQuantity());
        statistic.setPeopleName(statisticDTO.getPeopleName());
        statistic.setMainevent(statisticDTO.getMainevent());
        statistic.setAllevent(statisticDTO.getAllevent());

        return statistic;
    }
}