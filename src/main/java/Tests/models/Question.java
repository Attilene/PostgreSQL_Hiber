package Tests.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String text;
    private int score;
    private boolean active;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    public Question() {}

    public Question(String text, int score, boolean active) {
        this.text = text;
        this.active = active;
        this.score = score;
        this.answers = new ArrayList<>();
    }

    public String getText() { return text; }

    public int getRow_id() { return row_id; }

    public int getScore() { return score; }

    public List<Answer> getAnswers() { return answers; }

    public void setText(String text) { this.text = text; }

    public void setScore(int score) { this.score = score; }

    public void setActive(boolean active) { this.active = active; }

    public void setAnswers(List<Answer> answers) { this.answers = answers; }

    public void addAnswer(Answer answer) {
        answer.setQuestion(this);
        answers.add(answer);
    }

    public void removeAuto(Answer answer) { answers.remove(answer); }

    @Override
    public String toString() {
        return "Question{" +
                "row_id=" + row_id +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", active=" + active +
                ", answers=" + answers +
                '}';
    }
}
