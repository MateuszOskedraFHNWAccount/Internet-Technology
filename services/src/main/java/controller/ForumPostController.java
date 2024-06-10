package services/src/main/java/controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/forumpost")
public class ForumPostController {

    @PostMapping(path = "/api/forum/posts",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ForumPost> createForumPost(@RequestBody ForumPost forumPost) {
        ForumPost savedPost = forumPostRepository.save(forumPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
}