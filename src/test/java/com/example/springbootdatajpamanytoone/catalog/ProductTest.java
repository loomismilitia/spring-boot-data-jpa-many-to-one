package com.example.springbootdatajpamanytoone.catalog;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Data JPA tests for entity {@link Product}.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaAuditing
public class ProductTest {

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void saveShouldPersistData() {
        Category savedCategory = this.entityManager.persistFlushFind(Fixtures.createCategory());
        Product savedProduct = this.entityManager.persistFlushFind(Fixtures.createProduct(savedCategory));
        assertThat(savedProduct.getSku()).isEqualTo("sku");
    }

    @Test
    public void saveWhenCategoryIsNullShouldThrowException() {
        this.thrown.expect(javax.persistence.PersistenceException.class);
        this.entityManager.persistFlushFind(Fixtures.createProduct(null));
    }

}