package com.makara.java.kit.javahome.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makara.java.kit.javahome.dto.ProductDTO;
import com.makara.java.kit.javahome.dto.ProductImportDTO;
import com.makara.java.kit.javahome.entity.Product;
import com.makara.java.kit.javahome.mapper.ProductMapper;
import com.makara.java.kit.javahome.service.ProductService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
	
	private final ProductService productService;
	private final ProductMapper productMapper;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);
		
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("importProduct")
	public ResponseEntity<?> importProduct(@RequestBody @Valid ProductImportDTO importDTO){
		productService.importProduct(importDTO);
		return ResponseEntity.ok().build();
	}
}
