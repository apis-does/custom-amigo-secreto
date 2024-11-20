package com.apisdo.amigosecreto.repositories.Interfaces;

import com.apisdo.amigosecreto.entities.SorteoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJugadorRepository extends JpaRepository<SorteoEntity, Integer> {

}
