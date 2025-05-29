package uz.pdp.lionestatebot.bot.service.model.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.repositories.SessionRepository;
import uz.pdp.lionestatebot.bot.service.model.faces.SessionService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Session getOrCreateSession(Long userId) {
        Optional<Session> optionalSession = sessionRepository.findById(userId);
        return optionalSession.orElseGet(() -> createAndSaveSession(userId));
    }

    private Session createAndSaveSession(Long userId) {
        Session session = Session.builder()
                .userId(userId)
                ._active(true)
                .language(Language.uz)
                .state(SessionState.START)
                .build();
        return saveReturn(session);
    }

    @Override
    public Session saveReturn(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void save(Session session) {
        sessionRepository.save(session);
    }
}
