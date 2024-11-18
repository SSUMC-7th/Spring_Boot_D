package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryAnswerImage is a Querydsl query type for InquiryAnswerImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryAnswerImage extends EntityPathBase<InquiryAnswerImage> {

    private static final long serialVersionUID = -532276830L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryAnswerImage inquiryAnswerImage = new QInquiryAnswerImage("inquiryAnswerImage");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final QAnswerToInquiry answerToInquiry;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QInquiryAnswerImage(String variable) {
        this(InquiryAnswerImage.class, forVariable(variable), INITS);
    }

    public QInquiryAnswerImage(Path<? extends InquiryAnswerImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryAnswerImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryAnswerImage(PathMetadata metadata, PathInits inits) {
        this(InquiryAnswerImage.class, metadata, inits);
    }

    public QInquiryAnswerImage(Class<? extends InquiryAnswerImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.answerToInquiry = inits.isInitialized("answerToInquiry") ? new QAnswerToInquiry(forProperty("answerToInquiry"), inits.get("answerToInquiry")) : null;
    }

}

