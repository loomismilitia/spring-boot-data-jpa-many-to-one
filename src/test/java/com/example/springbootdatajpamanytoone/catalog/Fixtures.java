package com.example.springbootdatajpamanytoone.catalog;

/**
 * Utilities for constructing test fixtures.
 */
final class Fixtures {

    static Product createProduct(Category category){
        return new Product("sku", category);
    }

    static Category createCategory(){
        return new Category("category");
    }

}
