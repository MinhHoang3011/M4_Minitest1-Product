package com.example.minitest1.repository.product;
import com.example.minitest1.model.Product;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String sql = "SELECT p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT p from Product p where p.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean insert(Product product) {
        String sql = "CALL Insert_Product(:name,:price,:img);";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name", product.getName());
        query.setParameter("price", product.getPrice());
        query.setParameter("img", product.getImg());
        return query.executeUpdate() == 0;
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if(product !=null){
            entityManager.remove(product);
        }
    }

    @Override
    public boolean update(Product product) {
        String sql = "CALL Update_Product(:name,:price,:img ,:id);";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name", product.getName());
        query.setParameter("price", product.getPrice());
        query.setParameter("img", product.getImg());
        query.setParameter("id", product.getId());
        return query.executeUpdate() == 0;
    }
}