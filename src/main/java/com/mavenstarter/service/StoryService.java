package com.mavenstarter.service;

import com.mavenstarter.entity.Story;
import com.mavenstarter.repository.BloggerRepository;
import com.mavenstarter.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StoryService {

    private StoryRepository storyRepository;
    private BloggerRepository bloggerRepository;

    @Autowired
    public void setStoryRepository(StoryRepository storyRepo) {
        this.storyRepository = storyRepository;
    }

    @Autowired
    public void setBloggerRepository(BloggerRepository bloggerRepo) {
        this.bloggerRepository = bloggerRepository;
    }

    public List<Story> getStories() {
        return storyRepository.findAll();
    }

    public Story getStory(){
        return storyRepository.findFirstByOrderByPostedDesc();
    }

    public Story getSpecificStory(String title) {
        return storyRepository.findByTitle(title);
    }

    public List<Story> getStoriesByBloggerName(String name) {
        return storyRepository.findAllByBloggerNameIgnoreCaseOrderByPostedDesc(name);
    }

//	@PostConstruct
//	public void init(){
//		Blogger blogger = new Blogger("Belsőség", 25);
//		bloggerRepo.save(blogger);
//
//		Story story = new Story("Belső cím","Belső tartalom", new Date(), blogger);
//		storyRepo.save(story);
//	}


}