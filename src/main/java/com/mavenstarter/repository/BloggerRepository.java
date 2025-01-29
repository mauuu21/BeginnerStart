package com.mavenstarter.repository;

import com.mavenstarter.entity.Blogger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {

    @Query("select b from Blogger b")
    List<Blogger> findAll();
}
