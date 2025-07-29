package com.bendrioue.expressmenu.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bendrioue.expressmenu.dto.SectionDto;
import com.bendrioue.expressmenu.exception.MenuNotFoundException;
import com.bendrioue.expressmenu.mapper.AppMapper;
import com.bendrioue.expressmenu.model.Section;
import com.bendrioue.expressmenu.repository.SectionRepository;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final AppMapper appMapper;

    public SectionService(SectionRepository sectionRepository, AppMapper appMapper) {
        this.sectionRepository = sectionRepository;
        this.appMapper = appMapper;
    }

    public SectionDto createSection(SectionDto sectionDto) {
        return appMapper.sectionToSectionDto(sectionRepository.save(appMapper.sectionDtoToSection(sectionDto)));
    }

    public List<SectionDto> getAllSections() {
        return sectionRepository.findAll().stream()
                .map(appMapper::sectionToSectionDto)
                .toList();
    }

    public SectionDto getSectionById(UUID sectionId) {
        return sectionRepository.findById(sectionId)
                .map(appMapper::sectionToSectionDto)
                .orElseThrow(() -> new MenuNotFoundException(sectionId));
    }

    public SectionDto updateSection(UUID sectionId, SectionDto sectionDto) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new MenuNotFoundException(sectionId));
        section.setName(sectionDto.getName());
        section.setDisplayOrder(sectionDto.getDisplayOrder());
        return appMapper.sectionToSectionDto(sectionRepository.save(section));
    }

    public void deleteSection(UUID sectionId) {
        sectionRepository.deleteById(sectionId);
    }
}
