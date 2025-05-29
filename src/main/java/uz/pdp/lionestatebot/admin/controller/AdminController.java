package uz.pdp.lionestatebot.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lionestatebot.admin.dto.AdminRequest;
import uz.pdp.lionestatebot.admin.dto.AdminResponse;
import uz.pdp.lionestatebot.admin.service.AdminServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminServiceImpl adminService;
    //private final PropertyService propertyService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminRequest loginReq) {
        //return adminService.login(loginReq);
        return null;
    }

    @GetMapping("/me")
    public ResponseEntity<AdminResponse> getProfile(Principal principal) {
        //return ResponseEntity.ok(adminService.getProfile(principal));
        return null;
    }

    /*@PostMapping("/property")
    public ResponseEntity<?> createProperty(@RequestBody PropertyDto dto, Principal principal) {
        return ResponseEntity.ok(propertyService.create(dto, principal));
    }

    @GetMapping("/property")
    public ResponseEntity<List<PropertyDto>> getAll() {
        return ResponseEntity.ok(propertyService.getAll());
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        propertyService.delete(id);
        return ResponseEntity.ok("Deleted");
    }*/
}
