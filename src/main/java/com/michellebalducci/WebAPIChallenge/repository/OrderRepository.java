package com.michellebalducci.WebAPIChallenge.repository;

import com.michellebalducci.WebAPIChallenge.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository <Order, UUID> {
}
