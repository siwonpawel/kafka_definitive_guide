package com.github.siwonpawel.kafka.data.customdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomDataRepository extends JpaRepository<CustomData, Long>
{
}
