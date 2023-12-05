package com.dogether.dto;

import java.util.Map;

import com.dogether.domain.Role;
import com.dogether.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;

	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email,
			String picture) {
		super();
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
	}

	// 네이버 카카오 구글마다 지원하는 API Attribute들이 다름. registrationId로 해당하는 API 메서드를 호출하는 방식으로
	// 하였음.
	// 일단 구글만
	// OAuth2User에서 반환하는 사용자 정보는 Map 형태이므로 값 하나하나를 변환
	public static OAuthAttributes of(String registrationId, String userNameAttributeName,
			Map<String, Object> attributes) {
		return ofGoogle(userNameAttributeName, attributes);
	}

	private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {

		return OAuthAttributes.builder()
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	// User Entity 생성
	// OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할 때임
	// 가입할 때 기본 권한 부여(Role.GUEST)
	public User toEntity() {
    	return User.builder()
                .user_email(email)
    			.user_name(name)
                .role(Role.USER) // 신규가입은 무조건 USER
                .build();
	}

}
