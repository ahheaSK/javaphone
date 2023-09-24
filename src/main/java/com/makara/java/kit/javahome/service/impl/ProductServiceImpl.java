package com.makara.java.kit.javahome.service.impl;

import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.dto.ProductImportDTO;
import com.makara.java.kit.javahome.entity.Product;
import com.makara.java.kit.javahome.entity.ProductImportHistory;
import com.makara.java.kit.javahome.exception.ResourceNotFoundException;
import com.makara.java.kit.javahome.mapper.ProductMapper;
import com.makara.java.kit.javahome.repository.ProductImportHistoryRepository;
import com.makara.java.kit.javahome.repository.ProductRepository;
import com.makara.java.kit.javahome.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository importHistoryRepository;
	private final ProductMapper productMapper;

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

	@Override
	public void importProduct(ProductImportDTO importDTO) {
		// update available product unit
		Product product = getById(importDTO.getProductId());
		Integer availableUnit = 0;
		if(product.getAvailableUnit() != null) {
			availableUnit = product.getAvailableUnit();
		}
		product.setAvailableUnit(availableUnit + importDTO.getImportUnit());
		productRepository.save(product);
		// save product import history
		ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
		importHistoryRepository.save(importHistory);
	}

}
