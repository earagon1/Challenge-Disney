package com.challenge.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterFiltersDTO {

    private String name;
    private Integer age;
    private Set<Long> movies;
    private String order;

    public boolean isASC(){return this.order.compareToIgnoreCase("ASC")==0;}
    public boolean isDESC(){return this.order.compareToIgnoreCase("DESC")==0;}
}
