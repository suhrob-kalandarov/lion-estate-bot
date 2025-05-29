package uz.pdp.lionestatebot.bot.service.model.impl;

import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.User;
import uz.pdp.lionestatebot.bot.repositories.UserRepository;
import uz.pdp.lionestatebot.bot.service.model.faces.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Async
    @Override
    public void createUser(Message message) {
        Long userId = message.from().id();
        String fullName = buildFullName(message);
        String username = message.from().username();

        userRepository.save(
                User.builder()
                        .id(userId)
                        .fullName(fullName)
                        .username(username)
                        ._active(true)
                        .isAdmin(false)
                        .build()
        );
    }

    private String buildFullName(Message message) {
        String firstName = message.chat().firstName();
        String lastName = message.chat().lastName();

        if (lastName == null) return firstName;

        return firstName + " " + lastName;
    }
}
