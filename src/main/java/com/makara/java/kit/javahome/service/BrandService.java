package com.makara.java.kit.javahome.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.makara.java.kit.javahome.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Long id);
	Brand update(Long id, Brand brandUpdate);
	
	List<Brand> getBrands();
	List<Brand> getBrands(String name);
	
	Page<Brand> getBrands(Map<String, String> params);
}

