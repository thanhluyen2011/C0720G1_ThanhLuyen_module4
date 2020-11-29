package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    @Column(columnDefinition = "LONGTEXT")
    String content;
    @Column(name = "write_day", columnDefinition = "DATE")
    String writeDay;
    String writer;


}
