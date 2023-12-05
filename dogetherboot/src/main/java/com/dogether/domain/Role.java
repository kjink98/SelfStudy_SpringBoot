package com.dogether.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
// 각 사용자의 권한을 관리할 Enum 클래스
// 스프링 시큐리티에서는 권한 코드에 항상 “ROLE_”이 있어야 함
public enum Role {
	// 권한에 따라 키 값을 ROLE_GUEST, ROLE_USER로 지정
    USER("ROLE_USER","USER"),
    SELLER("ROLE_ADMIN", "SELLER"),
    ADMIN("ROLE_ADMIN", "ADMIN");

    private final String key;
    private final String title;
}
