package io.github.leonardogit.domain.repository;

import io.github.leonardogit.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
