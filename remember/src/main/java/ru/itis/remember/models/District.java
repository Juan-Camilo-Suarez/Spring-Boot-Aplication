package ru.itis.remember.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="district")
@Getter
@Setter
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToOne(mappedBy = "district", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private City city;

}
