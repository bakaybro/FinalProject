package com.example.FinalProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @PostPersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
    }

    @PostUpdate
    public void preUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
