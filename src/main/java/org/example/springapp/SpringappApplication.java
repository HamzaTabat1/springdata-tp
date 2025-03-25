package org.example.springapp;

import org.example.springapp.entities.Product;
import org.example.springapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringappApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringappApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart Phone",3200,32));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();//get retourner objet lui meme
        System.out.println("**********************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("********************");

    }

}
