package io.github.leonardogit.domain.repository;

import io.github.leonardogit.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido,Integer> {
}
