package com.dogether.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.dogether.domain.User;
import com.dogether.dto.OAuthAttributes;
import com.dogether.dto.SessionUser;
import com.dogether.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	private final UserMapper userMapper;
	private final HttpSession httpSession;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);

		// 현재 진행중인 서비스를 구분하기 위해 문자열로 받음.
		// oAuth2UserRequest.getClientRegistration().getRegistrationId()에 값이 들어있다.
		// {registrationId='naver'} 이런식으로
		String registrationId = userRequest.getClientRegistration().getRegistrationId();

		// OAuth2 로그인 시 키 값이 된다. 구글은 키 값이 "sub"이고, 네이버는 "response"이고, 카카오는 "id"이다. 각각
		// 다르므로 이렇게 따로 변수로 받아서 넣어줘야함.
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint()
				.getUserNameAttributeName();

		// OAuth2 로그인을 통해 가져온 OAuth2User의 attribute를 담아주는 of 메소드.
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,
				oAuth2User.getAttributes());

		User user = saveOrUpdate(attributes);

		/* 세션 정보를 저장하는 직렬화된 dto 클래스 */
		httpSession.setAttribute("user", new SessionUser(user));

		return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
				attributes.getAttributes(), attributes.getNameAttributeKey());
	}
	
	/* 소셜로그인시 기존 회원이 존재하면 수정정보만 업데이트, 리팩토링 */
	 private User saveOrUpdate(OAuthAttributes attributes) {
		// 이메일을 기반으로 기존 멤버를 조회
	        User user = userMapper.findByEmail(attributes.getEmail());

	        if (user == null) {
	            user = attributes.toEntity();
	            userMapper.insertUser(user);
	        } else {
	            user.update(attributes.getName(), attributes.getEmail());
	            userMapper.updateUser(user);
	        }

	        return user;
	    }
}
