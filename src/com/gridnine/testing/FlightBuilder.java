package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс FlightBuilder - фабрика, чтобы получить примерный список рейсов.
 *
 * @author Anton Shatkovskiy
 * @created 05.12.2024 г.
 */
public class FlightBuilder {
  public static List<Flight> createFlights() {
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    return Arrays.asList(
        //A normal flight with two hour duration
        // Обычный перелет продолжительностью в два часа
        createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
        //A normal multi segment flight
        // Обычный многосегментный перелет
        createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
        //A flight departing in the past
        // Рейс, вылетевший в прошлом
        createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
        //A flight that departs before it arrives
        // Рейс, который отправляется раньше, чем прибывает
        createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
        //A flight with more than two hours ground time
        // Рейс с наземным временем полета более двух часов
        createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
        //Another flight with more than two hours ground time
        // Еще один рейс с более чем двухчасовым наземным временем полета
        createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
            threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
  }

  /**
   * Вспомогательный статический метод для метода выше, создает перелет по заданным параметрам
   *
   * @param LocalDateTime... dates
   * @throws
   */
  public static Flight createFlight(final LocalDateTime... dates) {
    if ((dates.length % 2) != 0) {
      throw new IllegalArgumentException(
          "you must pass an even number of dates");
    }
    List<Segment> segments = new ArrayList<>(dates.length / 2);
    for (int i = 0; i < (dates.length - 1); i += 2) {
      segments.add(new Segment(dates[i], dates[i + 1]));
    }
    return new Flight(segments);
  }

}
