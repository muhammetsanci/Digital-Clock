
public class Clock {
    private int hour;    // Instance variable hour stores the value of hour.
    private int minute;  // Instance variable minute stores the value of minute.

    // Constructor Method
    public Clock(int hour, int minute) {
        this.setHour(hour);
        this.setMinute(minute);
    }

    // toString Method
    @Override
    public String toString() {
        String hourStr;
        String minuteStr;

        if (hour < 10) {
            hourStr = "0" + hour;
        }
        else hourStr = String.valueOf(hour);

        if (minute < 10) {
            minuteStr = "0" + minute;
        }
        else minuteStr = String.valueOf(minute);

        return hourStr + ":" + minuteStr;
    }

    public void forwardTime(int forwardTimeInput) {
        setMinute(this.minute + forwardTimeInput);
    }

    public void backwardTime(int backwardTimeInput) {
        setMinute(this.minute - backwardTimeInput);
    }

    // Getter & Setter Methods
    public int getHour() { return hour; }
    public void setHour(int hour) {
        this.hour = hour % 24;
    }

    public int getMinute() { return minute; }
    public void setMinute(int minute) {
        while (minute < 0) {
            setHour(this.hour - 1);
            minute += 60;
        }

        while (minute > 60) {
            setHour(this.hour + 1);
            minute -= 60;
        }
        this.minute = minute % 60;
    }
}

