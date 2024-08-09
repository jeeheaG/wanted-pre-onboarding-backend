package com.ginger.myjobserver2024.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 관련 설정
 */
@EnableMethodSecurity(securedEnabled = true) // 컨트롤러 메서드에서 어노테이션으로 권한 체크 허용
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http
                .httpBasic(HttpBasicConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/**").permitAll() // 모두 인증없이 허용
                        .anyRequest().authenticated())
                ;
        
        http
                .formLogin(AbstractHttpConfigurer::disable) // security 기본 로그인 페이지 제거
                ;

        return http.build();
    }
}
