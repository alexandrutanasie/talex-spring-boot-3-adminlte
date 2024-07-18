package talex.adminlte.services;

import talex.adminlte.entities.SiteUser;

public interface SiteUserService {
    SiteUser findByEmail(String email);
    void saveUser(SiteUser user, String role);
}
