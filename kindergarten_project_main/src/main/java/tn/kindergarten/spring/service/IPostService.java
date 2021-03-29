package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Favorite;

	
import java.util.List;
import java.util.Map;

import tn.kindergarten.spring.entities.Post;

public interface IPostService {
	
	boolean deletePost(int id);
	boolean updatePost(Post post);
	Post findById(int id);
	Map<Integer,Integer> updateLikes(Post post);
	Map<Integer,Integer> updateDislikes(Post post);
}