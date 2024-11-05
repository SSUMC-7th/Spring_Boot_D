package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission_point is a Querydsl query type for Mission_point
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission_point extends EntityPathBase<Mission_point> {

    private static final long serialVersionUID = -1097114565L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission_point mission_point = new QMission_point("mission_point");

    public final NumberPath<Long> amends_mission = createNumber("amends_mission", Long.class);

    public final NumberPath<Long> attainment_mission = createNumber("attainment_mission", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMission mission;

    public final QUser user;

    public QMission_point(String variable) {
        this(Mission_point.class, forVariable(variable), INITS);
    }

    public QMission_point(Path<? extends Mission_point> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission_point(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission_point(PathMetadata metadata, PathInits inits) {
        this(Mission_point.class, metadata, inits);
    }

    public QMission_point(Class<? extends Mission_point> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

