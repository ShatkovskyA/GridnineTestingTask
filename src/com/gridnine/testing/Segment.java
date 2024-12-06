package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Класс Segment - компонент, представляющий собой сегмент перелета
 *
 * @author Anton Shatkovskiy
 * @created 05.12.2024 г.
 */
public class Segment {
  // приватная переменная, поле класса - дата и время вылета
  private final LocalDateTime departureDate;
  // приватная переменная, поле класса - дата и время прилета
  private final LocalDateTime arrivalDate;

  // контсруктор класса
  Segment(final LocalDateTime dep, final LocalDateTime arr) {
    departureDate = Objects.requireNonNull(dep);
    arrivalDate = Objects.requireNonNull(arr);
  }

  // геттер - получаем дату и время вылета
  LocalDateTime getDepartureDate() {
    return departureDate;
  }

  // геттер - получаем дату и время прилета
  LocalDateTime getArrivalDate() {
    return arrivalDate;
  }

  // переопределнный метод для стркового представления
  @Override
  public String toString() {
    DateTimeFormatter fmt =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
        + ']';
  }

}
