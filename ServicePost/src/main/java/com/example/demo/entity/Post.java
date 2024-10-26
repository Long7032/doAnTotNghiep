package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "post_id")
	private String id;
	@Column(name = "post_title")
	private String title;
	@Column(name = "post_content", columnDefinition = "text")
	private String content;
	@Column(name = "post_time_create")
	private LocalDateTime timeCreate;
	@Column(name = "post_id_catalog")
	private String idCatalog;
	@Column(name = "post_id_user")
	private String idUser;
	@PrePersist
	protected void onCreate() {
		
		if(timeCreate == null) {
			timeCreate = LocalDateTime.now();// Or Inactive
		}
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String id, String title, String content, LocalDateTime timeCreate, String idCatalog, String idUser) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.timeCreate = timeCreate;
		this.idCatalog = idCatalog;
		this.idUser = idUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(LocalDateTime timeCreate) {
		this.timeCreate = timeCreate;
	}

	public String getIdCatalog() {
		return idCatalog;
	}

	public void setIdCatalog(String idCatalog) {
		this.idCatalog = idCatalog;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", timeCreate=" + timeCreate
				+ ", idCatalog=" + idCatalog + ", idUser=" + idUser + "]";
	}

}
