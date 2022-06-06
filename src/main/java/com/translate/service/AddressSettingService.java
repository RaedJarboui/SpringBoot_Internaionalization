package com.translate.service;

import java.util.List;

import com.translate.dto.AddressSettingDTO;

public interface AddressSettingService {

	/**
	 * Find {@link AddressSettingDTO} by given ID.
	 *
	 * @author HaythemBenizid
	 * @param id the id
	 * @return the addressSetting DTO
	 * @throws ResourcesNotFoundException the resources not found exception
	 */
	AddressSettingDTO find(Long id);

	/**
	 * Find {@link List} of {@link AddressSettingDTO} by given params.
	 *
	 * @author HaythemBenizid
	 * @param addressSettingDTO the addressSetting DTO
	 * @return the list
	 */
	List<AddressSettingDTO> find(AddressSettingDTO addressSettingDTO);

}
