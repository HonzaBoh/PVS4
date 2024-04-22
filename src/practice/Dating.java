package practice;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dating {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(LocalDateTime.now());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        LocalDateTime other =
                LocalDateTime.of(2000, 2, 9, 15, 35, 24);
        Duration dur = Duration.between(other, now);
        System.out.println("Uplynulo: ");
        System.out.println(dur.toDays() + " dni");
        System.out.println(now.getDayOfWeek()); // vrati konstantu
        System.out.println(now.getDayOfMonth()); // vrati poradove cislo v mesici
        System.out.println(now.getDayOfYear()); // vrati kolikaty den v roce to je
        String date = "2024-04-22 12:20";
        DateTimeFormatter format =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime time = LocalDateTime.parse(date, format);
        System.out.println("Vyparsovano:");
        System.out.println(time);
    }
}
