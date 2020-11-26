package Tests.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    public Role() {}

    public Role(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public int getRow_id() { return row_id; }

    public String getName() { return name; }

    public List<User> getUsers() { return users; }

    public void setName(String name) { this.name = name; }

    public void setUsers(List<User> users) { this.users = users; }

    public void addUser(User user) {
        user.setRole(this);
        users.add(user);
    }

    public void removeUser(User user) { users.remove(user); }

    @Override
    public String toString() {
        return "Role{" +
                "row_id=" + row_id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
