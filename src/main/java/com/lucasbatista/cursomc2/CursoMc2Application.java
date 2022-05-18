package com.lucasbatista.cursomc2;

import com.lucasbatista.cursomc2.domain.Category;
import com.lucasbatista.cursomc2.domain.City;
import com.lucasbatista.cursomc2.domain.Product;
import com.lucasbatista.cursomc2.domain.State;
import com.lucasbatista.cursomc2.repository.CategoryRepository;
import com.lucasbatista.cursomc2.repository.CityRepository;
import com.lucasbatista.cursomc2.repository.ProductRepository;
import com.lucasbatista.cursomc2.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoMc2Application  implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;


    public static void main(String[] args) {
        SpringApplication.run(CursoMc2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Informatica");
        Category cat2 = new Category(null, "Escritorio");

        Product p1 = new Product(null, "Computador", 2000.00);
        Product p2 = new Product(null, "Impressora", 800.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        State sta1 = new State(null,"RS");
        State sta2 = new State(null,"SC");

        City c1 = new City(null, "Porto Alegre", sta1);
        City c2 = new City(null, "Florianópolis", sta2);
        City c3 = new City(null, "Itajai", sta2);

        p1.getCategories().addAll(Arrays.asList(cat1));
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().addAll(Arrays.asList(cat1));

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().addAll(Arrays.asList(p2));

        sta1.getCities().addAll(Arrays.asList(c1));
        sta2.getCities().addAll(Arrays.asList(c2, c3));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        stateRepository.saveAll(Arrays.asList(sta1, sta2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3));

    }
}
