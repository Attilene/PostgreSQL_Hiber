package Tests.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String text;
    private Integer score;
    private Boolean active;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test> tests;

    public Question() {}

    public Question(String text, Integer score, Boolean active) {
        this.text = text;
        this.active = active;
        this.score = score;
        this.answers = new ArrayList<>();
        this.tests = new ArrayList<>();
    }

    public String getText() { return text; }

    public int getRow_id() { return row_id; }

    public Integer getScore() { return score; }

    public Boolean getActive() { return active; }

    public List<Answer> getAnswers() { return answers; }

    public List<Test> getTests() { return tests; }

    public void setText(String text) { this.text = text; }

    public void setScore(Integer score) { this.score = score; }

    public void setActive(Boolean active) { this.active = active; }

    public void setAnswers(List<Answer> answers) { this.answers = answers; }

    public void setTests(List<Test> tests) { this.tests = tests; }

    public void addAnswer(Answer answer) {
        answer.setQuestion(this);
        answers.add(answer);
    }

    public void addTest(Test test) {
        test.setQuestion(this);
        tests.add(test);
    }

    public void removeAnswer(Answer answer) { answers.remove(answer); }

    public void removeTest(Test test) { tests.add(test); }

    @Override
    public String toString() {
        return "Question{" +
                "row_id=" + row_id +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", active=" + active +
                ", answers=" + answers +
                ", tests=" + tests +
                '}';
    }
}
