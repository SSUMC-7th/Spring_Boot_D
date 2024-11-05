package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsermission is a Querydsl query type for Usermission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsermission extends EntityPathBase<Usermission> {

    private static final long serialVersionUID = -2103020033L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsermission usermission = new QUsermission("usermission");

    public final umc.study.domain.base.QBaseEntity _super = new umc.study.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QMission mission;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public final NumberPath<Long> usermission_id = createNumber("usermission_id", Long.class);

    public QUsermission(String variable) {
        this(Usermission.class, forVariable(variable), INITS);
    }

    public QUsermission(Path<? extends Usermission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsermission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsermission(PathMetadata metadata, PathInits inits) {
        this(Usermission.class, metadata, inits);
    }

    public QUsermission(Class<? extends Usermission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

