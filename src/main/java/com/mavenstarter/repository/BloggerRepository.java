package com.mavenstarter.repository;

import com.mavenstarter.entity.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BloggerRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public BloggerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

//    @Query("select b from Blogger b")
//    List<Blogger> findAll();

}