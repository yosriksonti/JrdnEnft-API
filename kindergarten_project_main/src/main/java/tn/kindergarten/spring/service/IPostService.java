package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Favorite;

	
import java.util.List;
<<<<<<< Updated upstream
import java.util.Map;
=======
>>>>>>> Stashed changes

import tn.kindergarten.spring.entities.Post;

public interface IPostService {
	
<<<<<<< Updated upstream
	boolean deletePost(int id);
	boolean updatePost(Post post);
	Post findById(int id);
	Map<Integer,Integer> updateLikes(Post post);
	Map<Integer,Integer> updateDislikes(Post post);
=======
	boolean addPost(Post post);
	boolean deletePost(int id);
	boolean updatePost(Post post);
	Post findById(int id);
	List<Post> findAllByDaycareId(int daycareId);
>>>>>>> Stashed changes
}