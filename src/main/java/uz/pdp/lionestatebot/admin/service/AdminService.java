package uz.pdp.lionestatebot.admin.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.admin.dto.AdminRequest;
import uz.pdp.lionestatebot.admin.dto.AdminResponse;

import java.security.Principal;

@Service
public class AdminService {
    public ResponseEntity<?> login(AdminRequest loginReq) {
        return null;
    }

    public AdminResponse getProfile(Principal principal) {
        return null;
    }
}
