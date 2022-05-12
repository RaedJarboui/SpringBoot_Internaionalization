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
 * QTableList is a Querydsl query type for TableList
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTableList extends EntityPathBase<TableList> {

	private static final long serialVersionUID = 1574335054L;

	public static final QTableList tableList = new QTableList("tableList");

	public final NumberPath<Integer> id = createNumber("id", Integer.class);

	public final StringPath tableName = createString("tableName");

	public final BooleanPath translate = createBoolean("translate");

	public QTableList(String variable) {
		super(TableList.class, forVariable(variable));
	}

	public QTableList(Path<? extends TableList> path) {
		super(path.getType(), path.getMetadata());
	}

	public QTableList(PathMetadata metadata) {
		super(TableList.class, metadata);
	}

}
