package uz.pdp.lionestatebot.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.admin.entity.Admin;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    @Override
    public Admin getByUsername(String username) {
        return (Admin) adminRepository.findByUsername(username);
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }
}
