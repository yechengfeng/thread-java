package thread.daemon;

import java.util.Date;
import java.util.Objects;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-15 16:01
 **/
public class Event {
    private Date date;
    private String event;



    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", event='" + event + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        Event event1 = (Event) o;
        return Objects.equals(getDate(), event1.getDate()) &&
                Objects.equals(getEvent(), event1.getEvent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getEvent());
    }
}
