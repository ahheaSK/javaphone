package com.makara.java.kit.javahome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.entity.Brand;
import com.makara.java.kit.javahome.repository.BrandRepository;
import com.makara.java.kit.javahome.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

}
