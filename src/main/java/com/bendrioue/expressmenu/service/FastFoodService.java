package com.bendrioue.expressmenu.service;

import com.bendrioue.expressmenu.dto.FastFoodDto;
import com.bendrioue.expressmenu.exception.FastFoodNotFoundException;
import com.bendrioue.expressmenu.mapper.FastFoodMapper;
import com.bendrioue.expressmenu.repository.FastFoodRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FastFoodService {

    private final FastFoodRepository fastFoodRepository;
    private final FastFoodMapper fastFoodMapper;

    public FastFoodService(FastFoodRepository fastFoodRepository, FastFoodMapper fastFoodMapper) {
        this.fastFoodRepository = fastFoodRepository;
        this.fastFoodMapper = fastFoodMapper;
    }

    public FastFoodDto getFastFoodById(UUID fastFoodId) {
        return fastFoodRepository.findById(fastFoodId)
                .map(fastFoodMapper::toDto)
                .orElseThrow(() -> new FastFoodNotFoundException(fastFoodId));
    }
}