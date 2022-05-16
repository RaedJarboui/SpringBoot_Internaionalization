package com.translate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranslation is a Querydsl query type for Translation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTranslation extends EntityPathBase<Translation> {

    private static final long serialVersionUID = -786205965L;

    public static final QTranslation translation = new QTranslation("translation");

    public final StringPath fieldValue = createString("fieldValue");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name_table = createString("name_table");

    public final StringPath selectedColumn = createString("selectedColumn");

    public final ListPath<Langues, SimplePath<Langues>> translations = this.<Langues, SimplePath<Langues>>createList("translations", Langues.class, SimplePath.class, PathInits.DIRECT2);

    public QTranslation(String variable) {
        super(Translation.class, forVariable(variable));
    }

    public QTranslation(Path<? extends Translation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTranslation(PathMetadata metadata) {
        super(Translation.class, metadata);
    }

}

