package com.seo.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

//lombok 라이브러리
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity //테이블화 시키는 어노테이션, User 클래스가 MySQL에 자동으로 테이블 생성됨
public class User {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 30) //null값 없게, 길이 제한
	private String usrename; //아이디
	
	@Column(nullable = false, length = 100) //null값 없게, 길이 제한, 1234 -> 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50) //null값 없게, 길이 제한
	private String userEmail;
	
	@ColumnDefault("'user'") //user로 기본값을 준다.
	private String role; //Enum을 쓰는게 좋다(도메인) //admin, user, manager
	
	@CreationTimestamp //시간 자동 입력
	private Timestamp cerateDate; //mysql의 타임스탬프, 회원이 가입한 시간

}
