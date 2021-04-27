package tn.kindergarten.spring.service;

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
	public boolean addPost(Post post) {
		
		postRepository.save(post);
		return true;
	}

	@Override
	public boolean deletePost(int id) {
		postRepository.delete(postRepository.findById(id).get());
		return true;
	}

	@Override
	public boolean updatePost(Post post) {
		postRepository.save(post);
		return true;
	}

	@Override
	public Post findById(int id) {
		return postRepository.findById(id).get();
	}

	@Override
	public List<Post> findAllByDaycareId(int daycareId) {
		List<Post> posts = (List<Post>) postRepository.findAll(); 
		List<Post> daycarePosts = new ArrayList();
		
		for(Post post : posts )
		{
			if(post.getDaycare().getId() == daycareId) {
				daycarePosts.add(post);
			}
		}
		return daycarePosts;
	}
	public Map<Integer,Integer> updateLikes(Post post) {
		Post startPost = findById(post.getId());
		int startLikes = startPost.getLikes();
		startPost.setLikes(startLikes+post.getLikes());
		Post endPost = findById(post.getId());
		int endLikes = endPost.getLikes();
		if(startLikes == endLikes-1) {
			Map<Integer,Integer> responseMap = new HashMap<>();
			postRepository.save(startPost);
			responseMap.put(startPost.getId(), startPost.getLikes());
			return responseMap;
		} else {
			return updateLikes(post);
		}
	}
	
	public Map<Integer,Integer> updateDislikes(Post post) {
		Post startPost = findById(post.getId());
		int startDislikes = startPost.getDislikes();
		startPost.setDislikes(startDislikes+post.getDislikes());
		Post endPost = findById(post.getId());
		int endLDislkes = endPost.getDislikes();
		if(startDislikes == endLDislkes-1) {
			Map<Integer,Integer> responseMap = new HashMap<>();
			postRepository.save(startPost);
			responseMap.put(startPost.getId(), startPost.getDislikes());
			return responseMap;
		} else {
			return updateDislikes(post);
		}
	}

}
