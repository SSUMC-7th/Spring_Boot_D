package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiry is a Querydsl query type for Inquiry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiry extends EntityPathBase<Inquiry> {

    private static final long serialVersionUID = 175846245L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiry inquiry = new QInquiry("inquiry");

    public final umc.study.domain.base.QBaseEntity _super = new umc.study.domain.base.QBaseEntity(this);

    public final EnumPath<umc.study.domain.enums.Attainment_Mission> attainmentMission = createEnum("attainmentMission", umc.study.domain.enums.Attainment_Mission.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath details = createString("details");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<umc.study.domain.enums.AttachPhoto> photo = createEnum("photo", umc.study.domain.enums.AttachPhoto.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QInquiry(String variable) {
        this(Inquiry.class, forVariable(variable), INITS);
    }

    public QInquiry(Path<? extends Inquiry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiry(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiry(PathMetadata metadata, PathInits inits) {
        this(Inquiry.class, metadata, inits);
    }

    public QInquiry(Class<? extends Inquiry> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

