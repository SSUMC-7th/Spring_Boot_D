package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnswerToInquiry is a Querydsl query type for AnswerToInquiry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnswerToInquiry extends EntityPathBase<AnswerToInquiry> {

    private static final long serialVersionUID = 1969351298L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnswerToInquiry answerToInquiry = new QAnswerToInquiry("answerToInquiry");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QInquiry inquiry;

    public final ListPath<InquiryAnswerImage, QInquiryAnswerImage> inquiryAnswerImageList = this.<InquiryAnswerImage, QInquiryAnswerImage>createList("inquiryAnswerImageList", InquiryAnswerImage.class, QInquiryAnswerImage.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAnswerToInquiry(String variable) {
        this(AnswerToInquiry.class, forVariable(variable), INITS);
    }

    public QAnswerToInquiry(Path<? extends AnswerToInquiry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnswerToInquiry(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnswerToInquiry(PathMetadata metadata, PathInits inits) {
        this(AnswerToInquiry.class, metadata, inits);
    }

    public QAnswerToInquiry(Class<? extends AnswerToInquiry> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiry = inits.isInitialized("inquiry") ? new QInquiry(forProperty("inquiry"), inits.get("inquiry")) : null;
    }

}

