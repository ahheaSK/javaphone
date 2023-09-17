package com.makara.java.kit.javahome.service;

import java.util.List;

import com.makara.java.kit.javahome.entity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrand(Long brandId);
	
	Model getById(Long id);
}
