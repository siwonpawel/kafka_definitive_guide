package com.github.siwonpawel.kafka.data.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<CustomData, Long>
{
}
