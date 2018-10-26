package com.spotted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotted.models.Post;
import com.spotted.services.PostService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class PostController {

    @Autowired
    PostService postService;

    private boolean notText(String text) {
        return text == null || text.isEmpty();
    }

    private boolean notImage(byte[] image) {
        return image == null || image.length == 0;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Post save(@RequestBody Post post) throws Exception {
        if (this.notText(post.getText()) && this.notImage(post.getImage())) {
            throw new Exception("Text and image can not be empty or null simultaneously'");
        }
        return this.postService.save(post);
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public List<Post> getAll() {
        return this.postService.getAll();
    }

    @RequestMapping(value = "/post/user/{email}", method = RequestMethod.GET)
    public List<Post> searchByEmail(@PathVariable String email) {
        return this.postService.searchByEmail(email);
    }

    @RequestMapping(value = "/post/id/{id}", method = RequestMethod.GET)
    public Post searchById(@PathVariable Long id) {
        return this.postService.searchById(id);
    }

    @RequestMapping(value = "/post/id/{id}", method = RequestMethod.DELETE)
    public Post deleteById(@PathVariable Long id) {
        return this.postService.deleteById(id);
    }
}
