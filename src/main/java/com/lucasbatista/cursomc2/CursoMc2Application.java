package com.lucasbatista.cursomc2;

import com.lucasbatista.cursomc2.domain.*;
import com.lucasbatista.cursomc2.domain.enums.TypeClient;
import com.lucasbatista.cursomc2.repository.*;
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
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdressRepository adressRepository;


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

        Client cli1 = new Client(null, "Edilson", "edilsinho666@ibest.com.br", "12301928391", TypeClient.PESSOAFISICA);
        cli1.getTelephoneNumber().addAll(Arrays.asList("92132321","312983002"));

        Adress adr1 = new Adress(null, "Rua Sim", "400", "ap 105", "Centro", "900000-000", cli1, c1);
        Adress adr2 = new Adress(null, "Rua Nao", "200", "555", "Longe", "900300-000", cli1, c2);

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
        clientRepository.saveAll(Arrays.asList(cli1));
        adressRepository.saveAll(Arrays.asList(adr1, adr2));

    }
}
