package talex.adminlte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import talex.adminlte.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);    
}
