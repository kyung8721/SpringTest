package com.kyung.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kyung.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer>{
	public List<Recruit> findByPositionAndType(String position, String type);
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<Recruit> findByTypeOrderBySalaryDesc(String type);
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	@Query(value="SELECT * FROM `jobposting` WHERE `deadline` > :deadline AND `salary` >= :salary AND `type` = :type ORDER BY `salary` DESC;", nativeQuery=true)
	public List<Recruit> selectByJob(@Param("deadline") String deadline, @Param("salary") int salary, @Param("type") String type);
}
