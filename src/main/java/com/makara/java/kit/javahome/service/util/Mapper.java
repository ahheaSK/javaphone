package com.makara.java.kit.javahome.service.util;

import com.makara.java.kit.javahome.dto.BrandDTO;
import com.makara.java.kit.javahome.entity.Brand;

public class Mapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
	
	public static BrandDTO toBrandDTO(Brand brand) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setId(brand.getId());
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
