package com.bendrioue.expressmenu.service;

import org.springframework.stereotype.Service;

import com.bendrioue.expressmenu.dto.MenuDto;
import com.bendrioue.expressmenu.exception.MenuNotFoundException;
import com.bendrioue.expressmenu.mapper.MenuMapper;
import com.bendrioue.expressmenu.model.Menu;
import com.bendrioue.expressmenu.repository.MenuRepository;

import java.util.UUID;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    public MenuService(MenuRepository menuRepository, MenuMapper menuMapper) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
    }

    public MenuDto getMenuById(UUID uuid) {
        Menu Menu = menuRepository.findById(uuid).orElseThrow(() -> new MenuNotFoundException(uuid));
        return menuMapper.toDto(Menu);
    }
}