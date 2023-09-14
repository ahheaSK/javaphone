package com.makara.java.kit.javahome.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.makara.java.kit.javahome.entity.Brand;


@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;

	@Test
	public void testFindByNameLike() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");		
		
		brandRepository.save(brand);
		
		//when
		List<Brand> brands = brandRepository.findByNameLike("%A%");
		
		//then
		assertEquals(1, brands.size());
		assertEquals("Apple", brands.get(0).getName());
		assertEquals(1, brands.get(0).getId());
	}
}
