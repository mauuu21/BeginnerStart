package com.mavenstarter.repository;

import com.mavenstarter.entity.Blogger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BloggerRepository extends CrudRepository<Blogger, Long> {

    List<Blogger> findAll();
}
