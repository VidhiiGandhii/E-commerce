package org.ncu.ecommerce_app.dao;

import org.ncu.ecommerce_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
    // You can add custom query methods here if needed
}
