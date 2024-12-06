package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс TotalTimeExceedsTwoHour - П. 3 "общее время, проведённое на земле превышает два часа (время на земле
 * — это интервал между прилётом одного сегмента и вылетом следующего за ним)", согласно ТЗ..
 *
 * @author Anton Shatkovskiy
 * @created 06.12.2024 г.
 */
public class TotalTimeExceedsTwoHour extends FlightFilterImpl {

  /**
   * Тут переопределенный метод АК с реализацией.
   */
  @Override
  protected boolean isValid(Flight flight) {
    // тут традиционно получаем список сегментов
    List<Segment> segments = flight.getSegments();
    // локальная перменная общего времени на земле, в итоге должны ее получить
    long totalTime = 0;
    // пробегаемся оопять циклом, полным по всем сегментам, за исключением последнего
    for (int i = 0; i < segments.size() - 1; i++) {
      // тут переменная, хар-ая дату прилета текущего сегмента
      LocalDateTime arrival = segments.get(i).getArrivalDate();
      // тут переменная, хар-ая дату вылета следующего сегмента
      LocalDateTime departure = segments.get(i + 1).getDepartureDate();
      // ну и собственно обещее время вычисляем
      totalTime += Duration.between(arrival, departure).toMinutes();
    }
    // возвращаем с условием пребывания на земле 2 часа, т. к. 120 минут - это есть 2 часа
    return totalTime <= 120;
  }

}
