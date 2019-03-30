package com.sailu.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sailu.models.User;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository< User, Integer> {

    User findByUsername(String username);

}