package ru.itis.remember.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "republic_id")
    private Republic republic;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "district_id")
    private District district;
}