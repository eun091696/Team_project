package com.teamproject.mvc20221004teamproject.repository;

import com.teamproject.mvc20221004teamproject.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {

    public User findUserByUserName(String userName) throws Exception;
    public int saveUser(User user) throws Exception;

}
