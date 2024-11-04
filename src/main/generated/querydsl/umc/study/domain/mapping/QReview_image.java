package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview_image is a Querydsl query type for Review_image
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview_image extends EntityPathBase<Review_image> {

    private static final long serialVersionUID = 468437718L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview_image review_image = new QReview_image("review_image");

    public final umc.study.domain.base.QBaseEntity _super = new umc.study.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QReview_image(String variable) {
        this(Review_image.class, forVariable(variable), INITS);
    }

    public QReview_image(Path<? extends Review_image> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview_image(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview_image(PathMetadata metadata, PathInits inits) {
        this(Review_image.class, metadata, inits);
    }

    public QReview_image(Class<? extends Review_image> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

