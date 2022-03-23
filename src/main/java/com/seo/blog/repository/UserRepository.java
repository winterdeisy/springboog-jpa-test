package com.seo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seo.blog.model.User;

//DAO
//자동으로 bean등록이 된다
//@Repository 생략 가능하다
public interface UserRepository extends JpaRepository<User, Integer>{ 
	//유저 테이블을 관리하는 JpaRepository이며 유저테이블의 PRIMARYKEY는 int이다.
	
}
