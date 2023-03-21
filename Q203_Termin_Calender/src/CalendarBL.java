import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class CalendarBL {
    public static String generateDaysOfMonth(String month) {
        int days = 0;
        String monthName = "";

        switch(month.toLowerCase()) {
            case "jan" -> {days = 31; monthName="January";}
            case "feb" -> {days = 28; monthName="February";}
            case "mar" -> {days = 31; monthName="March";}
            case "apr" -> {days = 30; monthName="April";}
            case "may" -> {days = 31; monthName="May";}
            case "jun" -> {days = 30; monthName="June";}
            case "jul" -> {days = 31; monthName="July";}
            case "aug" -> {days = 31; monthName="August";}
            case "sep" -> {days = 30; monthName="September";}
            case "oct" -> {days = 31; monthName="October";}
            case "nov" -> {days = 30; monthName="November";}
            case "dec" -> {days = 31; monthName="December";}
            default -> {days = -1;}
        }

        String output = "";
        LocalDate date = LocalDate.now();
        int year = date.getYear();

        for(int i = 0; i < days; i++) {
            output += String.format("%s%d. %s %d -<br>", ((i+1) <= 9 ? 0 : ""), i+1, monthName, year);
        }

        return output;
    }

    public static String generateEvents(String epContent) {
        Random rand = new Random();
        String days[] = epContent.split("<br>");
        String output = "";

        for(int i = 0; i < days.length - 1; i++) {
            String[] events = {"Test", "Meeting", "Party", ""};
            int eventsOpt = rand.nextInt(0, events.length);

            if(eventsOpt != events.length - 1) {
                int hour = rand.nextInt(6, 19);
                int[] min = {0, 15, 30, 45};
                int minOpt = rand.nextInt(0, min.length);

                LocalTime time = LocalTime.of(hour, min[minOpt]);

                output += String.format("%s <i>%s</i> <span style='color: red'>%s</span><br>", days[i], time, events[eventsOpt]);
            } else {
                output += String.format("%s<br>", days[i]);
            }
        }

        return output;
    }
}
