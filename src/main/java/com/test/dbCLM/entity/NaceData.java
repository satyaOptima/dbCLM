package com.test.dbCLM.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "nace")
@Data
@ToString
public class NaceData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Col_Order")
    private String order;

    @Column(name =  "Level")
    private int level;

    @Column(name = "Code")
    private String code;

    @Column(name =  "Parent", columnDefinition = "TEXT")
    private String parent;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name =  "Col_Includes", columnDefinition = "TEXT")
    private String includes;

    @Column(name = "Col_AlsoIncludes", columnDefinition = "TEXT")
    private String alsoIncludes;

    @Column(name = "Rulings", columnDefinition = "TEXT")
    private String rulings;

    @Column(name = "Col_Excludes", columnDefinition = "TEXT")
    private String excludes;

    @Column(name ="Reference", columnDefinition = "TEXT")
    private String reference;
}
