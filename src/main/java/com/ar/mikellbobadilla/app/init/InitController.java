package com.ar.mikellbobadilla.app.init;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/init")
@RequiredArgsConstructor
public class InitController {

    private final InitService service;

    @GetMapping("/categories")
    @ResponseStatus(NO_CONTENT)
    void insertCategories() {
        service.initCategories();
    }

    @GetMapping("/products")
    @ResponseStatus(NO_CONTENT)
    void insertProducts() {
        service.initProducts();
    }
}
