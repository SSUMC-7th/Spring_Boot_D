package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnswerToReview is a Querydsl query type for AnswerToReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnswerToReview extends EntityPathBase<AnswerToReview> {

    private static final long serialVersionUID = 928469085L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnswerToReview answerToReview = new QAnswerToReview("answerToReview");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QRestaurant restaurant;

    public final umc.spring.domain.QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAnswerToReview(String variable) {
        this(AnswerToReview.class, forVariable(variable), INITS);
    }

    public QAnswerToReview(Path<? extends AnswerToReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnswerToReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnswerToReview(PathMetadata metadata, PathInits inits) {
        this(AnswerToReview.class, metadata, inits);
    }

    public QAnswerToReview(Class<? extends AnswerToReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new umc.spring.domain.QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
        this.review = inits.isInitialized("review") ? new umc.spring.domain.QReview(forProperty("review"), inits.get("review")) : null;
    }

}

