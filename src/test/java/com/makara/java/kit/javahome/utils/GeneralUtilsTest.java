package com.makara.java.kit.javahome.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

public class GeneralUtilsTest {
	
	
	//@Test
	public void testToIntegerList() {
		//Given
		List<String> names = List.of("Dara","Cheata","Thida");
		//When
		List<Integer> list = GeneralUtils.toIntegerList(names);
		//Then
		//[4,6,5]
		
		assertEquals(3, list.size());
		assertEquals(4, list.get(0));
		assertEquals(6, list.get(1));
		assertEquals(5, list.get(2));
	}
	
	//@Test
	public void testGetEvenNumber() {
		//given
		List<Integer> list = List.of(4,5,3,20,6,8);
		//when
		List<Integer> evenNumbers = GeneralUtils.getEvenNumber(list);
		//then
		assertEquals(4, evenNumbers.size());
		assertEquals(4, evenNumbers.get(0));
	}
	
	@Test
	public void showPassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encode = passwordEncoder.encode("makara123");
		System.out.println(encode);
	}
}
