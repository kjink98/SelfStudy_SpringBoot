package com.dogether.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dogether.domain.User;

@Mapper
public interface UserMapper {
    @Insert("insert into tbluser (user_id, user_grade, user_name, user_nickname,"
            + "user_pw, user_gender, user_email, user_regdate) "
            + "values(#{user_id}, #{user_grade}, #{user_name}, #{user_nickname},"
            + "#{user_pw}, #{user_gender}, #{user_email}, sysdate)")
    // 성공하면 1반환
    int insertUser(User user);
    
    // 해당 이메일 가진 사용자 찾아 반환, 없으면 NULL
    // 이미 생성된 사용자인지 확인
    @Select("SELECT * FROM tbluser WHERE user_email = #{user_email}")
    User findByEmail(String user_email);
    
    @Update("UPDATE tbluser SET user_name = #{user_name}, user_email = #{user_email} WHERE user_id = #{user_id}")
    int updateUser(User user);
    
    
}
