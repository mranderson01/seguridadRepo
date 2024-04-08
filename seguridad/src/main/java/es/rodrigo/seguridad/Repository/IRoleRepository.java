package es.rodrigo.seguridad.Repository;

import es.rodrigo.seguridad.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<User.Role,Integer> {
    User.Role findRoleByName(String roleAdmin);
}