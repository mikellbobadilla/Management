package com.ar.mikellbobadilla.app.category;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CategoryRequest(
        @NotBlank
        @Length(min = 4, max = 50)
        String name,
        Integer parentId
) {
}
