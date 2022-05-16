package com.translate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLanguages is a Querydsl query type for Languages
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLanguages extends EntityPathBase<Languages> {

    private static final long serialVersionUID = 786464989L;

    public static final QLanguages languages = new QLanguages("languages");

    public final BooleanPath global = createBoolean("global");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath languageName = createString("languageName");

    public final StringPath locale = createString("locale");

    public QLanguages(String variable) {
        super(Languages.class, forVariable(variable));
    }

    public QLanguages(Path<? extends Languages> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLanguages(PathMetadata metadata) {
        super(Languages.class, metadata);
    }

}

