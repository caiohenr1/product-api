package com.example.Product.services;


import com.example.Product.models.Product;
import com.example.Product.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id) {
       Optional<Product> product = this.productRepository.findById(id);
       return product.orElseThrow(() -> new RuntimeException(String.format("""
               Produto não encontrado!
               """)));
    }

    @Transactional
    public Product create(Product obj) {
        obj.setId(null);
        obj = this.productRepository.save(obj);
        return obj;
    }

    @Transactional
    public Product update (Product obj, Long id) {
        Product newObj = findById(id);
        newObj.setProduct(obj.getProduct());
        newObj.setCategory(obj.getCategory());
        newObj.setPrice(obj.getPrice());
        return this.productRepository.save(newObj);
    }

    public void delete( Long id) {
        findById(id);
        try {
            this.productRepository.deleteById(id);
        }catch (Exception e) {
            throw new RuntimeException(String.format("""
                    Produto não encontrado! Ou existem outras entidades relacionadas
                    """));
        }
    }
}
