package Tests.models;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestList test_list;

    public Test() {}

    public int getRow_id() { return row_id; }

    public Question getQuestion() { return question; }

    public TestList getTest_list() { return test_list; }

    public void setQuestion(Question question) { this.question = question; }

    public void setTest_list(TestList test_list) { this.test_list = test_list; }

    @Override
    public String toString() {
        return "Test{" +
                "row_id=" + row_id +
                ", question=" + question.getRow_id() +
                ", test_list=" + test_list.getRow_id() +
                '}';
    }
}
