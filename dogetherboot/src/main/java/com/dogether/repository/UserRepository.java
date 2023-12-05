package com.dogether.repository;

import org.springframework.stereotype.Repository;

import com.dogether.domain.User;
import com.dogether.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;
    
    public boolean insertUser(User user) {
        int result = userMapper.insertUser(user);
        // 사용자 정보가 성공적으로 삽입되었는지 확인
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
