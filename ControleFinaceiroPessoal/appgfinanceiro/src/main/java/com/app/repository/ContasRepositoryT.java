package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.ContasModel;

public interface ContasRepositoryT extends JpaRepository<ContasModel, Long> {
}