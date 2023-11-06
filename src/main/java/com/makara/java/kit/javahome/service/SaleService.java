package com.makara.java.kit.javahome.service;

import com.makara.java.kit.javahome.dto.SaleDTO;
import com.makara.java.kit.javahome.entity.Sale;

public interface SaleService {
	void sell(SaleDTO saleDTO);
	Sale getById(Long saleId);
	void cancelSale(Long saleId);
}
