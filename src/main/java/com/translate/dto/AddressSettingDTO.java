package com.translate.dto;

import java.io.Serializable;
import java.util.List;

public class AddressSettingDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3449290990607802412L;

	/** The id. */
	private Long id;

	/** The parent id. */
	private Long parentId;

	/** The address List Id. */
	private Long addressListId;

	/** The table abacus name. */
	private String tableAbacusName;

	/** The id extern. */
	private String idExtern;

	/** The value json. */
	private String valueJson;

	/** The id address list. */
	private List<String> idAddressList;

	/**
	 * Instantiates a new address setting DTO.
	 */
	public AddressSettingDTO() {

		/*
		 * 
		 */
	}

	/**
	 * Instantiates a new address setting DTO.
	 *
	 * @param parentId        the parent id
	 * @param addressListId   the address list id
	 * @param tableAbacusName the table abacus name
	 * @param idExtern        the id extern
	 */
	public AddressSettingDTO(Long parentId, Long addressListId, String tableAbacusName, String idExtern) {

		this.parentId = parentId;
		this.addressListId = addressListId;
		this.tableAbacusName = tableAbacusName;
		this.idExtern = idExtern;
	}

	/**
	 * Instantiates a new address setting DTO.
	 *
	 * @param parentId        the parent id
	 * @param tableAbacusName the table abacus name
	 * @param idExtern        the id extern
	 * @param valueJson       the value json
	 * @param addressListId   the address list id
	 */
	public AddressSettingDTO(Long parentId, String tableAbacusName, String idExtern, String valueJson,
			Long addressListId) {

		this.parentId = parentId;
		this.tableAbacusName = tableAbacusName;
		this.idExtern = idExtern;
		this.valueJson = valueJson;
		this.addressListId = addressListId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "AddressSettingDTO [id=" + id + ", parentId=" + parentId + ", tableAbacusName=" + tableAbacusName
				+ ", idExtern=" + idExtern + ", valueJson=" + valueJson + "]";
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

	/**
	 * Gets the id address list.
	 *
	 * @return the idAddressList
	 */
	public List<String> getIdAddressList() {

		return idAddressList;
	}

	/**
	 * Sets the id address list.
	 *
	 * @param idAddressList the idAddressList to set
	 */
	public void setIdAddressList(List<String> idAddressList) {

		this.idAddressList = idAddressList;
	}

}
