package tn.kindergarten.spring.entities;

import java.io.Serializable;
<<<<<<< Updated upstream
import java.util.Date;
=======
import java.sql.Date;
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
<<<<<<< Updated upstream
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
=======
>>>>>>> Stashed changes
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	//@NotNull
	private Daycare daycare;
	
	private String media;
	private String title;
	private String body;
	
	
<<<<<<< Updated upstream
	private int likes = 0;
	private int dislikes = 0;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate = new Date();
	@Temporal(TemporalType.TIMESTAMP)
=======
	private int likes;
	private int dislikes;
	
	private Date creationDate;
>>>>>>> Stashed changes
	private Date modificationDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Daycare getDaycare() {
		return daycare;
	}
	public void setDaycare(Daycare daycare) {
		this.daycare = daycare;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Post(int id, Daycare daycare, String media, String title, String body, int likes,
			int dislikes, Date creationDate, Date modificationDate) {
		super();
		this.id = id;
		this.daycare = daycare;
		this.media = media;
		this.title = title;
		this.body = body;
		this.likes = likes;
		this.dislikes = dislikes;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	public Post() {
		super();
	}
	
	
}
