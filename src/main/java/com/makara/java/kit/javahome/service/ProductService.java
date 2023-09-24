package com.makara.java.kit.javahome.service;

import com.makara.java.kit.javahome.dto.ProductImportDTO;
import com.makara.java.kit.javahome.entity.Product;

public interface ProductService {
	Product create(Product product);
	Product getById(Long id);
	
	void importProduct(ProductImportDTO importDTO);
}
