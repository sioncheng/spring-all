package com.github.sioncheng.coffeeshop;


import com.github.sioncheng.coffeeshop.entities.Coffee;
import com.github.sioncheng.coffeeshop.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.github.sioncheng.coffeeshop.repository"})
@Slf4j
public class CoffeeShopApplication implements ApplicationRunner {


    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        listCoffee();
    }

    private void listCoffee() {
        Iterable<Coffee> coffees = coffeeRepository.findAll();
        if (coffees != null && coffees.iterator().hasNext()) {
            coffees.forEach(System.out::println);
        } else {
            log.warn("no coffee");
        }
    }
}
