package Tests.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_lists")
public class TestList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToMany(mappedBy = "test_list", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "test_list", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test> tests;

    @OneToMany(mappedBy = "test_list", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAnswer> student_answers;

    public TestList() {}

    public TestList(String name) {
        this.name = name;
        schedules = new ArrayList<>();
        tests = new ArrayList<>();
        student_answers = new ArrayList<>();
    }

    public int getRow_id() { return row_id; }

    public String getName() { return name; }

    public Subject getSubject() { return subject; }

    public User getUser() { return teacher; }

    public List<Schedule> getSchedules() { return schedules; }

    public List<Test> getTests() { return tests; }

    public List<StudentAnswer> getStudent_answers() { return student_answers; }

    public void setName(String name) { this.name = name; }

    public void setSubject(Subject subject) { this.subject = subject; }

    public void setUser(User teacher) { this.teacher = teacher; }

    public void setSchedules(List<Schedule> schedules) { this.schedules = schedules; }

    public void setTests(List<Test> tests) { this.tests = tests; }

    public void setStudent_answers(List<StudentAnswer> student_answers) { this.student_answers = student_answers; }

    public void addSchedule(Schedule schedule) {
        schedule.setTest_list(this);
        schedules.add(schedule);
    }

    public void addTest(Test test) {
        test.setTest_list(this);
        tests.add(test);
    }

    public void addStudent_Answer(StudentAnswer student_answer) {
        student_answer.setTest_list(this);
        student_answers.add(student_answer);
    }

    public void removeSchedule(Schedule schedule) { schedules.remove(schedule); }

    public void removeTest(Test test) { tests.remove(test); }

    public void removeStudent_Answer(StudentAnswer student_answer) { student_answers.remove(student_answer); }

    @Override
    public String toString() {
        return "Test_List{" +
                "row_id=" + row_id +
                ", name='" + name + '\'' +
                ", subject=" + subject.getRow_id() +
                ", teacher=" + teacher.getRow_id() +
                ", schedules=" + schedules +
                ", tests=" + tests +
                ", student_answers=" + student_answers +
                '}';
    }
}
