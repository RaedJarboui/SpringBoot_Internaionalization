package com.translate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSuggestion is a Querydsl query type for Suggestion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSuggestion extends EntityPathBase<Suggestion> {

    private static final long serialVersionUID = -15189630L;

    public static final QSuggestion suggestion = new QSuggestion("suggestion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath text = createString("text");

    public QSuggestion(String variable) {
        super(Suggestion.class, forVariable(variable));
    }

    public QSuggestion(Path<? extends Suggestion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSuggestion(PathMetadata metadata) {
        super(Suggestion.class, metadata);
    }

}

