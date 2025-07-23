package com.bendrioue.expressmenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bendrioue.expressmenu.model.FastFood;

import java.util.UUID;

@Repository
public interface FastFoodRepository extends JpaRepository<FastFood, UUID> {
}