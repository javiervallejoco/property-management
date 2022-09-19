package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTIES")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "OWNER_NAME")
    private String ownerName;
    @Column(name = "OWNER_EMAIL", nullable = false)
    private String ownerEmail;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "ADDRESS")
    private String address;
}
