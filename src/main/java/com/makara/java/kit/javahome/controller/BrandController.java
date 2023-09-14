package com.makara.java.kit.javahome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makara.java.kit.javahome.dto.BrandDTO;
import com.makara.java.kit.javahome.entity.Brand;
import com.makara.java.kit.javahome.service.BrandService;
import com.makara.java.kit.javahome.service.util.Mapper;


@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = Mapper.toBrand(brandDTO);
		brand = brandService.create(brand);
		
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
}
