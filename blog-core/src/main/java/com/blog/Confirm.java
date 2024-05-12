package com.blog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Confirm {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    public Confirm() {
    }

    @Builder
    public Confirm(Long id, String description) {
        this.id = id;
        this.description = description;
    }

}