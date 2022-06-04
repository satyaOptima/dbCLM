package com.test.dbCLM.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CsvData {

    @CsvBindByName(column = "Order")
    private String order;

    @CsvBindByName(column = "Level")
    private int level;

    @CsvBindByName(column = "Code")
    private String code;

    @CsvBindByName(column = "Parent")
    private String parent;

    @CsvBindByName(column = "Description")
    private String description;

    @CsvBindByName(column = "This item includes")
    private String includes;

    @CsvBindByName(column = "This item also includes")
    private String alsoIncludes;

    @CsvBindByName(column = "Rulings")
    private String rulings;

    @CsvBindByName(column = "This item excludes")
    private String excludes;

    @CsvBindByName(column = "Reference to ISIC Rev. 4")
    private String reference;


}
