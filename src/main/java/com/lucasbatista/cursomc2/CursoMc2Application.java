package com.lucasbatista.cursomc2;

import com.lucasbatista.cursomc2.domain.*;
import com.lucasbatista.cursomc2.domain.enums.PaymentState;
import com.lucasbatista.cursomc2.domain.enums.TypeClient;
import com.lucasbatista.cursomc2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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
    private AddressRepository addressRepository;
    @Autowired
    private OrderedRepository orderedRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ProductOrderedRepository productOrderedRepository;


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

        p1.getCategories().addAll(Arrays.asList(cat1));
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().addAll(Arrays.asList(cat1));

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().addAll(Arrays.asList(p2));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        State sta1 = new State(null,"RS");
        State sta2 = new State(null,"SC");

        City c1 = new City(null, "Porto Alegre", sta1);
        City c2 = new City(null, "Florianópolis", sta2);
        City c3 = new City(null, "Itajai", sta2);

        sta1.getCities().addAll(Arrays.asList(c1));
        sta2.getCities().addAll(Arrays.asList(c2, c3));

        stateRepository.saveAll(Arrays.asList(sta1, sta2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3));

        Client cli1 = new Client(null, "Edilson", "edilsinho666@ibest.com.br", "12301928391", TypeClient.PESSOAFISICA);
        cli1.getTelephoneNumber().addAll(Arrays.asList("92132321","312983002"));


        Address adr1 = new Address(null, "Rua Sim", "400", "ap 105", "Centro", "900000-000", cli1, c1);
        Address adr2 = new Address(null, "Rua Nao", "200", "555", "Longe", "900300-000", cli1, c2);

        cli1.getAddresses().addAll(Arrays.asList(adr1, adr2));

        clientRepository.saveAll(Arrays.asList(cli1));
        addressRepository.saveAll(Arrays.asList(adr1, adr2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Ordered ordered1 = new Ordered(null, sdf.parse("01/10/2017 15:30"), cli1, adr1);
        Ordered ordered2 = new Ordered(null, sdf.parse("01/10/2017 15:45"), cli1, adr2);

        Payment pay1 = new PaymentCreditCard(null, PaymentState.PAYED, ordered1, 6);
        ordered1.setPayment(pay1);

        Payment pay2 = new PaymentMoney(null, PaymentState.PENDING, ordered2, sdf.parse("20/09/2017 00:00"), null);
        ordered2.setPayment(pay2);

        cli1.getOrdereds().addAll(Arrays.asList(ordered1, ordered2));

        orderedRepository.saveAll(Arrays.asList(ordered1, ordered2));
        paymentRepository.saveAll(Arrays.asList(pay1, pay2));

        ProductOrdered po1 = new ProductOrdered(ordered1, p1, 0.00, 1, 2000.00);
        ProductOrdered po2 = new ProductOrdered(ordered1, p3, 0.00, 2, 80.00);
        ProductOrdered po3 = new ProductOrdered(ordered1, p2, 100.00, 1, 800.00);

        ordered1.getProductOrdered().addAll(Arrays.asList(po1, po2));
        ordered2.getProductOrdered().addAll(Arrays.asList(po3));

        p1.getProductOrdered().addAll(Arrays.asList(po1));
        p2.getProductOrdered().addAll(Arrays.asList(po3));
        p3.getProductOrdered().addAll(Arrays.asList(po2));

        productOrderedRepository.saveAll(Arrays.asList(po1, po2, po3));
    }
}
