package uz.pdp.lionestatebot.admin.service;

import uz.pdp.lionestatebot.admin.entity.Admin;

public interface AdminService {

    Admin getByUsername(String username);

    void save(Admin admin);
}
