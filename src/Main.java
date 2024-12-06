import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightAndSegmentsBeforeTheCurrentTime;
import com.gridnine.testing.FlightBeforeTheCurrentTime;
import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.TotalTimeExceedsTwoHour;
import java.util.List;

/**
 * Класс Main - реализует точку входа в программу.
 *
 * @author Anton Shatkovskiy
 * @created 05.12.2024 г.
 */
public class Main {

  public static void main(String[] args) {

    // тута создаем список перелетов - т. е. объект класса FlightBuilder, чтобы не перемещаь все в com.gridnine.testing.Main
    List<Flight> flights = FlightBuilder.createFlights();

    System.out.println("Все перелеты:");
    printFlights(flights);

    System.out.println("\nПерелеты отфильтрованы по дате вылета до настоящего времени:");
    printFlights(new FlightBeforeTheCurrentTime().filter(flights));

    System.out.println("\nПерелеты отфильтрованы по правилу прибытия до вылета:");
    printFlights(new FlightAndSegmentsBeforeTheCurrentTime().filter(flights));

    System.out.println("\nПерелеты отфильтрованы по общему времени вылета за два часа.:");
    printFlights(new TotalTimeExceedsTwoHour().filter(flights));
  }

  private static void printFlights(List<Flight> flights) {
    for (Flight flight : flights) {
      System.out.println(flight);
    }
  }
}