package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autoList;

    public int getId() { return id; }

    public String getName() { return name; }

    public int getAge() { return age; }

    public List<Auto> getAutoList() { return autoList; }

    public void setName(String name) { this.name = name; }

    public void setAge(int age) { this.age = age; }

    public void setAutoList(List<Auto> autoList) { this.autoList = autoList; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        autoList = new ArrayList<>();
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autoList.add(auto);
    }

    public void removeAuto(Auto auto) { autoList.remove(auto); }
}
