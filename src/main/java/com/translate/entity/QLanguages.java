/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QLanguages is a Querydsl query type for Languages.
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLanguages extends EntityPathBase<Languages> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 786464989L;

	/** The Constant languages. */
	public static final QLanguages languages = new QLanguages("languages");

	/** The global. */
	public final BooleanPath global = createBoolean("global");

	/** The id. */
	public final NumberPath<Integer> id = createNumber("id", Integer.class);

	/** The language name. */
	public final StringPath languageName = createString("languageName");

	/** The locale. */
	public final StringPath locale = createString("locale");

	/**
	 * Instantiates a new q languages.
	 *
	 * @param variable the variable
	 */
	public QLanguages(String variable) {
		super(Languages.class, forVariable(variable));
	}

	/**
	 * Instantiates a new q languages.
	 *
	 * @param path the path
	 */
	public QLanguages(Path<? extends Languages> path) {
		super(path.getType(), path.getMetadata());
	}

	/**
	 * Instantiates a new q languages.
	 *
	 * @param metadata the metadata
	 */
	public QLanguages(PathMetadata metadata) {
		super(Languages.class, metadata);
	}

}
