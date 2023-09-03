package com.michellebalducci.WebAPIChallenge.repository;

import com.michellebalducci.WebAPIChallenge.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order,Integer> {
}
