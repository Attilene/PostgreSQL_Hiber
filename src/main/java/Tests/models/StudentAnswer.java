package Tests.models;

import javax.persistence.*;

@Entity
@Table(name = "student_answers")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestList test_list;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public StudentAnswer() {}

    public int getRow_id() { return row_id; }

    public TestList getTest_list() { return test_list; }

    public Answer getAnswer() { return answer; }

    public User getUser() { return user; }

    public void setTest_list(TestList test_list) { this.test_list = test_list; }

    public void setAnswer(Answer answer) { this.answer = answer; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Student_Answer{" +
                "row_id=" + row_id +
                ", test_list=" + test_list.getRow_id() +
                ", answer=" + answer.getRow_id() +
                ", user=" + user.getRow_id() +
                '}';
    }
}
