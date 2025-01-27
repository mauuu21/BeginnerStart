package com.mavenstarter.repository;

import com.mavenstarter.entity.Story;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StoryRepository extends CrudRepository<Story, Long> {

    //SELECT * FROM STORY
    @Query("select s from Story s")
    List<Story> findAll();

    //SELECT * FROM STORY WHERE posted IN (SELECT max(posted) FROM story) LIMIT 1;
    Story findFirstByOrderByPostedDesc();


    Story findByTitle(String title);
}
