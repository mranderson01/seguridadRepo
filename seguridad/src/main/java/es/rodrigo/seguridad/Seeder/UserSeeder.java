package es.rodrigo.seguridad.Seeder;


import es.rodrigo.seguridad.Repository.IRoleRepository;
import es.rodrigo.seguridad.Repository.IUserRepository;
import es.rodrigo.seguridad.security.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class UserSeeder   {

    @Autowired
    private final IUserRepository iUserRepository;
    @Autowired
    private final IRoleRepository rolRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserSeeder(es.rodrigo.seguridad.Repository.IUserRepository iUserRepository, IUserRepository iUserRepository1, IRoleRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.iUserRepository = iUserRepository1;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void run(String... args) throws Exception {

        //ROLES
        es.rodrigo.seguridad.Models.User.Role rolAdmin = rolRepository.findRoleByName("ROLE_ADMIN");
        if (rolAdmin == null) {
            rolAdmin = new es.rodrigo.seguridad.Models.User.Role();
            rolAdmin.setName("ROLE_ADMIN");
            rolRepository.save(rolAdmin);
        }

        es.rodrigo.seguridad.Models.User.Role rolManager = rolRepository.findRoleByName("ROLE_MANAGER");
        if (rolManager == null) {
            rolManager = new es.rodrigo.seguridad.Models.User.Role();
            rolManager.setName("ROLE_MANAGER");
            rolRepository.save(rolManager);
        }

        es.rodrigo.seguridad.Models.User.Role rolUser = rolRepository.findRoleByName("ROLE_USER");
        if (rolUser == null) {
            rolUser = new es.rodrigo.seguridad.Models.User.Role();
            rolUser.setName("ROLE_USER");
            rolRepository.save(rolUser);
        }

        //USERS
        Optional<User> usuarioAdmin = iUserRepository.findByUsername("admin@eviden.com");
        if (usuarioAdmin.isEmpty()) {
            User usuarioAdminn = new User();
            usuarioAdminn.setUsername("admin@eviden.com");
            usuarioAdminn.setFirstname("admin");
            usuarioAdminn.setPassword(passwordEncoder.encode("Asdf1234!"));
            rolRepository.save(rolAdmin);
        }

        Optional<User> usuarioPremium = iUserRepository.findByUsername("premium@eviden.com");
        if (usuarioPremium.isEmpty()) {
            User nuevopremiumm = new User();
            nuevopremiumm.setUsername("ROLE_PREMIUM");
            nuevopremiumm.setFirstname("admin");
            nuevopremiumm.setPassword(passwordEncoder.encode("Asdf1234!"));
            rolRepository.save(rolAdmin);
        }
        Optional<User> usuarioUser = iUserRepository.findByUsername("user@eviden.com");
        if (usuarioUser.isEmpty()) {
            User nuevoUserr = new User();
            nuevoUserr.setUsername("ROLE_USER");
            nuevoUserr.setFirstname("admin");
            nuevoUserr.setPassword(passwordEncoder.encode("Asdf1234!"));
            rolRepository.save(rolAdmin);
        }
    }
}
