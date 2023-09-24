package com.makara.java.kit.javahome.service;

import com.makara.java.kit.javahome.entity.Color;

public interface ColorService {
	Color create(Color color);
	Color getById(Long id);
}

