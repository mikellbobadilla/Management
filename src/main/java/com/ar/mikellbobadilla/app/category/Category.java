package com.ar.mikellbobadilla.app.category;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "categories")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
}
