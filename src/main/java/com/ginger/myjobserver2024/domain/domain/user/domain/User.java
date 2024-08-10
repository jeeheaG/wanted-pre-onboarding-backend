package com.ginger.myjobserver2024.domain.domain.user.domain;

import com.ginger.myjobserver2024.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * 사용자 엔티티
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long Id;

    @Column(nullable = false, length = 30)
    private String name;
}
