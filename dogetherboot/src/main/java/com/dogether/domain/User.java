package com.dogether.domain;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
    private String user_id;
    private String user_pw;
    private String user_email;
    private String user_name;
    private String user_nickname;
    private String user_gender;
    private Timestamp user_regdate;
    private int user_grade;
    private Date user_birthday;
    private Role role;
    
    @Builder // 빌더 패턴을 클래스에 추가하여 객체 생성 간소화 용이
    // 사용자 정보 클래스
	public User(String user_id, String user_pw, String user_email, String user_name, String user_nickname,
			String user_gender, Timestamp user_regdate, int user_grade, Date user_birthday, Role role) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.user_gender = user_gender;
		this.user_regdate = user_regdate;
		this.user_grade = user_grade;
		this.user_birthday = user_birthday;
		this.role = role;
	}
    
    // role 필드의 key 값 반환
    public String getRoleKey() {
        return this.role.getKey();
    }
    
    // 소셜로그인 업데이트
    public void update(String name, String email) {
        this.user_name = name;
        this.user_email = email;
    }

}
