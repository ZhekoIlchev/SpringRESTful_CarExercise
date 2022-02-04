package com.example.demo.services;

import com.example.demo.models.Engine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EngineService {
    Engine saveEngine(Engine engine);

    Engine editEngine(Engine engine);

    Optional<Engine> findById(Long id);

    void deleteEngineById(Long id);

    Page<Engine> findAll(Pageable pageable);
}
