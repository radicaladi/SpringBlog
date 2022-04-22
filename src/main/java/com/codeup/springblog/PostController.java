package com.codeup.springblog;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.PostRepository;
import com.codeup.springblog.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping (path= "/posts/create")
    public String CreatePostView(@ModelAttribute Post newPost) {
        postDao.save(newPost);
        return "redirect:/posts";
    }
}
