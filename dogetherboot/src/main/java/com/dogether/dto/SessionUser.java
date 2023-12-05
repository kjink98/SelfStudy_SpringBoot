package com.dogether.dto;

import java.io.Serializable;

import com.dogether.domain.User;

import lombok.Getter;

// User 클래스와 차이점 - 직렬화를 구현 
// 자바 내부 Object를 외부에서 사용 가능하도록 byte 형태로 변환하는 기술
@Getter
public class SessionUser implements Serializable {
	// serialVersionUID는 직렬화와 역직렬화 과정에서 객체의 버전을 관리하는데 사용되며, 
	// 이를 통해 직렬화된 객체와 클래스의 버전이 일치하는지 확인
	private static final long serialVersionUID = 1L;
	
	private String user_email;
	private String user_name;

	public SessionUser(User user){
        this.user_email = user.getUser_email();
        this.user_name = user.getUser_name();
    }
}
