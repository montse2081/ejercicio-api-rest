package com.liverpool.catalogo.domain.repository;

import com.liverpool.catalogo.domain.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, String> {
}
