package com.makara.java.kit.javahome.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.entity.Model;
import com.makara.java.kit.javahome.repository.ModelRepository;
import com.makara.java.kit.javahome.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {
	private final ModelRepository modelRepository;

	@Override
	public Model save(Model model) {
		return modelRepository.save(model);
	}

	@Override
	public List<Model> getByBrand(Integer brandId) {
		return modelRepository.findByBrandId(brandId);
	}

}