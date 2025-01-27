package com.mavenstarter.service;

import com.mavenstarter.entity.Blogger;
import com.mavenstarter.entity.Story;
import com.mavenstarter.repository.BloggerRepository;
import com.mavenstarter.repository.StoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoryService {


    private StoryRepository storyRepository;
    private BloggerRepository bloggerRepository;

    @Autowired
    public void setBloggerRepository(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

    @Autowired
    public void setStoryRepository(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> getStories() {
        return storyRepository.findAll();
    }

    public Story getStory() {
        return storyRepository.findFirstByOrderByPostedDesc();
    }

    public Story getSpecificStory(String title) {
        return storyRepository.findByTitle(title);
    }

//    @PostConstruct
//    public void init() {
//        Blogger blogger = new Blogger("Sankó a Szerviceből", 77);
//        bloggerRepository.save(blogger);
//
//        Story story = new Story("Szervice Cím", "beszámolunk a service-ről", new Date(), blogger);
//        storyRepository.save(story);
//    }
}
