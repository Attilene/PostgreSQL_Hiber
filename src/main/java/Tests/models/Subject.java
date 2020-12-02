package Tests.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestList> test_lists;

    public Subject() {}

    public Subject(String name) {
        this.name = name;
        this.test_lists = new ArrayList<>();
    }

    public int getRow_id() { return row_id; }

    public String getName() { return name; }

    public List<TestList> getTest_lists() { return test_lists; }

    public void setName(String name) { this.name = name; }

    public void setTest_lists(List<TestList> test_lists) { this.test_lists = test_lists; }

    public void addTest_list(TestList test_list) {
        test_list.setSubject(this);
        test_lists.add(test_list);
    }

    public void removeTest_list(TestList test_list) { test_lists.remove(test_list); }

    @Override
    public String toString() {
        return "Subject{" +
                "row_id=" + row_id +
                ", name='" + name + '\'' +
                ", test_lists=" + test_lists +
                '}';
    }
}
