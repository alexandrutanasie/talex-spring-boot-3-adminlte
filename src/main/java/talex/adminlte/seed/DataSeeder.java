package talex.adminlte.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import talex.adminlte.entities.Role;
import talex.adminlte.entities.SiteUser;
import talex.adminlte.repositories.RoleRepository;
import talex.adminlte.repositories.SiteUserRepository;
import talex.adminlte.services.SiteUserService;



@Component
public class DataSeeder implements CommandLineRunner {

    
    private  SiteUserService siteUserService;
    private final SiteUserRepository siteUserRepository;
    private final RoleRepository siteUserRoleRepository;

    @Autowired
    public DataSeeder(SiteUserService siteUserService, SiteUserRepository siteUserRepository, RoleRepository siteUserRoleRepository) {
        this.siteUserService = siteUserService;
        this.siteUserRepository = siteUserRepository;
        this.siteUserRoleRepository = siteUserRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
        seedUsers();       
    }

    private void seedUsers() {
        if (siteUserRepository.findByEmail("demo@sapi.ro") == null) {

            SiteUser adminUser = new SiteUser();
            adminUser.setEmail("demo@sapi.ro");
            adminUser.setPassword("demo");

            siteUserService.saveUser(adminUser, "ROLE_ADMIN");
        }
    }
    private void seedRoles() {
        if (siteUserRoleRepository.findByName("ROLE_ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");          
            siteUserRoleRepository.save(adminRole);
        }
        if (siteUserRoleRepository.findByName("ROLE_USER") == null) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_USER");          
            siteUserRoleRepository.save(adminRole);
        }
    }
}
