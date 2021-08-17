package com.cognizant.ormlearn.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Skill;

@Transactional
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
