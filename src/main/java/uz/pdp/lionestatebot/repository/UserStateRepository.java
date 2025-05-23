package uz.pdp.lionestatebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lionestatebot.models.entity.UserState;

public interface UserStateRepository extends JpaRepository<UserState, Long> {}

