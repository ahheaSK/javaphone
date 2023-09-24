package com.makara.java.kit.javahome.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductImportDTO {
	private Long productId;
	private Integer importUnit;
	private BigDecimal importPrice;
	private LocalDate importDate;
}
