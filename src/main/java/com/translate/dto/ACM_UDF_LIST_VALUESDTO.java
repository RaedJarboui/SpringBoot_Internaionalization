/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new acm udf list values.
 *
 * @param id                 the id
 * @param tableAbacusName    the table abacus name
 * @param idUDFList          the id UDF list
 * @param idUDFListValue     the id UDF list value
 * @param idUDFListLink      the id UDF list link
 * @param score              the score
 * @param name               the name
 * @param description        the description
 * @param acmEnabled         the acm enabled
 * @param date_insertion     the date insertion
 * @param insert_by          the insert by
 * @param date_last_update   the date last update
 * @param updated_by         the updated by
 * @param acmVersion         the acm version
 * @param parentUDFListValue the parent UDF list value
 */
@AllArgsConstructor

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data
public class ACM_UDF_LIST_VALUESDTO {

	/** The id. */
	@Getter
	@Setter
	public Long id;

	/** The table abacus name. */
	@Getter
	@Setter
	public String tableAbacusName;

	/** The id UDF list. */
	@Getter
	@Setter
	public Long idUDFList;

	/** The id UDF list value. */
	@Getter
	@Setter
	public Long idUDFListValue;

	/** The id UDF list link. */
	@Getter
	@Setter
	public Long idUDFListLink;

	/** The score. */
	@Getter
	@Setter
	public Long score;

	/** The name. */
	@Getter
	@Setter
	public String name;

	/** The description. */
	@Getter
	@Setter
	public String description;

	/** The acm enabled. */
	@Getter
	@Setter
	public Boolean acmEnabled;

	/** The date insertion. */
	@Getter
	@Setter
	public Date date_insertion;

	/** The insert by. */
	@Getter
	@Setter
	public String insert_by;

	/** The date last update. */
	@Getter
	@Setter
	public Date date_last_update;

	/** The updated by. */
	@Getter
	@Setter
	public String updated_by;

	/** The acm version. */
	@Getter
	@Setter
	public Long acmVersion;

	/** The parent UDF list value. */
	@Getter
	@Setter
	public Long parentUDFListValue;

	public ACM_UDF_LIST_VALUESDTO(Long id) {
		this.id = id;
	}

	public ACM_UDF_LIST_VALUESDTO() {
		// TODO Auto-generated constructor stub
	}

}
