package main.java.exercises.map.ordering;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CalendarEvents {
    private Map<LocalDate, Event> eventMap;

    public CalendarEvents() {
        this.eventMap = new HashMap<>();
    }

    public void addEvent(LocalDate date, String nameEvent, String attractionDescription) {
        eventMap.put(date, new Event(nameEvent, attractionDescription));
    }

    public void showCalendar() {
        Map<LocalDate, Event> eventTreeMap = new TreeMap<>(eventMap);
        for (Map.Entry<LocalDate, Event> entry : eventTreeMap.entrySet()) {
            LocalDate eventDate = entry.getKey();
            Event event = entry.getValue();
            System.out.println("Date: " + eventDate + ", Event: " + event.getName() + ", Attraction: " + event.getAttraction());
        }
    }

    public void getNextEvent() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Event nextEvent = null;
        for (Map.Entry<LocalDate, Event> entry : eventMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
                proximaData = dataEvento;
                nextEvent = entry.getValue();
                break;
            }
        }
        if (nextEvent != null) {
            System.out.println("The next event: " + nextEvent.getName() + " will take place on the date " + proximaData);
        } else {
            System.out.println("There are no upcoming events on the agenda.");
        }
    }

    public static void main(String[] args) {
        CalendarEvents calendarEvents = new CalendarEvents();


        // Add events to the calendar
        calendarEvents.addEvent(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        calendarEvents.addEvent(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        calendarEvents.addEvent(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        calendarEvents.addEvent(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        calendarEvents.addEvent(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

        // Displays the complete calendar of events
        calendarEvents.showCalendar();

        // Gets and displays the next event on the calendar
        calendarEvents.getNextEvent();
    }

}
