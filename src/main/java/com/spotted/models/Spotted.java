package com.spotted.models;

import javax.persistence.Entity;

@Entity
@Table(name = "spotted")
public class Spotted {

    
    private Long id;
    private String location;
    private String course;
    private String text;
    private byte[] image;

}
