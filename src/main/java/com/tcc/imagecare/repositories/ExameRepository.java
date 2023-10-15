package com.tcc.imagecare.repositories;

import com.tcc.imagecare.models.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {
}
