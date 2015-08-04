package com.endava.mvc.repository;

import com.endava.mvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cudrescu on 8/4/2015.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
