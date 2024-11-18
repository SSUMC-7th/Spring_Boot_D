package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = 1563043049L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<umc.spring.domain.mapping.AnswerToReview, umc.spring.domain.mapping.QAnswerToReview> answerToReviewList = this.<umc.spring.domain.mapping.AnswerToReview, umc.spring.domain.mapping.QAnswerToReview>createList("answerToReviewList", umc.spring.domain.mapping.AnswerToReview.class, umc.spring.domain.mapping.QAnswerToReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.RestaurantCategory> category = createEnum("category", umc.spring.domain.enums.RestaurantCategory.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Mission, QMission> missionList = this.<Mission, QMission>createList("missionList", Mission.class, QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<OpenDayandTimeofRestaurant, QOpenDayandTimeofRestaurant> openDayandTimeofRestaurantList = this.<OpenDayandTimeofRestaurant, QOpenDayandTimeofRestaurant>createList("openDayandTimeofRestaurantList", OpenDayandTimeofRestaurant.class, QOpenDayandTimeofRestaurant.class, PathInits.DIRECT2);

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final QRegion region;

    public final ListPath<RestaurantImage, QRestaurantImage> restaurantImageList = this.<RestaurantImage, QRestaurantImage>createList("restaurantImageList", RestaurantImage.class, QRestaurantImage.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRestaurant(String variable) {
        this(Restaurant.class, forVariable(variable), INITS);
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurant(PathMetadata metadata, PathInits inits) {
        this(Restaurant.class, metadata, inits);
    }

    public QRestaurant(Class<? extends Restaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

