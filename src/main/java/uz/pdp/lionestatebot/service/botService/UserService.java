package uz.pdp.lionestatebot.service.botService;


import uz.pdp.lionestatebot.models.entity.UserEntity;
import uz.pdp.lionestatebot.models.enums.Language;
import uz.pdp.lionestatebot.models.enums.UserRole;
import uz.pdp.lionestatebot.models.enums.UserState;
import uz.pdp.lionestatebot.models.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity registerOrGetUser(Long chatId, String fullName) {
        return userRepository.findById(chatId).orElseGet(() -> {
            UserEntity user = new UserEntity();
            user.setChatId(chatId);
            user.setFullName(fullName);
            user.setLanguage(Language.UZ); // default
            user.setRole(UserRole.USER);
            user.setActive(true);
            user.setCreatedAt(LocalDateTime.now());
            return userRepository.save(user);
        });
    }

    public void updateLanguage(Long chatId, Language language) {
        userRepository.findById(chatId).ifPresent(user -> {
            user.setLanguage(language);
            userRepository.save(user);
        });
    }

    public Language getUserLanguage(Long chatId) {
        return userRepository.findByChatId(chatId).
                map(UserEntity::getLanguage).
                orElse(Language.UZ); // Default: UZ
    }

    public void updateUserState(Long chatId, UserState state) {
        Optional<UserEntity> optionalUser = userRepository.findById(chatId);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            user.setState(state);
            userRepository.save(user);
        }


    }

}