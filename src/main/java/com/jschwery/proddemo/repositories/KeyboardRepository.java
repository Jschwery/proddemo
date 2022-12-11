package com.jschwery.proddemo.repositories;

import com.jschwery.proddemo.entities.Keyboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {
}
