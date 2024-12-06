package com.gridnine.testing;

import java.util.List;

/**
 * Класс FlightAndSegmentsBeforeTheCurrentTime - П. 2 "имеются сегменты с датой прилёта раньше даты вылета", согласно ТЗ..
 *
 * @author Anton Shatkovskiy
 * @created 06.12.2024 г.
 */
public class FlightAndSegmentsBeforeTheCurrentTime extends FlightFilterImpl {

  /**
   * Тут переопределенный метод АК с реализацией.
   */
  @Override
  protected boolean isValid(Flight flight) {
    // тут традиционно получаем список сегментов
    List<Segment> segments = flight.getSegments();
    // далее пробегаемся циклом и перебираем все сегменты
    for (Segment segment : segments) {
      // и тут, дата и время сегмента прилёта раньше даты и времени вылета - то фолс
      if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
        return false;
      }
    }
    // ну а в потивном случае - тру
    return true;
  }

}
