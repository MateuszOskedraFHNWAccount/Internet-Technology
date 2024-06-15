package controller;

import data.domain.ForumPost;
import data.repository.ForumPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/forumpost")
public class ForumPostController {

    @Autowired
    private ForumPostRepository forumPostRepository;

    @PostMapping(path = "/api/forum/posts",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ForumPost> createForumPost(@RequestBody ForumPost forumPost) {
        ForumPost savedPost = forumPostRepository.save(forumPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
    
    @PutMapping(path = "/api/forum/edit/{postId}")
    public ResponseEntity<ForumPost> updateForumPost(@PathVariable Long postId, @RequestBody ForumPost updatedPost) throws Exception {
        ForumPost existingPost;
        try {
            existingPost = forumPostRepository.findById(postId).get();
            ForumPost savedPost = forumPostRepository.save(existingPost);
            return ResponseEntity.ok(savedPost);
        }catch(Exception e){
            new Exception("ForumPost not found with ID: " + postId);
        }
        return null;
}
}