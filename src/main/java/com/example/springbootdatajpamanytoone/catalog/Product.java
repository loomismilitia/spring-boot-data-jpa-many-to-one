package com.example.springbootdatajpamanytoone.catalog;

import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "product")
class Product extends AbstractPersistable<Integer> {

    @Column(unique = true)
    private String sku;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoryId")
    private Category category;

    private Product() {
        //thank you jpa :) \m/
    }

    Product(String sku, Category category) {
        this.sku = sku;
        this.category = category;
    }

}
