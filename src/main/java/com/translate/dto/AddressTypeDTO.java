package com.translate.dto;

import java.io.Serializable;

public class AddressTypeDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8422072022427463509L;

	/** The address type ID. */
	private Integer addressTypeID;

	/** The name. */
	private String name;

	/** The primary address type. */
	private Integer primaryAddressType;

	/**
	 * Instantiates a new address type DTO.
	 */
	public AddressTypeDTO() {

		/*
		 * EMPTY
		 */
	}

	/**
	 * Gets the address type ID.
	 *
	 * @return the addressTypeID
	 */
	public Integer getAddressTypeID() {

		return addressTypeID;
	}

	/**
	 * Sets the address type ID.
	 *
	 * @param addressTypeID the addressTypeID to set
	 */
	public void setAddressTypeID(Integer addressTypeID) {

		this.addressTypeID = addressTypeID;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * Gets the primary address type.
	 *
	 * @return the primaryAddressType
	 */
	public Integer getPrimaryAddressType() {

		return primaryAddressType;
	}

	/**
	 * Sets the primary address type.
	 *
	 * @param primaryAddressType the primaryAddressType to set
	 */
	public void setPrimaryAddressType(Integer primaryAddressType) {

		this.primaryAddressType = primaryAddressType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "AddressTypeDTO [addressTypeID=" + addressTypeID + ", name=" + name + ", primaryAddressType="
				+ primaryAddressType + "]";
	}

}
