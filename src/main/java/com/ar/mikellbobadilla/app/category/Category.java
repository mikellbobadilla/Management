package com.ar.mikellbobadilla.app.category;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "categories")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude = {"parent", "subcategories"})
@EqualsAndHashCode(exclude = {"parent", "subcategories"})
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> subcategories;
}
