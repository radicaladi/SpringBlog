package com.codeup.springblog;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) { this.postDao = postDao; }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postDao.findAllById(id));
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @RequestMapping (path= "/posts/create", method = RequestMethod.POST)
    public String CreatePostView(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }
}
