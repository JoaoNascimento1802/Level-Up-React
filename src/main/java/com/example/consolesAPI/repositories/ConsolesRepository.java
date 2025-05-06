package com.example.consolesAPI.repositories;

import com.example.consolesAPI.entities.Consoles;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsolesRepository extends JpaRepository<Consoles, Long> {

}
