package uz.pdp.lionestatebot.bot.models.entity.ext;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.admin.entity.Admin;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.entity.PropertyCategory;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "request_properties")
public class RequestProperty extends BaseEntity {
    private String type; // "arenda", "sale", "office", "commercial"
    private String remont; // "evro", "minimalism", "haytek", "oddiy"
    private String houseType; // "novostroyka", "vtorychka"
    private Boolean forForeigners;

    private String title;
    private String region;
    private String address;
    private String orienter;

    private Integer room;
    private Integer floor;
    private Integer floors;

    private Double area; // m2
    private String prepayment;
    private String deposit;
    private Double price; // USD

    @Enumerated(EnumType.STRING)
    private PropertyCategory category;

    @ManyToOne
    private Session session;

    /**
      •ID 11424 Жавлон

      •Район: Юнусабадский
      •Адрес: 13 квартал
      •Орентир: Анжир Милий Таомлар

      •Комнат: 2
      •Этаж: 3
      •Этажность: 4
      •Площадь: 80 м2
      •Передаплата: Нет
      •Депозит: нет
      •Цена: 600 y.e/ месяц

      Ещё больше вариантов у нас на канале. Переходите по ссылке https://t.me/LIION_Estate
     */
}
