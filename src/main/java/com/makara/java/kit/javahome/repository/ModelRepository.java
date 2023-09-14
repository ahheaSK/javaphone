package com.makara.java.kit.javahome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makara.java.kit.javahome.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	List<Model> findByBrandId(Integer brandId);

}
