package com.makara.java.kit.javahome.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.dto.ProductSoldDTO;
import com.makara.java.kit.javahome.dto.SaleDTO;
import com.makara.java.kit.javahome.entity.Product;
import com.makara.java.kit.javahome.entity.Sale;
import com.makara.java.kit.javahome.entity.SaleDetail;
import com.makara.java.kit.javahome.exception.ApiException;
import com.makara.java.kit.javahome.repository.ProductRepository;
import com.makara.java.kit.javahome.repository.SaleDetailRepository;
import com.makara.java.kit.javahome.repository.SaleRepository;
import com.makara.java.kit.javahome.service.ProductService;
import com.makara.java.kit.javahome.service.SaleService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService{
	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleRepository saleRepository;
	private final SaleDetailRepository saleDetailRepository;
	
	@Override
	public void sell(SaleDTO saleDTO) {
		List<Long> productIds = saleDTO.getProducts().stream()
				.map(ProductSoldDTO::getProductId)
				.toList();
			// validate product
		productIds.forEach(productService::getById);
		
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
			.collect(Collectors.toMap(Product::getId, Function.identity()));
		
		
		// validate stock
		saleDTO.getProducts()
			.forEach(ps ->{
				Product product = productMap.get(ps.getProductId());
				if(product.getAvailableUnit() < ps.getNumberOfUnit()) {
					throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));
				}
			});
		
		// Sale
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);
		
		// Sale Detail
		saleDTO.getProducts().forEach(ps ->{
			Product product = productMap.get(ps.getProductId());
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(product.getSalePrice());
			saleDetail.setProduct(product);
			saleDetail.setSale(sale);
			saleDetail.setUnit(ps.getNumberOfUnit());
			saleDetailRepository.save(saleDetail);
			
			// cut stock
			Integer availableUnit =  product.getAvailableUnit() - ps.getNumberOfUnit();
			product.setAvailableUnit(availableUnit);
			productRepository.save(product);
		});
	}
	
	private void saveSale(SaleDTO saleDTO) {
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);
		
		//Sale Detail
		saleDTO.getProducts().forEach(ps ->{
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(null);
		});
	}
	
	private void validate(SaleDTO saleDTO) {
		saleDTO.getProducts().forEach(ps ->{
			Product product = productService.getById(ps.getProductId());
			if(product.getAvailableUnit() < ps.getNumberOfUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));
			}
		});
	}
}
