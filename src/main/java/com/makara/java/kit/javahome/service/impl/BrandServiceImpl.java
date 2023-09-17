package com.makara.java.kit.javahome.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.entity.Brand;
import com.makara.java.kit.javahome.exception.ResourceNotFoundException;
import com.makara.java.kit.javahome.repository.BrandRepository;
import com.makara.java.kit.javahome.service.BrandService;
import com.makara.java.kit.javahome.service.util.PageUtil;
import com.makara.java.kit.javahome.spec.BrandFilter;
import com.makara.java.kit.javahome.spec.BrandSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	@Autowired
	private final BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Long id) {
		return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Long id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName()); // @TODO improve update
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getBrands(String name) {
		return brandRepository.findByNameContaining(name);
	}

	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();

		if (params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}

		if (params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		// @TODO add to a function for pageable
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if (params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}

		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if (params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}

		BrandSpec brandSpec = new BrandSpec(brandFilter);

		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

		Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
		return page;
	}

}
