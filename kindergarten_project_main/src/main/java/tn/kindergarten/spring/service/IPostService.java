package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Favorite;

	
import java.util.List;

import tn.kindergarten.spring.entities.Post;

public interface IPostService {
	
	boolean addPost(Post post);
	boolean deletePost(int id);
	boolean updatePost(Post post,int id);
	Post findById(int id);
	List<Post> findAllByDaycareId(int daycareId);
}