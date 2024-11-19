package com.ar.mikellbobadilla.app.init;

import com.ar.mikellbobadilla.app.category.Category;
import com.ar.mikellbobadilla.app.category.CategoryRepository;
import com.ar.mikellbobadilla.app.product.Product;
import com.ar.mikellbobadilla.app.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public void initCategories() {
        List<Category> categories = List.of(
                new Category(1, "Camisas"),
                new Category(6, "Camisas de tela"),
                new Category(3, "Medias"),
                new Category(7, "Medias de lana"),
                new Category(2, "Pantalones"),
                new Category(4, "Pantalones de gabardina"),
                new Category(5, "Pantalones jeans"));
        categoryRepository.saveAllAndFlush(categories);
    }

    public void initProducts() {
        List<Product> products = List.of(
                new Product(null, "Camisa Casual de Algodón", "Camisa de algodón para uso diario, disponible en colores sólidos.", 100, new BigDecimal("25.99"), new BigDecimal("15.00"), List.of(new Category(1, "Camisas"))),
                new Product(null, "Camisa de Manga Larga Rayada", "Camisa formal de manga larga con diseño de rayas elegantes.", 50, new BigDecimal("35.50"), new BigDecimal("20.00"), List.of(new Category(1, "Camisas"), new Category(6, "Camisas de tela"))),
                new Product(null, "Camisa de Lino para Verano", "Camisa ligera de lino, ideal para climas cálidos.", 75, new BigDecimal("40.00"), new BigDecimal("25.00"), List.of(new Category(1, "Camisas"), new Category(6, "Camisas de tela"))),
                new Product(null, "Medias Deportivas Antideslizantes", "Medias cómodas y antideslizantes, perfectas para actividades deportivas.", 200, new BigDecimal("8.99"), new BigDecimal("5.00"), List.of(new Category(3, "Medias"))),
                new Product(null, "Medias de Lana Térmicas", "Medias gruesas de lana, ideales para el invierno.", 150, new BigDecimal("12.50"), new BigDecimal("7.00"), List.of(new Category(3, "Medias"), new Category(7, "Medias de lana"))),
                new Product(null, "Medias de Algodón Suave", "Medias de algodón suaves para uso diario.", 180, new BigDecimal("6.99"), new BigDecimal("3.50"), List.of(new Category(3, "Medias"))),
                new Product(null, "Pantalón Casual de Gabardina", "Pantalón de gabardina ideal para eventos semi-formales.", 120, new BigDecimal("45.99"), new BigDecimal("30.00"), List.of(new Category(2, "Pantalones"), new Category(4, "Pantalones de gabardina"))),
                new Product(null, "Pantalón de Mezclilla Clásico", "Pantalón jeans clásico de corte recto.", 80, new BigDecimal("39.99"), new BigDecimal("25.00"), List.of(new Category(2, "Pantalones"), new Category(5, "Pantalones jeans"))),
                new Product(null, "Pantalón de Gabardina Slim Fit", "Pantalón de gabardina con diseño ajustado y moderno.", 60, new BigDecimal("49.99"), new BigDecimal("32.00"), List.of(new Category(2, "Pantalones"), new Category(4, "Pantalones de gabardina"))),
                new Product(null, "Camisa Formal Blanca", "Camisa formal blanca, imprescindible para cualquier armario.", 90, new BigDecimal("30.00"), new BigDecimal("18.00"), List.of(new Category(1, "Camisas"))),
                new Product(null, "Camisa de Tela con Estampado Floral", "Camisa casual con estampado floral, ideal para verano.", 70, new BigDecimal("27.99"), new BigDecimal("15.50"), List.of(new Category(1, "Camisas"), new Category(6, "Camisas de tela"))),
                new Product(null, "Camisa de Franela a Cuadros", "Camisa de franela para un look cálido y casual.", 50, new BigDecimal("35.00"), new BigDecimal("22.00"), List.of(new Category(1, "Camisas"), new Category(6, "Camisas de tela"))),
                new Product(null, "Medias Deportivas Altas", "Medias largas diseñadas para soporte y comodidad durante el ejercicio.", 250, new BigDecimal("10.99"), new BigDecimal("6.00"), List.of(new Category(3, "Medias"))),
                new Product(null, "Medias de Lana Gruesas", "Medias de lana para mantener los pies calientes en condiciones extremas.", 90, new BigDecimal("15.99"), new BigDecimal("9.00"), List.of(new Category(3, "Medias"), new Category(7, "Medias de lana"))),
                new Product(null, "Pantalón de Mezclilla Roto", "Jeans de mezclilla con diseño desgastado y rasgaduras modernas.", 100, new BigDecimal("42.99"), new BigDecimal("28.00"), List.of(new Category(2, "Pantalones"), new Category(5, "Pantalones jeans"))),
                new Product(null, "Pantalón de Gabardina Ancho", "Pantalón de gabardina con corte ancho para mayor comodidad.", 70, new BigDecimal("50.00"), new BigDecimal("30.00"), List.of(new Category(2, "Pantalones"), new Category(4, "Pantalones de gabardina"))),
                new Product(null, "Camisa Básica Negra", "Camisa básica de algodón negro, un clásico esencial.", 120, new BigDecimal("20.99"), new BigDecimal("12.00"), List.of(new Category(1, "Camisas"))),
                new Product(null, "Pantalón Gabardina para Oficina", "Pantalón de gabardina perfecto para un entorno profesional.", 65, new BigDecimal("54.99"), new BigDecimal("35.00"), List.of(new Category(2, "Pantalones"), new Category(4, "Pantalones de gabardina")))
        );
        productRepository.saveAllAndFlush(products);
    }


}
