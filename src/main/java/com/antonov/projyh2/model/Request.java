package com.antonov.projyh2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String word;

}
