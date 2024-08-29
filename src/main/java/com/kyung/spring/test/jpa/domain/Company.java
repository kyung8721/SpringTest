package com.kyung.spring.test.jpa.domain;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder=true)
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 생성 - > ?name="OOO" 같은 값을 받아서 만들어줌
@NoArgsConstructor // 파라미터가 없는 디폴트 생성자를 생성 -> 파라미터로 안 받아도 자동으로 생성되는 값을 만들어줌
@Getter
@Setter
@Table(name="company")
@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String business;
	private String scale;
	private int headcount;
	
	@CreationTimestamp
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
