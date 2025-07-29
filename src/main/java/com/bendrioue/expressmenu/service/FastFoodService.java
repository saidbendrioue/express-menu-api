package com.bendrioue.expressmenu.service;

import com.bendrioue.expressmenu.dto.FastFoodDto;
import com.bendrioue.expressmenu.exception.FastFoodNotFoundException;
import com.bendrioue.expressmenu.mapper.AppMapper;
import com.bendrioue.expressmenu.model.FastFood;
import com.bendrioue.expressmenu.repository.FastFoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FastFoodService {

    private final FastFoodRepository fastFoodRepository;
    private final AppMapper fastFoodMapper;

    public FastFoodService(FastFoodRepository fastFoodRepository, AppMapper fastFoodMapper) {
        this.fastFoodRepository = fastFoodRepository;
        this.fastFoodMapper = fastFoodMapper;
    }

    public FastFoodDto getFastFoodById(UUID fastFoodId) {
        return fastFoodRepository.findById(fastFoodId)
                .map(fastFoodMapper::fastFoodToFastFoodDto)
                .orElseThrow(() -> new FastFoodNotFoundException(fastFoodId));
    }

    public List<FastFoodDto> getAllFastFoods() {
        return fastFoodRepository.findAll()
                .stream()
                .map(fastFoodMapper::fastFoodToFastFoodDto)
                .toList();
    }

    public FastFoodDto createFastFood(FastFoodDto fastFoodDto) {
        return fastFoodMapper.fastFoodToFastFoodDto(fastFoodRepository.save(fastFoodMapper.fastFoodDtoToFastFood(fastFoodDto)));
    }

    public FastFoodDto updateFastFood(UUID fastFoodId, FastFoodDto fastFoodDto) {
        FastFood existing = fastFoodRepository.findById(fastFoodId)
                .orElseThrow(() -> new FastFoodNotFoundException(fastFoodId));

        existing.setName(fastFoodDto.getName());
        existing.setAddress(fastFoodDto.getAddress());
        existing.setPhone(fastFoodDto.getPhone());
        existing.setEmail(fastFoodDto.getEmail());
        existing.setLogoUrl(fastFoodDto.getLogoUrl());
        existing.setOpeningTime(fastFoodDto.getOpeningTime());
        existing.setClosingTime(fastFoodDto.getClosingTime());

        return fastFoodMapper.fastFoodToFastFoodDto(fastFoodRepository.save(existing));
    }

    public void deleteFastFood(UUID fastFoodId) {
        fastFoodRepository.deleteById(fastFoodId);
    }
}
