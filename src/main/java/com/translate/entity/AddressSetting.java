package com.translate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACM_ADDRESS_SETTING")
public class AddressSetting implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3728611702590212165L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_ADDRESS_SETTING", unique = true, nullable = false)
	private Long id;

	/** The parent id. */
	@Column(name = "PARENT_ID")
	private Long parentId;

	/** The adress list id. */
	@Column(name = "ID_ADDRESS_LIST")
	private Long addressListId;

	/** The table abacus name. */
	@Column(name = "TABLE_ABACUS_NAME", length = 512)
	private String tableAbacusName;

	/** The id extern. */
	@Column(name = "ID_EXTERN", length = 256, nullable = false)
	private String idExtern;

	/** The value json. */
	@Column(name = "VALUE_JSON")
	private String valueJson;

	/**
	 * Instantiates a new address setting.
	 */
	public AddressSetting() {

		/*
		 * 
		 */
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * Gets the parent id.
	 *
	 * @return the parentId
	 */
	public Long getParentId() {

		return parentId;
	}

	/**
	 * Sets the parent id.
	 *
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {

		this.parentId = parentId;
	}

	/**
	 * Gets the table abacus name.
	 *
	 * @return the tableAbacusName
	 */
	public String getTableAbacusName() {

		return tableAbacusName;
	}

	/**
	 * Sets the table abacus name.
	 *
	 * @param tableAbacusName the tableAbacusName to set
	 */
	public void setTableAbacusName(String tableAbacusName) {

		this.tableAbacusName = tableAbacusName;
	}

	/**
	 * Gets the id extern.
	 *
	 * @return the idExtern
	 */
	public String getIdExtern() {

		return idExtern;
	}

	/**
	 * Sets the id extern.
	 *
	 * @param idExtern the idExtern to set
	 */
	public void setIdExtern(String idExtern) {

		this.idExtern = idExtern;
	}

	/**
	 * Gets the value json.
	 *
	 * @return the valueJson
	 */
	public String getValueJson() {

		return valueJson;
	}

	/**
	 * Sets the value json.
	 *
	 * @param valueJson the valueJson to set
	 */
	public void setValueJson(String valueJson) {

		this.valueJson = valueJson;
	}

	/**
	 * Gets the address list id.
	 *
	 * @return the addressListId
	 */
	public Long getAddressListId() {

		return addressListId;
	}

	/**
	 * Sets the address list id.
	 *
	 * @param addressListId the addressListId to set
	 */
	public void setAddressListId(Long addressListId) {

		this.addressListId = addressListId;
	}

}
