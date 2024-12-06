package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс FlightBeforeTheCurrentTime - П. 1 "вылет до текущего момента времени", согласно ТЗ.
 *
 * @author Anton Shatkovskiy
 * @created 06.12.2024 г.
 */
public class FlightBeforeTheCurrentTime extends FlightFilterImpl {

  /**
   * Тут переопределенный метод АК с реализацией.
   */
  @Override
  protected boolean isValid(Flight flight) {
    // тут получаем список сегментов
    List<Segment> segments = flight.getSegments();
    // далее пробегаемся циклом и перебираем все сегменты
    for (Segment segment : segments) {
      // и тут, если один сегмент по дате раньше текущего моменты времени - то фолс
      if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
        return false;
      }
    }
    // а так, если все ок - тогда возвращаем тру
    return true;
  }

}
