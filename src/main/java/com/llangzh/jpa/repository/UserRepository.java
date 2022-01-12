package com.llangzh.jpa.repository;

import com.llangzh.jpa.pojo.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author llangzh
 */
@Repository
public interface UserRepository extends CrudRepository<UserDO,Integer> {

    /**
     * 通过用户名查新
     * @param username username
     * @return
     */
    UserDO findByUserName(String username);
}

