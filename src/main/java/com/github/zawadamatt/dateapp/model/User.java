package com.github.zawadamatt.dateapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String description;

    @Column
    private String images;

    @Column
    private String eyes;

    @Column
    private String heigth;

    @Column
    private List<String> hobbys;

    @Column
    private String orientation;

    @Column
    private String hairColor;

    @Column
    private String skinColor;

    @Column
    private String typeOfBody;

    @Column
    private boolean tattos;

    @Column
    private int kids;

    @Column
    private String characterType;

    @Column
    private String animals;

    @Column
    private String carrer;

    @Column
    @OneToOne
    private List<User> likedUsers;
}
