package com.example.demo.services;

import com.example.demo.models.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OwnerService {

    Owner saveOwner(Owner owner);

    Owner editOwner(Owner owner);

    Optional<Owner> findById(Long id);

    void deleteOwnerById(Long id);

    Page<Owner> findAll(Pageable pageable);
}
