package cu.cubaconf.model;

import java.io.Serializable;

/**
 * Created by akiel on 11/2/17.
 */

public class Day implements Serializable {
    private Event[] room1;
    private Event[] room2;
    private Event[] room3;
    private Event[] room4;
    private Event[] room5;

    public Day(Event[] room1, Event[] room2, Event[] room3, Event[] room4, Event[] room5) {
        this.room1 = room1;
        this.room2 = room2;
        this.room3 = room3;
        this.room4 = room4;
        this.room5 = room5;
    }

    public Event[] getRoom1() {
        return room1;
    }

    public void setRoom1(Event[] room1) {
        this.room1 = room1;
    }

    public Event[] getRoom2() {
        return room2;
    }

    public void setRoom2(Event[] room2) {
        this.room2 = room2;
    }

    public Event[] getRoom3() {
        return room3;
    }

    public void setRoom3(Event[] room3) {
        this.room3 = room3;
    }

    public Event[] getRoom4() {
        return room4;
    }

    public void setRoom4(Event[] room4) {
        this.room4 = room4;
    }

    public Event[] getRoom5() {
        return room5;
    }

    public void setRoom5(Event[] room5) {
        this.room5 = room5;
    }
}
