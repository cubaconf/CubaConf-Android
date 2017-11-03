package cu.cubaconf.model;

import java.io.Serializable;

/**
 * Created by akiel on 11/2/17.
 */

public class Schedule implements Serializable {
    private Day day1;
    private Day day2;
    private Day day3;

    public Schedule(Day day1, Day day2, Day day3) {
        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
    }

    public Day getDay1() {
        return day1;
    }

    public void setDay1(Day day1) {
        this.day1 = day1;
    }

    public Day getDay2() {
        return day2;
    }

    public void setDay2(Day day2) {
        this.day2 = day2;
    }

    public Day getDay3() {
        return day3;
    }

    public void setDay3(Day day3) {
        this.day3 = day3;
    }
}
