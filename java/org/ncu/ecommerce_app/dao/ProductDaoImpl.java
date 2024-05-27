package org.ncu.ecommerce_app.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.ncu.ecommerce_app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	@Override
    public List<Product> findAll() {
        String hql = "FROM Product as p ORDER BY p.id";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public void deleteById(Long id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

	public List<Product> findByBrandNameCustom(String brandName) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Product p WHERE p.brand.name = :brandName";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("brandName", brandName);
        return query.getResultList();
    }

    public List<Product> findByCategoryNameCustom(String categoryName) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Product p WHERE p.category.name = :categoryName";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("categoryName", categoryName);
        return query.getResultList();
    }

    public List<Product> findByBrand(Long brandId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Product p WHERE p.brand.id = :brandId";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("brandId", brandId);
        return query.getResultList();
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Product p WHERE p.category.id = :categoryId";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<Product> findByPriceBetween(BigDecimal min, BigDecimal max) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Product p WHERE p.price BETWEEN :min AND :max";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }
}
