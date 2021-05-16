package tn.kindergarten.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Post;
import tn.kindergarten.spring.service.PostService;

@RestController
public class RestPostController {
	
	@Autowired
	PostService postService;

	
	@GetMapping(value = "/posts/{id}") 
	@ResponseBody
		public Post getPost(@PathVariable("id") int id) 
		{
			Post post =  postService.findById(id);
			return post;
		
		}
	@GetMapping(value = "/daycares/{id}/posts") 
	@ResponseBody
		public List<Post> getDaycarePost(@PathVariable("id") int id) 
		{
			List<Post> post =  postService.findAllByDaycareId(id);
			return post;
		
		}
	@PutMapping(value = "/posts/update") 
	@ResponseBody
		public boolean updatePost(@RequestBody Post post) 
		{
			
			return postService.updatePost(post);
		
		}
	
	@PutMapping(value = "/posts/update/likes") 
	@ResponseBody
		public Map<Integer,Integer> updatePostLikes(@RequestBody Post post) 
		{
			
			return postService.updateLikes(post);
		
		}
	
	@PutMapping(value = "/posts/update/dislikes") 
	@ResponseBody
		public Map<Integer,Integer> updatePostDislikes(@RequestBody Post post) 
		{
			
			return postService.updateDislikes(post);
		
		}
}
