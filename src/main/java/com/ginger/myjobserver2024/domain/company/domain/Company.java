package com.ginger.myjobserver2024.domain.company.domain;


import com.ginger.myjobserver2024.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * 회사 엔티티
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company extends BaseTimeEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;
}
