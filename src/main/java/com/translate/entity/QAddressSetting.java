package com.translate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddressSetting is a Querydsl query type for AddressSetting
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddressSetting extends EntityPathBase<AddressSetting> {

    private static final long serialVersionUID = 1874784314L;

    public static final QAddressSetting addressSetting = new QAddressSetting("addressSetting");

    public final NumberPath<Long> addressListId = createNumber("addressListId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath idExtern = createString("idExtern");

    public final NumberPath<Long> parentId = createNumber("parentId", Long.class);

    public final StringPath tableAbacusName = createString("tableAbacusName");

    public final StringPath valueJson = createString("valueJson");

    public QAddressSetting(String variable) {
        super(AddressSetting.class, forVariable(variable));
    }

    public QAddressSetting(Path<? extends AddressSetting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddressSetting(PathMetadata metadata) {
        super(AddressSetting.class, metadata);
    }

}

