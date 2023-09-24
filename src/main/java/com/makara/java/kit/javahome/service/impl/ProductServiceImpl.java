package com.makara.java.kit.javahome.service.impl;

import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.entity.Product;
import com.makara.java.kit.javahome.exception.ResourceNotFoundException;
import com.makara.java.kit.javahome.repository.ProductRepository;
import com.makara.java.kit.javahome.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		String name = "%s %s"
				.formatted(product.getModel().getName(), product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}

}
