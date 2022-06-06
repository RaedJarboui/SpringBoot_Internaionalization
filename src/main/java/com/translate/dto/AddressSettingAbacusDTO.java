package com.translate.dto;

import java.io.Serializable;

public class AddressSettingAbacusDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2949436832377613315L;

	/** The address field. */
	private String addressField;

	/** The label. */
	private String label;

	/** The default text. */
	private String defaultText;

	/** The default address list value ID. */
	private Integer defaultAddressListValueID;

	/** The customer. */
	private Boolean customer;

	/** The use list. */
	private Boolean useList;

	/** The address list ID. */
	private Integer addressListID;

	/** The required. */
	private Boolean required;

	/**
	 * Instantiates a new address settings DTO.
	 */
	public AddressSettingAbacusDTO() {

		/*
		 * EMPTY
		 */
	}

	/**
	 * Gets the address field.
	 *
	 * @return the addressField
	 */
	public String getAddressField() {

		return addressField;
	}

	/**
	 * Sets the address field.
	 *
	 * @param addressField the addressField to set
	 */
	public void setAddressField(String addressField) {

		this.addressField = addressField;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {

		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label) {

		this.label = label;
	}

	/**
	 * Gets the default text.
	 *
	 * @return the defaultText
	 */
	public String getDefaultText() {

		return defaultText;
	}

	/**
	 * Sets the default text.
	 *
	 * @param defaultText the defaultText to set
	 */
	public void setDefaultText(String defaultText) {

		this.defaultText = defaultText;
	}

	/**
	 * Gets the default address list value ID.
	 *
	 * @return the defaultAddressListValueID
	 */
	public Integer getDefaultAddressListValueID() {

		return defaultAddressListValueID;
	}

	/**
	 * Sets the default address list value ID.
	 *
	 * @param defaultAddressListValueID the defaultAddressListValueID to set
	 */
	public void setDefaultAddressListValueID(Integer defaultAddressListValueID) {

		this.defaultAddressListValueID = defaultAddressListValueID;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Boolean getCustomer() {

		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the customer to set
	 */
	public void setCustomer(Boolean customer) {

		this.customer = customer;
	}

	/**
	 * Gets the use list.
	 *
	 * @return the useList
	 */
	public Boolean getUseList() {

		return useList;
	}

	/**
	 * Sets the use list.
	 *
	 * @param useList the useList to set
	 */
	public void setUseList(Boolean useList) {

		this.useList = useList;
	}

	/**
	 * Gets the address list ID.
	 *
	 * @return the addressListID
	 */
	public Integer getAddressListID() {

		return addressListID;
	}

	/**
	 * Sets the address list ID.
	 *
	 * @param addressListID the addressListID to set
	 */
	public void setAddressListID(Integer addressListID) {

		this.addressListID = addressListID;
	}

	/**
	 * Gets the required.
	 *
	 * @return the required
	 */
	public Boolean getRequired() {

		return required;
	}

	/**
	 * Sets the required.
	 *
	 * @param required the required to set
	 */
	public void setRequired(Boolean required) {

		this.required = required;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "AddressSettingAbacusDTO [addressField=" + addressField + ", label=" + label + ", defaultText="
				+ defaultText + ", defaultAddressListValueID=" + defaultAddressListValueID + ", customer=" + customer
				+ ", useList=" + useList + ", addressListID=" + addressListID + ", required=" + required + "]";
	}

}
