package com.makara.java.kit.javahome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.makara.java.kit.javahome.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>, JpaSpecificationExecutor<Brand>{
	List<Brand> findByNameLike(String name);
	List<Brand> findByNameContaining(String name);
}
