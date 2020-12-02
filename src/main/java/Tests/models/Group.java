package Tests.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String name;
    private Integer year;
    private Integer semester;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;

    public Group() {}

    public Group(String name, Integer year) {
        this.name = name;
        this.year = year;
        this.users = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    public Group(String name, Integer year, Integer semester) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.users = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    public int getRow_id() { return row_id; }

    public String getName() { return name; }

    public Integer getYear() { return year; }

    public Integer getSemester() { return semester; }

    public List<Schedule> getSchedules() { return schedules; }

    public List<User> getUsers() { return users; }

    public void setName(String name) { this.name = name; }

    public void setYear(Integer year) { this.year = year; }

    public void setSemester(Integer semester) { this.semester = semester; }

    public void setSchedules(List<Schedule> schedules) { this.schedules = schedules; }

    public void setUsers(List<User> users) { this.users = users; }

    public void addSchedule(Schedule schedule) {
        schedule.setGroup(this);
        schedules.add(schedule);
    }

    public void addUser(User user) {
        user.setGroup(this);
        users.add(user);
    }

    public void removeSchedule(Schedule schedule) { schedules.remove(schedule); }

    public void removeUser(User user) { users.remove(user); }

    @Override
    public String toString() {
        return "Group{" +
                "row_id=" + row_id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", users=" + users +
                ", schedules=" + schedules +
                '}';
    }
}
