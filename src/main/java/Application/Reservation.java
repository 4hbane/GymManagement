package Application;

import java.time.LocalDate;

public class Reservation {
    LocalDate date;
    String activity;
    String coachName;


    Reservation() {
        date = null;
        activity = "";
        coachName = "";
    }

    public Reservation(LocalDate date, String activity, String coachName) {
        this.date = date;
        this.activity = activity;
        this.coachName = coachName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
