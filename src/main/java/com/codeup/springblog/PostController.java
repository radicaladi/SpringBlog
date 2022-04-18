package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @RequestMapping(path= "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String Landing() {
        return "this is the index page of the posts to my blog!";
    }

    @RequestMapping(path= "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public int postId(@PathVariable int id) { return id; }

    @RequestMapping(path= "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPage() { return "This is the place where you will create a post!"; }

    @PostMapping(path= "/posts/create")
    @ResponseBody
    public String createPost() { return "This is the form you use to post something!"; }
}
