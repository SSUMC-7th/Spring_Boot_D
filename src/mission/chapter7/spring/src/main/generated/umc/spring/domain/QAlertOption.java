package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlertOption is a Querydsl query type for AlertOption
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlertOption extends EntityPathBase<AlertOption> {

    private static final long serialVersionUID = -745085755L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlertOption alertOption = new QAlertOption("alertOption");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.enums.AlertOptionDtype> dtype = createEnum("dtype", umc.spring.domain.enums.AlertOptionDtype.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QAlertOption(String variable) {
        this(AlertOption.class, forVariable(variable), INITS);
    }

    public QAlertOption(Path<? extends AlertOption> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlertOption(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlertOption(PathMetadata metadata, PathInits inits) {
        this(AlertOption.class, metadata, inits);
    }

    public QAlertOption(Class<? extends AlertOption> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

