package uz.pdp.lionestatebot.admin.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.admin.entity.Admin;
import uz.pdp.lionestatebot.admin.service.AdminService;

@Service
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        Admin admin = Admin.builder()
                .username("admin")
                .password(passwordEncoder.encode("1234"))
                ._active(true)
                .build();
        adminService.save(admin);
    }
}
