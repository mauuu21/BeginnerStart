package com.mavenstarter.controller;

import com.mavenstarter.entity.Story;
import com.mavenstarter.repository.StoryRepository;
import com.mavenstarter.service.StoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Locale;

@Controller
public class HomeController {

    private StoryService storyService;

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("pageTitle", "Minden napra egy Story");
        model.addAttribute("stories", storyService.getStories());
        System.out.println(String.format("Request received. Language: %s, Country: %s %n", locale.getLanguage(), locale.getDisplayCountry()));
        return "stories";
    }



//    @RequestMapping("/story")
//    public String story(Model model) {
//        model.addAttribute("pageTitle", "Minden napra egy Story");
//        model.addAttribute("story", storyService.getStory());
//        return "story";
//    }

//    @RequestMapping("/user/{id}")
//    public String searchForUser(@PathVariable(value="id") String id) throws Exception {
//        if(id == null) {
//            throw new Exception("Nincs ilyen Id-val felhasználó!");
//        }
//        return "user";
//    }
//
//    @RequestMapping("/title/{title}")
//    public String searchForTitle(@PathVariable(value="title") String title, Model model) throws Exception {
//        if(title == null) {
//            throw new Exception("There is no post with this title!");
//        }
//        model.addAttribute("story", storyService.getSpecificStory(title));
//        return "story";
//    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
        model.addAttribute("errMessage", ex.getMessage());
        return "exceptionHandler";
    }

    //    private List<Story> getStories() {
//
//        List<Story> stories = storyRepository.findAll();
//        return stories;

//        ArrayList<Story> stories = new ArrayList<>();

//        Story story1 = new Story();
//        story1.setTitle("Első Story");
//        story1.setPosted(new Date());
//        story1.setAuthor("M.Mauuu");
//        story1.setContent("<p> Ez egy új adat, ami már éles.</p>");
//
//        Story story2 = new Story();
//        story2.setTitle("Második Story");
//        story2.setPosted(new Date());
//        story2.setAuthor("Sankó");
//        story2.setContent("<p>M.Mauuu írkál össze-vissza, ne legyél olyan!</p>");
//
//        Story story3 = new Story();
//        story3.setTitle("Harmadik Story");
//        story3.setPosted(new Date());
//        story3.setAuthor("M.Mauuu");
//        story3.setContent("<p>Sankó!Már megint kezded...</p>");
//
//        stories.add(story1);
//        stories.add(story2);
//        stories.add(story3);
//        return stories;
//    }
}
