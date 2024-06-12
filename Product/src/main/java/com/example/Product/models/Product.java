package com.example.Product.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name = "product", nullable = false)
    private String product;

    @NotNull
    @Column(name = "price", nullable = false)
    private Long price;

    private Category category;

    public Product() {
    }

    public Product(Long id, String product, Long price, Category category) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty @NotNull String getProduct() {
        return product;
    }

    public void setProduct(@NotEmpty @NotNull String product) {
        this.product = product;
    }

    public @NotNull Long getPrice() {
        return price;
    }

    public void setPrice(@NotNull Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
