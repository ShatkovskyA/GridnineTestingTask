package com.gridnine.testing;

import java.util.List;

/**
 * Класс FlightFilter - описывает фильтрацию перелетов.
 *
 * @author Anton Shatkovskiy
 * @created 05.12.2024 г.
 */
public interface FlightFilter {
  // один метод для фильтрации перелетов, где в качестве аргумента список перелетов
  List<Flight> filter(List<Flight> flights);

}