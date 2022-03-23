package com.seo.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
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
//게시판 테이블
public class Board {
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 100)
	private String title; //게시글 제목
	
	@Lob //대용량 데이터
	private String content; // 게시글 제목, 섬머노트 라이브러리 : 일반적 글이 디자인이 되어 들어감 -> 용량 BIG

	@ColumnDefault("0") //기본값은 0
	private int count; //조회수
	
// 조인 맺어주기
//	private int userId; //게시글을 누가 적었는지 - user테이블과 조인 필요 (FK)
//	DB는 오브젝트를 저장할수 없지만 자바는 오브젝트를 저장할 수 있다.
	@ManyToOne(fetch  = FetchType.EAGER) //연관관계, many = Board, one = User
	@JoinColumn(name="userId") //FK 이름, 필드값으로 만들어진다
	private User user; //User를 참조한다
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) 
	private List<Reply> reply; //reply를 참조한다
	
	@CreationTimestamp //데이터가 insert, update될때 자동으로 현재 시각이 들어감
	private Timestamp createDate;
}
