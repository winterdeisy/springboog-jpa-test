package com.seo.blog.model;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok 라이브러리
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
//답변 테이블
public class Reply { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB 넘버링 전략을 따라간다.
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne //하나의 게시글(board)엔 여러개의 답변(reply)
	@JoinColumn(name="boardId") //fk 이름
	private Board board; //board 클래스 참조
	
	@ManyToOne //하나의 user는 여러개의 reply를 달 수 있다. 
	@JoinColumn(name="userId")
	private User user; //user 클래스 참조
	
	@CreationTimestamp
	private Timestamp createDate;

}
