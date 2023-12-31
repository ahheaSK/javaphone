package com.makara.java.kit.javahome.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.makara.java.kit.javahome.dto.ProductDTO;
import com.makara.java.kit.javahome.dto.ProductImportDTO;
import com.makara.java.kit.javahome.entity.Product;
import com.makara.java.kit.javahome.entity.ProductImportHistory;
import com.makara.java.kit.javahome.service.ColorService;
import com.makara.java.kit.javahome.service.ModelService;

@Mapper(componentModel = "spring", uses = {ModelService.class, ColorService.class})
public interface ProductMapper {
	
	@Mapping(target = "model", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Product toProduct(ProductDTO productDTO);
	
	@Mapping(target = "dateImport", source = "importDTO.importDate")
	@Mapping(target = "pricePerUnit", source = "importDTO.importPrice")
	@Mapping(target = "product", source = "product")
	@Mapping(target = "id", ignore = true)
	ProductImportHistory toProductImportHistory(ProductImportDTO importDTO, Product product);
}
