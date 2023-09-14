package com.makara.java.kit.javahome.service;

import com.makara.java.kit.javahome.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);
}
