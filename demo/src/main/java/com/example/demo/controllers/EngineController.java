package com.example.demo.controllers;

import com.example.demo.dtos.EngineDto;
import com.example.demo.exceptions.EngineNotFoundException;
import com.example.demo.models.Engine;
import com.example.demo.services.EngineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/engines")
public class EngineController {

    @Autowired
    private EngineService engineService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    ResponseEntity<EngineDto> createEngine(@Valid @RequestBody EngineDto newEngine) {
        Engine engine = modelMapper.map(newEngine, Engine.class);
        Engine createdEngine = engineService.saveEngine(engine);
        EngineDto mappedDto = modelMapper.map(createdEngine, EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<EngineDto> editEngineById(@Valid @RequestBody EngineDto engineDto, @PathVariable(value = "id") Long id) {
        Optional<Engine> optionalEngine = engineService.findById(id);
        if (optionalEngine.isEmpty()) {
            throw new EngineNotFoundException(id);
        }

        Engine engine = modelMapper.map(engineDto, Engine.class);
        engine.setId(id);
        Engine editedEngine = engineService.saveEngine(engine);
        EngineDto mappedEngine = modelMapper.map(editedEngine, EngineDto.class);
        return ResponseEntity.ok(mappedEngine);


    }

    @GetMapping("/{id}")
    ResponseEntity<EngineDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Engine> optionalEngine = engineService.findById(id);
        if (optionalEngine.isEmpty()) {
            throw new EngineNotFoundException(id);
        }
        EngineDto mappedDto = modelMapper.map(optionalEngine.get(), EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<EngineDto> deleteEngineById(@PathVariable(value = "id") Long id) {
        Optional<Engine> optionalEngine = engineService.findById(id);
        if (optionalEngine.isEmpty()) {
            throw new EngineNotFoundException(id);
        }
        engineService.deleteEngineById(id);
        EngineDto mappedDto = modelMapper.map(optionalEngine.get(), EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Engine> getEngines(Pageable pageable) {
        return engineService.findAll(pageable);
    }
}
