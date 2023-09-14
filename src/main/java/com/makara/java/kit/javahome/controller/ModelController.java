package com.makara.java.kit.javahome.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makara.java.kit.javahome.dto.ModelDTO;
import com.makara.java.kit.javahome.entity.Model;
import com.makara.java.kit.javahome.mapper.ModelMapper;
import com.makara.java.kit.javahome.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	private final ModelService modelService;
	private final ModelMapper modelMapper;
	

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
}