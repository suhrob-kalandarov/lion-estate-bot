package uz.pdp.lionestatebot.bot.process.callback;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.*;
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
public class RentHomeService implements BiConsumer<CallbackQuery, Session> {

    private final BotMessageSender botMessageSender;
    private final InlineButtonService inlineButtonService;
    private final SessionService sessionService;
    private final BotEditMessageSender botEditMessageSender;
    private final ReplyButtonService replyButtonService;

    @Override
    public void accept(CallbackQuery callbackQuery, Session session) {
        String data = callbackQuery.data();
        Language language = session.getLanguage();
        Long userId = session.getUserId();
        Integer messageId = session.getMessageId();


        if (data.equals(Messages.APARTMENT_BTN.name())) {
            session.setPropertyCategory(PropertyCategory.APARTMENT);
            botEditMessageSender.editMessage(userId, messageId, Messages.PROFILE_MENU_MSG.get(language), inlineButtonService.apartmentBtns(language));

        } else if (data.equals(Messages.FAMILY_BTN.name())) {
            session.setProfileType(ProfileType.FAMILY);
            botEditMessageSender.editMessage(userId, messageId, Messages.CITIZENSHIP_MENU_MSG.get(language), inlineButtonService.citizenshipBtns(language));

        } else if (data.equals(Messages.STUDENT_BTN.name())) {
            session.setProfileType(ProfileType.STUDENT);
            botEditMessageSender.editMessage(userId, messageId, Messages.CITIZENSHIP_MENU_MSG.get(language), inlineButtonService.citizenshipBtns(language));

        } else if (data.equals(Messages.SINGLE_BTN.name())) {
            session.setProfileType(ProfileType.SINGLE);
            botEditMessageSender.editMessage(userId, messageId, Messages.CITIZENSHIP_MENU_MSG.get(language), inlineButtonService.citizenshipBtns(language));

        } else if (data.equals(Messages.LOCAL_BTN.name())) {
            session.setCitizenship(Citizenship.LOCAL);
            botEditMessageSender.editMessage(userId, messageId, Messages.REGION_MENU_MSG.get(language), inlineButtonService.regionsBtn(language));

        } else if (data.equals(Messages.FOREIGNER_BTN.name())) {
            session.setCitizenship(Citizenship.FOREIGNER);
            botEditMessageSender.editMessage(userId, messageId, Messages.REGION_MENU_MSG.get(language), inlineButtonService.regionsBtn(language));

        } else if (data.startsWith("region_")) {
            data = data.replace("region_", "");
            session.setRegion(data);
            botEditMessageSender.editMessage(userId, messageId, Messages.RENOVATION_MENU_MSG.get(language), inlineButtonService.renovationBtns(language));

        } else if (data.equals(Messages.EURO_RE_BTN.name())) {
            session.setRenovation(Renovation.EURO);
            botEditMessageSender.editMessage(userId, messageId, Messages.BUDGET_MENU_MSG.get(language), inlineButtonService.costBtns(language));

        } else if (data.equals(Messages.MINIMALISM_RE_BTN.name())) {
            session.setRenovation(Renovation.MINIMALISM);
            botEditMessageSender.editMessage(userId, messageId, Messages.BUDGET_MENU_MSG.get(language), inlineButtonService.costBtns(language));

        } else if (data.equals(Messages.SIMPLE_RE_BTN.name())) {
            session.setRenovation(Renovation.SIMPLE);
            botEditMessageSender.editMessage(userId, messageId, Messages.BUDGET_MENU_MSG.get(language), inlineButtonService.costBtns(language));

        } else if (data.equals(Messages.HIGHTECH_RE_BTN.name())) {
            session.setRenovation(Renovation.HIGH_TECH);
            botEditMessageSender.editMessage(userId, messageId, Messages.BUDGET_MENU_MSG.get(language), inlineButtonService.costBtns(language));

        } else if (data.startsWith("cost_")) {
            data = data.replace("cost_", "");
            session.setCost(data);
            botEditMessageSender.editMessage(userId, messageId, Messages.FLOOR_MENU_MSG.get(language), inlineButtonService.floorBtns(language));

        } else if (data.startsWith("floor_")) {
            data = data.replace("floor_", "");
            session.setFloor(Integer.parseInt(data));
            botEditMessageSender.editMessage(userId, messageId, Messages.ROOM_COUNT_MENU_MSG.get(language), inlineButtonService.roomCountBtns(language));

        } else if (data.startsWith("room_")) {
            data = data.replace("room_", "");
            session.setRoom(Integer.parseInt(data));
            botEditMessageSender.editMessage(userId, messageId, Messages.PROPERTY_TYPE_MENU_MSG.get(language), inlineButtonService.propertyTypeBtns(language));

        } else if (data.equals(Messages.NEW_BUILDING_BTN.name())) {
            session.setPropertyType(PropertyType.NEW_BUILDING);
            botEditMessageSender.editMessage(userId, messageId,
                    Messages.FULL_INFO_MSG.get(language).formatted(
                            session.getPropertyCategory(),
                            session.getProfileType(),
                            session.getCitizenship(),
                            session.getRegion(),
                            session.getRenovation(),
                            session.getCost(),
                            session.getFloor(),
                            session.getRoom(),
                            session.getPropertyType()
                    ));
            botMessageSender.sendMarkupMessage(userId, Messages.NOT_FOUND_APT_MSG.get(language), replyButtonService.homeBtns(language));
            session.setState(SessionState.HOME_MENU);

        } else if (data.equals(Messages.OLD_BUILDING_BTN.name())) {
            session.setPropertyType(PropertyType.OLD_BUILDING);
            botEditMessageSender.editMessage(userId, messageId,
                    Messages.FULL_INFO_MSG.get(language).formatted(
                            session.getPropertyCategory(),
                            session.getProfileType(),
                            session.getCitizenship(),
                            session.getRegion(),
                            session.getRenovation(),
                            session.getCost(),
                            session.getFloor(),
                            session.getRoom(),
                            session.getPropertyType()
                    ));
            botMessageSender.sendMarkupMessage(userId, Messages.NOT_FOUND_APT_MSG.get(language), replyButtonService.homeBtns(language));
            session.setState(SessionState.HOME_MENU);

        } else if (data.equals(Messages.OFFICE_BTN.name())) {
            session.setPropertyCategory(PropertyCategory.OFFICE);

        } else if (data.equals(Messages.NON_RES_BTN.name())) {

        }
        sessionService.save(session);
    }

    public void sendMenu(Session session) {
        Long userId = session.getUserId();
        Language language = session.getLanguage();

        SendResponse sendResponse = botMessageSender.sendInlineMarkupMessage(userId, Messages.RENT_MENU_MSG.get(language), inlineButtonService.rentBtns(language));
        session.setMessageId(sendResponse.message().messageId());
        session.setState(SessionState.RENT_MENU);
        sessionService.save(session);
    }
}
