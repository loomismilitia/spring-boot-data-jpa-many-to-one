package com.example.springbootdatajpamanytoone.catalog;

import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Entity
@Table(name = "category")
class Category extends AbstractPersistable<Integer> {

    @Column(unique = true)
    private String name;

    private Category() {
        //thank you jpa :) \m/
    }

    Category(String name) {
        this.name = name;
    }
}
