package com.example.demothymeleaft.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CategoryDto{

    private Long id;

    @NotEmpty
    @Length(min = 5)
    private String name;

    private Boolean isEdit = false;

}
