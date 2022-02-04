package com.example.demo.services;

import com.example.demo.models.Engine;
import com.example.demo.reposotories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Engine saveEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Engine editEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Optional<Engine> findById(Long id) {
        return engineRepository.findById(id);
    }

    @Override
    public void deleteEngineById(Long id) {
        engineRepository.deleteById(id);
    }

    @Override
    public Page<Engine> findAll(Pageable pageable) {
        return engineRepository.findAll(pageable);
    }
}
