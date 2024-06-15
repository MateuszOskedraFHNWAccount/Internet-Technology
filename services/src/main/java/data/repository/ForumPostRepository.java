package services.src.main.java.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.src.main.java.data.domain.ForumPost;

@Repository
public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {

    Object findByTopic(String topic);
    // You can add custom query methods here if needed

    void deleteByPostId(long postID);
}
