package com.example.minitest1.service.product;

import com.example.minitest1.model.Product;
import com.example.minitest1.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean insert(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }
}
