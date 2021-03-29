package tn.kindergarten.spring.service;

import java.util.Date;
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
	public boolean deletePost(int id) {
		postRepository.delete(postRepository.findById(id).get());
		return true;
	}

	@Override
	public boolean updatePost(Post post) {
		post.setModificationDate(new Date());
		postRepository.save(post);
		return true;
	}

	@Override
	public Post findById(int id) {
		return postRepository.findById(id).get();
	}

	@Override
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
		} else {
			return updateLikes(post);
		}
	}

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
		} else {
			return updateDislikes(post);
		}
	}
	
	



}
