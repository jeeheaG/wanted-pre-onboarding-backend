package com.ginger.myjobserver2024.global.common;

import com.ginger.myjobserver2024.global.config.ZonedTimeUtil;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.ZonedDateTime;

/**
 * 엔티티 클래스들의 생성시각, 수정시각 필드를 설정해주며
 * 이 클래스를 생속받은 엔티티들의 생성시각, 수정시각을 자동으로 업데이트 해주는 추상클래스
 */
@MappedSuperclass //이 클래스를 상속받은 엔티티가 이 클래스의 필드들도 자신의 것으로 인식하도록 함
public abstract class BaseTimeEntity {
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        ZonedDateTime now = ZonedTimeUtil.getZonedDateTime();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = ZonedTimeUtil.getZonedDateTime();
    }
}
