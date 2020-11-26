package Tests.models;


import Users_Autos.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String text;
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student_Answer> student_answers;

    public Answer() {}

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
        this.student_answers = new ArrayList<>();
    }

    public int getRow_id() { return row_id; }

    public String getText() { return text; }

    public Question getQuestion() { return question; }

    public List<Student_Answer> getStudent_answers() { return student_answers; }

    public void setText(String text) { this.text = text; }

    public void setCorrect(boolean correct) { this.correct = correct; }

    public void setQuestion(Question question) { this.question = question; }

    public void setStudent_answers(List<Student_Answer> student_answers) { this.student_answers = student_answers; }

    public void addStudent_Answer(Student_Answer student_answer) {
        student_answer.setAnswer(this);
        student_answers.add(student_answer);
    }

    public void removeStudentAnswer(Student_Answer student_answer) { student_answers.remove(student_answer); }

    @Override
    public String toString() {
        return "Answer{" +
                "row_id=" + row_id +
                ", text='" + text + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                ", student_answers=" + student_answers +
                '}';
    }
}
