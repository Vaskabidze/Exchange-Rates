package com.example.Synesis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "currency")
public class Currency {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String currency;
    private double rate;
    private LocalDate date;
    @JsonIgnore
    private LocalDateTime uploadTime;
}
