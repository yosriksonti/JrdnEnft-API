package tn.kindergarten.spring.service;

<<<<<<< Updated upstream
import java.util.Date;
=======
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Post;
import tn.kindergarten.spring.repository.PostRepository;

@Service
public class PostService implements IPostService {

	@Autowired
	PostRepository postRepository;
	
	@Override
<<<<<<< Updated upstream
=======
	public boolean addPost(Post post) {
		
		postRepository.save(post);
		return true;
	}

	@Override
>>>>>>> Stashed changes
	public boolean deletePost(int id) {
		postRepository.delete(postRepository.findById(id).get());
		return true;
	}

	@Override
	public boolean updatePost(Post post) {
<<<<<<< Updated upstream
		post.setModificationDate(new Date());
=======
>>>>>>> Stashed changes
		postRepository.save(post);
		return true;
	}

	@Override
	public Post findById(int id) {
		return postRepository.findById(id).get();
	}

	@Override
<<<<<<< Updated upstream
	public Map<Integer,Integer> updateLikes(Post post) {
		Post startPost = findById(post.getId());
		int startLikes = startPost.getLikes();
		startPost.setLikes(startLikes+post.getLikes());
		startPost.setModificationDate(new Date());
		Post endPost = findById(post.getId());
		int endLikes = endPost.getLikes();
		System.out.println("start: "+startLikes+" | end: "+endLikes);
		if(endLikes == startLikes+1) {
			updatePost(startPost);
			Map<Integer,Integer> resp = new HashMap<Integer,Integer>();
			resp.put(post.getId(), startPost.getLikes());
			return resp;
=======
	public List<Post> findAllByDaycareId(int daycareId) {
		List<Post> posts = (List<Post>) postRepository.findAll(); 
		List<Post> daycarePosts = new ArrayList();
		
		for(Post post : posts )
		{
			if(post.getId() == daycareId) {
				daycarePosts.add(post);
			}
		}
		return daycarePosts;
	}
	
	public Map<Integer,Integer> updateLikes(Post post){
		Post startPost = findById(post.getId());
		int startLikes = startPost.getLikes();
		startPost.setLikes(startLikes+post.getLikes());
		Post endPost = findById(post.getId());
		int endLikes = endPost.getLikes();
		if(startLikes == endLikes-1) {
			Map<Integer,Integer> map= new HashMap<>();
			map.put(startPost.getId(), startPost.getLikes());
			postRepository.save(startPost);
			return map;
>>>>>>> Stashed changes
		} else {
			return updateLikes(post);
		}
	}
<<<<<<< Updated upstream

	@Override
	public Map<Integer,Integer> updateDislikes(Post post) {
		Post startPost = findById(post.getId());
		int startDislikes = startPost.getDislikes();
		startPost.setDislikes(startDislikes+post.getDislikes());
		startPost.setModificationDate(new Date());
		Post endPost = findById(post.getId());
		int endDislikes = endPost.getDislikes();
		if(endDislikes == startDislikes + 1) {
			updatePost(startPost);
			Map<Integer,Integer> resp = new HashMap<Integer,Integer>();
			resp.put(post.getId(), startPost.getDislikes());
			return resp;
=======
	public Map<Integer,Integer> updateDislikes(Post post){
		Post startPost = findById(post.getId());
		int startDislikes = startPost.getDislikes();
		startPost.setDislikes(startDislikes+post.getDislikes());
		Post endPost = findById(post.getId());
		int endDislikes = endPost.getDislikes();
		if(startDislikes == endDislikes-1) {
			Map<Integer,Integer> map= new HashMap<>();
			map.put(startPost.getId(), startPost.getDislikes());
			postRepository.save(startPost);
			return map;
>>>>>>> Stashed changes
		} else {
			return updateDislikes(post);
		}
	}
<<<<<<< Updated upstream
	
	


=======
>>>>>>> Stashed changes

}
