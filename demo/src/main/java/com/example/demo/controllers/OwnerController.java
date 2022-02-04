package com.example.demo.controllers;

import com.example.demo.dtos.EngineDto;
import com.example.demo.dtos.OwnerDto;
import com.example.demo.exceptions.EngineNotFoundException;
import com.example.demo.exceptions.OwnerNotFoundException;
import com.example.demo.models.Engine;
import com.example.demo.models.Owner;
import com.example.demo.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    ResponseEntity<OwnerDto> createOwner(@Valid @RequestBody OwnerDto newOwner) {
        Owner owner = modelMapper.map(newOwner, Owner.class);
        Owner createdOwner = ownerService.saveOwner(owner);
        OwnerDto mappedDto = modelMapper.map(createdOwner, OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<OwnerDto> editOwnerById(@Valid @RequestBody OwnerDto ownerDto, @PathVariable(value = "id") Long id) {
        Optional<Owner> optionalOwner = ownerService.findById(id);
        if (optionalOwner.isEmpty()) {
            throw new OwnerNotFoundException(id);
        }

        Owner owner = modelMapper.map(ownerDto, Owner.class);
        owner.setId(id);
        Owner editedOwner = ownerService.saveOwner(owner);
        OwnerDto mappedOwner = modelMapper.map(editedOwner, OwnerDto.class);
        return ResponseEntity.ok(mappedOwner);
    }

    @GetMapping("/{id}")
    ResponseEntity<OwnerDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Owner> optionalOwner = ownerService.findById(id);
        if (optionalOwner.isEmpty()) {
            throw new OwnerNotFoundException(id);
        }
        OwnerDto mappedDto = modelMapper.map(optionalOwner.get(), OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<OwnerDto> deleteOwnerById(@PathVariable(value = "id") Long id) {
        Optional<Owner> optionalOwner = ownerService.findById(id);
        if (optionalOwner.isEmpty()) {
            throw new OwnerNotFoundException(id);
        }
        ownerService.deleteOwnerById(id);
        OwnerDto mappedDto = modelMapper.map(optionalOwner.get(), OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Owner> getOwners(Pageable pageable) {
        return ownerService.findAll(pageable);
    }
}
