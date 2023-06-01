package beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Training implements Comparable<Training> {
    private LocalDate date;
    private LocalTime time;
    private Route route;

    private static final DateTimeFormatter dtf_date = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter dtf_time = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Training(LocalDate date, LocalTime time, Route route) {
        this.date = date;
        this.time = time;
        this.route = route;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public static DateTimeFormatter getDtf_Date() {
        return dtf_date;
    }

    public static DateTimeFormatter getDtf_Time() {
        return dtf_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(date, training.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return String.format("%-20s %s km %10s - %s", route.getName(), route.getDistance(), date.format(DateTimeFormatter.ofPattern("MMM.yyyy")), time);
    }

    @Override
    public int compareTo(Training o) {
        return time.compareTo(o.getTime());
    }

    public Route getRoute() {
        return route;
    }
}
