package Tests.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String login;
    private String password_hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestList> test_lists;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAnswer> student_answers;

    public User() {}

    public User(
            String first_name,
            String last_name,
            String middle_name,
            String login,
            String password_hash
    ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.login = login;
        this.password_hash = password_hash;
        test_lists = new ArrayList<>();
        student_answers = new ArrayList<>();
    }

    public int getRow_id() { return row_id; }

    public String getFirst_name() { return first_name; }

    public String getLast_name() { return last_name; }

    public String getMiddle_name() { return middle_name; }

    public String getLogin() { return login; }

    public String getPassword_hash() { return password_hash; }

    public Group getGroup() { return group; }

    public Role getRole() { return role; }

    public List<TestList> getTest_lists() { return test_lists; }

    public List<StudentAnswer> getStudent_answers() { return student_answers; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public void setMiddle_name(String middle_name) { this.middle_name = middle_name; }

    public void setLogin(String login) { this.login = login; }

    public void setPassword_hash(String password_hash) { this.password_hash = password_hash; }

    public void setGroup(Group group) { this.group = group; }

    public void setRole(Role role) { this.role = role; }

    public void setTest_lists(List<TestList> test_lists) { this.test_lists = test_lists; }

    public void setStudent_answers(List<StudentAnswer> student_answers) { this.student_answers = student_answers; }

    public void addTest_list(TestList test_list) {
        test_list.setUser(this);
        test_lists.add(test_list);
    }

    public void addStudent_Answer(StudentAnswer student_answer) {
        student_answer.setUser(this);
        student_answers.add(student_answer);
    }

    public void removeTest_list(TestList test_list) { test_lists.remove(test_list); }

    public void removeStudent_Answer(StudentAnswer student_answer) { student_answers.remove(student_answer); }

    @Override
    public String toString() {
        return "User{" +
                "row_id=" + row_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", login='" + login + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", group=" + group.getRow_id() +
                ", role=" + role.getRow_id() +
                ", test_lists=" + test_lists +
                ", student_answers=" + student_answers +
                '}';
    }
}

