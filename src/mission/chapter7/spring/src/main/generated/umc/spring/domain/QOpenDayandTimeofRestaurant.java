package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOpenDayandTimeofRestaurant is a Querydsl query type for OpenDayandTimeofRestaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOpenDayandTimeofRestaurant extends EntityPathBase<OpenDayandTimeofRestaurant> {

    private static final long serialVersionUID = 642296626L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOpenDayandTimeofRestaurant openDayandTimeofRestaurant = new QOpenDayandTimeofRestaurant("openDayandTimeofRestaurant");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final TimePath<java.time.LocalTime> closeTime = createTime("closeTime", java.time.LocalTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.enums.DayOfWeek> dayOfWeek = createEnum("dayOfWeek", umc.spring.domain.enums.DayOfWeek.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final TimePath<java.time.LocalTime> openTime = createTime("openTime", java.time.LocalTime.class);

    public final QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QOpenDayandTimeofRestaurant(String variable) {
        this(OpenDayandTimeofRestaurant.class, forVariable(variable), INITS);
    }

    public QOpenDayandTimeofRestaurant(Path<? extends OpenDayandTimeofRestaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOpenDayandTimeofRestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOpenDayandTimeofRestaurant(PathMetadata metadata, PathInits inits) {
        this(OpenDayandTimeofRestaurant.class, metadata, inits);
    }

    public QOpenDayandTimeofRestaurant(Class<? extends OpenDayandTimeofRestaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

