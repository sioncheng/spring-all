package com.github.sioncheng.spra.first;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class Main implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private FooDao fooDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }


    @Override
    public void run(String... args) throws Exception {
        showConnection();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        connection.close();

        fooDao.countData();
    }
}
