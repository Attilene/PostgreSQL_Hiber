package models;

import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {}

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }


}
