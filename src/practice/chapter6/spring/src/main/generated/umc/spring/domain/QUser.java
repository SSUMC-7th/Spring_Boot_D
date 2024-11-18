package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1348045193L;

    public static final QUser user = new QUser("user");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<Alarm, QAlarm> alarmList = this.<Alarm, QAlarm>createList("alarmList", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final ListPath<AlertOption, QAlertOption> alertOptionList = this.<AlertOption, QAlertOption>createList("alertOptionList", AlertOption.class, QAlertOption.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> dateOfBirth = createDate("dateOfBirth", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MissionAssigned, umc.spring.domain.mapping.QMissionAssigned> missionAssignedList = this.<umc.spring.domain.mapping.MissionAssigned, umc.spring.domain.mapping.QMissionAssigned>createList("missionAssignedList", umc.spring.domain.mapping.MissionAssigned.class, umc.spring.domain.mapping.QMissionAssigned.class, PathInits.DIRECT2);

    public final StringPath nickname = createString("nickname");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.SocialType> socialType = createEnum("socialType", umc.spring.domain.enums.SocialType.class);

    public final EnumPath<umc.spring.domain.enums.UserStatus> status = createEnum("status", umc.spring.domain.enums.UserStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.domain.mapping.UserPreferredFood, umc.spring.domain.mapping.QUserPreferredFood> userPreferredFoodList = this.<umc.spring.domain.mapping.UserPreferredFood, umc.spring.domain.mapping.QUserPreferredFood>createList("userPreferredFoodList", umc.spring.domain.mapping.UserPreferredFood.class, umc.spring.domain.mapping.QUserPreferredFood.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.UserTerms, umc.spring.domain.mapping.QUserTerms> userTermsList = this.<umc.spring.domain.mapping.UserTerms, umc.spring.domain.mapping.QUserTerms>createList("userTermsList", umc.spring.domain.mapping.UserTerms.class, umc.spring.domain.mapping.QUserTerms.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

