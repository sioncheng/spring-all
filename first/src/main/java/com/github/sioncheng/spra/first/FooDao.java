package com.github.sioncheng.spra.first;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long countData() {
        return jdbcTemplate.queryForObject("select count(*) from foo", Long.class);
    }
}
