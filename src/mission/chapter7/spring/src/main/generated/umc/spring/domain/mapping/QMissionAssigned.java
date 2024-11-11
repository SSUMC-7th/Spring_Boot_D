package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionAssigned is a Querydsl query type for MissionAssigned
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionAssigned extends EntityPathBase<MissionAssigned> {

    private static final long serialVersionUID = 634216494L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionAssigned missionAssigned = new QMissionAssigned("missionAssigned");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isCompleted = createBoolean("isCompleted");

    public final umc.spring.domain.QMission mission;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.QUser user;

    public QMissionAssigned(String variable) {
        this(MissionAssigned.class, forVariable(variable), INITS);
    }

    public QMissionAssigned(Path<? extends MissionAssigned> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionAssigned(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionAssigned(PathMetadata metadata, PathInits inits) {
        this(MissionAssigned.class, metadata, inits);
    }

    public QMissionAssigned(Class<? extends MissionAssigned> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new umc.spring.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.QUser(forProperty("user")) : null;
    }

}

