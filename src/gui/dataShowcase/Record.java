package gui.dataShowcase;

import java.util.Comparator;

public class Record {
    String name;
    int yearOfRelease, duration;
    double rating;

    static Comparator<Record> BY_NAME = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    static Comparator<Record> BY_YEAR = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            return Integer.compare(o1.yearOfRelease, o2.yearOfRelease);
        }
    };

    static Comparator<Record> BY_DURATION = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            return Integer.compare(o1.duration, o2.duration);
        }
    };

    static Comparator<Record> BY_RATING = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };

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
