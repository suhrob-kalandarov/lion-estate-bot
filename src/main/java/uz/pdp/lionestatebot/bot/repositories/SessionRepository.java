package uz.pdp.lionestatebot.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lionestatebot.bot.models.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

}
