package uz.pdp.lionestatebot.bot.service.model.faces;

import uz.pdp.lionestatebot.bot.models.entity.Session;


public interface SessionService {

    Session getOrCreateSession(Long userId);

    void save(Session session);

    Session saveReturn(Session session);
}
