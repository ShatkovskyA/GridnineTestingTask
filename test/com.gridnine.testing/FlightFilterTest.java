package com.gridnine.testing;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Класс FlightFilterTest - тестирует функционал приложения.
 *
 * @author Anton Shatkovskiy
 * @created 06.12.2024 г.
 */

public class FlightFilterTest {
  @Test
  public void testDepartureBeforeNowRule() {
    List<Flight> flights = FlightBuilder.createFlights();
    List<Flight> filteredFlights = new FlightBeforeTheCurrentTime().filter(flights);
    assertEquals(5, filteredFlights.size());
  }

  @Test
  public void testArrivalBeforeDepartureRule() {
    List<Flight> flights = FlightBuilder.createFlights();
    List<Flight> filteredFlights = new FlightAndSegmentsBeforeTheCurrentTime().filter(flights);
    assertEquals(5, filteredFlights.size());
  }

  @Test
  public void testTotalGroundTimeExceedsTwoHoursRule() {
    List<Flight> flights = FlightBuilder.createFlights();
    List<Flight> filteredFlights = new TotalTimeExceedsTwoHour().filter(flights);
    assertEquals(4, filteredFlights.size());
  }

}