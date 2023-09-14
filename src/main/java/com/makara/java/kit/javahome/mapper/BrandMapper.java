package com.makara.java.kit.javahome.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.makara.java.kit.javahome.dto.BrandDTO;
import com.makara.java.kit.javahome.entity.Brand;

@Mapper
public interface BrandMapper {
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	
	Brand toBrand(BrandDTO dto);
	
	BrandDTO toBrandDTO(Brand entity);
}
