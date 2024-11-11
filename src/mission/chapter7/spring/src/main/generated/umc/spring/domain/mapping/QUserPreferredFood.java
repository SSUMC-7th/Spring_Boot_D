package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPreferredFood is a Querydsl query type for UserPreferredFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPreferredFood extends EntityPathBase<UserPreferredFood> {

    private static final long serialVersionUID = -1536506328L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPreferredFood userPreferredFood = new QUserPreferredFood("userPreferredFood");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.QUser user;

    public QUserPreferredFood(String variable) {
        this(UserPreferredFood.class, forVariable(variable), INITS);
    }

    public QUserPreferredFood(Path<? extends UserPreferredFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPreferredFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPreferredFood(PathMetadata metadata, PathInits inits) {
        this(UserPreferredFood.class, metadata, inits);
    }

    public QUserPreferredFood(Class<? extends UserPreferredFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.QUser(forProperty("user")) : null;
    }

}

