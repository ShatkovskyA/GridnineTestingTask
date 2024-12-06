package com.gridnine.testing;

import java.util.List;

/**
 * Класс Flight - компонент, представляющий перелет
 *
 * @author Anton Shatkovskiy
 * @created 05.12.2024 г.
 */
public class Flight {
  // приватное поле класса типа Segment - список сегментов составляющих перелет
  private final List<Segment> segments;

  // контсруктор класс
  Flight(final List<Segment> segs) {
    segments = segs;
  }

  // геттер для получения списка сегментов
  List<Segment> getSegments() {
    return segments;
  }

  // переопределнный метод для стркового представления
  @Override
  public String toString() {
    return "Flight{" +
        "segments=" + segments +
        '}';
  }

}
