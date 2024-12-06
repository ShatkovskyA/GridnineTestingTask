package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс FlightFilterImpl - абстракция, имплементирует интерфес и предоставляет базовую реализацию для дальнейшего использования.
 *
 * @author Anton Shatkovskiy
 * @created 05.12.2024 г.
 */
public abstract class FlightFilterImpl implements FlightFilter {
  /**
   * Тут переопределенный метод интерфейса с реализацией. Реализация со стримами.
   */
  @Override
  public List<Flight> filter(List<Flight> flights) {
    List<Flight> filteredFlights = new ArrayList<>();
    for (Flight flight : flights) {
      if (isValid(flight)) {
        filteredFlights.add(flight);
      }
    }
    return filteredFlights;
  }

  /**
   * Асбстарактный метод - валидирует перелет, т. е. допустим или нет
   */
  protected abstract boolean isValid(Flight flight);

}
