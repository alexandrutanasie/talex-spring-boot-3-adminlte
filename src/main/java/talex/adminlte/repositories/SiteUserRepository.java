package talex.adminlte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import talex.adminlte.entities.SiteUser;


public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    SiteUser findByEmail(String email);
}
