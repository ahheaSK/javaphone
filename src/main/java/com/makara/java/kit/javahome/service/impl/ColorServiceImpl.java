package com.makara.java.kit.javahome.service.impl;

import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.entity.Color;
import com.makara.java.kit.javahome.exception.ResourceNotFoundException;
import com.makara.java.kit.javahome.repository.ColorRepository;
import com.makara.java.kit.javahome.repository.ProductRepository;
import com.makara.java.kit.javahome.service.ColorService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ColorServiceImpl implements ColorService{
	private final ColorRepository colorRepository;
	@Override
	public Color create(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getById(Long id) {
		return colorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Color", id));
	}

}
