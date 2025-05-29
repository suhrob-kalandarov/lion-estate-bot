package uz.pdp.lionestatebot.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lionestatebot.admin.entity.Admin;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findByUsername(String username);
}
