package tn.kindergarten.spring.controller;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Post;
import tn.kindergarten.spring.service.PostService;

@RestController
public class RestPostController {
	
    private final Bucket bucket;

	@Autowired
	PostService postService;
	public RestPostController() {
		Bandwidth limit = Bandwidth.classic(3, Refill.greedy(3, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder()
            .addLimit(limit)
            .build();
	}

	@PostMapping(value = "/posts/add") 
	@ResponseBody
		public ResponseEntity<Boolean> addPost(@RequestBody Post post) 
		{
		if (bucket.tryConsume(1)) {
			return ResponseEntity.ok(postService.addPost(post));
		} else {
		    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
		}
		
		}
	@GetMapping(value = "/posts/{id}") 
	@ResponseBody
		public Post getPost(@PathVariable("id") int id) 
		{
			Post post =  postService.findById(id);
			return post;
		
		}
	@GetMapping(value = "/posts/daycare/{id}") 
	@ResponseBody
		public ResponseEntity<List<Post>> getPostByDaycare(@PathVariable("id") int id) 
		{
		if (bucket.tryConsume(1)) {
			return ResponseEntity.ok(postService.findAllByDaycareId(id));
		} else {
		    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
		}			
		
		}
	@PutMapping(value = "/posts/{id}/update") 
	@ResponseBody
	public ResponseEntity<Boolean> updatePost(@PathVariable ("id") int id,@RequestBody Post post) 
		{
			
		if (bucket.tryConsume(1)) {
			return ResponseEntity.ok(postService.updatePost(post,id));
		} else {
		    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
		}
		
	}
		

	
	@PutMapping(value = "/posts/update/likes") 
	@ResponseBody
	public ResponseEntity<Map<Integer,Integer>> updatePostLikes(@RequestBody Post post) 
	{
			
		if (bucket.tryConsume(1)) {
			return ResponseEntity.ok(postService.updateLikes(post));
		} else {
		    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
		}		
	}
	
	@PutMapping(value = "/posts/update/dislikes") 
	@ResponseBody
		public ResponseEntity<Map<Integer,Integer>> updatePostDislikes(@RequestBody Post post) 
		{
			
		if (bucket.tryConsume(1)) {
			return ResponseEntity.ok(postService.updateDislikes(post));
		} else {
		    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
		}		
		}
}
