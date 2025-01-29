package com.mavenstarter.controller;

import com.mavenstarter.entity.Story;
import com.mavenstarter.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private StoryService storyService;

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }


    @RequestMapping("/story")
    public Story story() {
        return storyService.getStory();
    }

    @RequestMapping("/title/{title}")
    public Story searchForUser(@PathVariable(value = "title") String title) {
        return storyService.getSpecificStory(title);
    }

    @RequestMapping("/stories/{name}")
    public List<Story> searchStoriesByBloggerName(@PathVariable(value = "name") String name) {
        return storyService.getStoriesByBloggerName(name);
    }
}
