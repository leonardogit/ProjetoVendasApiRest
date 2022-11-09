package io.github.leonardogit.domain.repository;

import io.github.leonardogit.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido,Integer> {
}
