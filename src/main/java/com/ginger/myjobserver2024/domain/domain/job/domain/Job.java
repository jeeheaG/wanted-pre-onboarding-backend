package com.ginger.myjobserver2024.domain.domain.job.domain;

import com.ginger.myjobserver2024.domain.domain.company.domain.Company;
import com.ginger.myjobserver2024.domain.domain.job.dto.JobModel;
import com.ginger.myjobserver2024.domain.domain.job.dto.JobResponseDto;
import com.ginger.myjobserver2024.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * 채용공고 엔티티
 */
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

//    @Column(nullable = false, length = 30)
//    private String title;

    @Column(nullable = false, length = 30)
    private String country;

    @Column(nullable = false, length = 30)
    private String region;

    @Column(nullable = false, length = 30)
    private String position;

    private Integer reward;

    @Column(length = 30)
    private String tech;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    /**
     * 채용공고 정보를 수정할 때 사용하는 메서드
     * @param model
     */
    public void updateJobInfo(JobModel.UpdateJob model) {
        this.country = model.getCountry();
        this.region = model.getRegion();
        this.position = model.getPosition();
        this.tech = model.getTech();
        this.reward = model.getReward();
        this.content = model.getContent();
    }
}
