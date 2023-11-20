package gui.dataShowcase;

public class Record {
    String name;
    int yearOfRelease, duration;
    double rating;

    public Record(String name, int yearOfRelease, int duration, double rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.duration = duration;
        this.rating = rating;
    }

    /**
     * @return data objektu tak, aby sla vlozit do JTable
     */
    public String[] returnAsTableRow(){
        return new String[]{name, String.valueOf(yearOfRelease), String.valueOf(rating), String.valueOf(duration)};
    }
}
