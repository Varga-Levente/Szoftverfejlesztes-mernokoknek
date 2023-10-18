package com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository;

import java.util.Optional;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.ERole;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
