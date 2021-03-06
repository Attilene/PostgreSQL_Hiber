package Tests.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String text;
    private Boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAnswer> student_answers;

    public Answer() {}

    public Answer(String text, Boolean correct) {
        this.text = text;
        this.correct = correct;
        this.student_answers = new ArrayList<>();
    }

    public int getRow_id() { return row_id; }

    public String getText() { return text; }

    public Boolean getCorrect() { return correct; }

    public Question getQuestion() { return question; }

    public List<StudentAnswer> getStudent_answers() { return student_answers; }

    public void setText(String text) { this.text = text; }

    public void setCorrect(Boolean correct) { this.correct = correct; }

    public void setQuestion(Question question) { this.question = question; }

    public void setStudent_answers(List<StudentAnswer> student_answers) { this.student_answers = student_answers; }

    public void addStudent_Answer(StudentAnswer student_answer) {
        student_answer.setAnswer(this);
        student_answers.add(student_answer);
    }

    public void removeStudentAnswer(StudentAnswer student_answer) { student_answers.remove(student_answer); }

    @Override
    public String toString() {
        return "Answer{" +
                "row_id=" + row_id +
                ", text='" + text + '\'' +
                ", correct=" + correct +
                ", question=" + question.getRow_id() +
                ", student_answers=" + student_answers +
                '}';
    }
}
