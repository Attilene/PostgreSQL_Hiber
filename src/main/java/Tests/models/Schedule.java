package Tests.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private Integer duration;
    private Date start_dt;
    private Time start_time;
    private Date end_dt;
    private Time end_time;
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestList test_list;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Schedule() {}

    public Schedule(
            Integer duration,
            Date start_dt,
            Time start_time,
            Date end_dt,
            Time end_time,
            Boolean active
    ) {
        this.duration = duration;
        this.start_dt = start_dt;
        this.start_time = start_time;
        this.end_dt = end_dt;
        this.end_time = end_time;
        this.active = active;
    }

    public int getRow_id() { return row_id; }

    public Group getGroup() { return group; }

    public Date getEnd_dt() { return end_dt; }

    public Date getStart_dt() { return start_dt; }

    public Integer getDuration() { return duration; }

    public TestList getTest_list() { return test_list; }

    public Time getEnd_time() { return end_time; }

    public Time getStart_time() { return start_time; }

    public void setGroup(Group group) { this.group = group; }

    public void setTest_list(TestList test_list) { this.test_list = test_list; }

    public void setActive(Boolean active) { this.active = active; }

    public void setDuration(Integer duration) { this.duration = duration; }

    public void setEnd_dt(Date end_dt) { this.end_dt = end_dt; }

    public void setEnd_time(Time end_time) { this.end_time = end_time; }

    public void setStart_dt(Date start_dt) { this.start_dt = start_dt; }

    public void setStart_time(Time start_time) { this.start_time = start_time; }

    @Override
    public String toString() {
        return "Schedule{" +
                "row_id=" + row_id +
                ", duration=" + duration +
                ", start_dt=" + start_dt +
                ", start_time=" + start_time +
                ", end_dt=" + end_dt +
                ", end_time=" + end_time +
                ", active=" + active +
                ", test_list=" + test_list.getRow_id() +
                ", group=" + group.getRow_id() +
                '}';
    }
}
