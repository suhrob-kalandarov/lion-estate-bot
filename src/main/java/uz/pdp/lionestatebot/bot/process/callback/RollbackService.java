package uz.pdp.lionestatebot.bot.process.callback;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.service.button.InlineButtonService;
import uz.pdp.lionestatebot.bot.service.button.ReplyButtonService;
import uz.pdp.lionestatebot.bot.service.execute.BotEditMessageSender;
import uz.pdp.lionestatebot.bot.service.execute.BotMessageSender;
import uz.pdp.lionestatebot.bot.service.message.Messages;
import uz.pdp.lionestatebot.bot.service.model.faces.SessionService;

import java.util.function.BiConsumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class RollbackService implements BiConsumer<CallbackQuery, Session> {


    private final BotEditMessageSender botEditMessageSender;
    private final BotMessageSender botMessageSender;
    private final ReplyButtonService replyButtonService;
    private final SessionService sessionService;
    private final InlineButtonService inlineButtonService;

    @Override
    public void accept(CallbackQuery callbackQuery, Session session) {
        String data = callbackQuery.data();
        Long userId = session.getUserId();
        Integer messageId = session.getMessageId();
        Language language = session.getLanguage();

        switch (data) {
            case "back_to_home_from_about_us" -> {
                botEditMessageSender.editMessage(
                        userId,
                        messageId,
                        Messages.BACK_TO_ABOUT_US_MSG.get(session.getLanguage())
                );
                botMessageSender.sendMarkupMessage(
                        userId,
                        Messages.CHOOSE_MENU_MSG.get(session.getLanguage()),
                        replyButtonService.homeBtns(session.getLanguage())
                );
                session.setState(SessionState.HOME_MENU);
            }
            case "back_to_home_from_rent" -> {
                botEditMessageSender.editMessage(
                        userId,
                        messageId,
                        "↩"
                );
                botMessageSender.sendMarkupMessage(
                        userId,
                        Messages.CHOOSE_MENU_MSG.get(session.getLanguage()),
                        replyButtonService.homeBtns(session.getLanguage())
                );
                session.setState(SessionState.HOME_MENU);
            }
            case "back_to_rent_type_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.RENT_MENU_MSG.get(language),
                        inlineButtonService.rentBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_resident_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.PROFILE_MENU_MSG.get(language),
                        inlineButtonService.apartmentBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_citizenship_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.CITIZENSHIP_MENU_MSG.get(language),
                        inlineButtonService.citizenshipBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_regions_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.REGION_MENU_MSG.get(language),
                        inlineButtonService.regionsBtn(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_renovation_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.RENOVATION_MENU_MSG.get(language),
                        inlineButtonService.renovationBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_costs_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.BUDGET_MENU_MSG.get(language),
                        inlineButtonService.costBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_floor_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.FLOOR_MENU_MSG.get(language),
                        inlineButtonService.floorBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_rooms_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.ROOM_COUNT_MENU_MSG.get(language),
                        inlineButtonService.roomCountBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_property_type_btns" -> {
                SendResponse sendResponse = botEditMessageSender.editMessage(
                        userId, messageId,
                        Messages.PROPERTY_TYPE_MENU_MSG.get(language),
                        inlineButtonService.propertyTypeBtns(language)
                );
                session.setMessageId(sendResponse.message().messageId());
                session.setState(SessionState.RENT_MENU);

            }
            case "back_to_?" -> {

            }
            default -> {}
        }

        sessionService.save(session);
    }
}
