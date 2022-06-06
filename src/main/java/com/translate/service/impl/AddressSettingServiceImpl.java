package com.translate.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

import com.querydsl.core.BooleanBuilder;
import com.translate.dto.AddressSettingDTO;
import com.translate.entity.AddressSetting;
import com.translate.entity.QAddressSetting;
import com.translate.repository.AddressSettingRepository;
import com.translate.service.AddressSettingService;

public class AddressSettingServiceImpl implements AddressSettingService {

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(AddressSettingServiceImpl.class);

	/** The addressSetting repository. */
	@Autowired
	private AddressSettingRepository addressSettingRepository;

	/** The mapper. */
	@Autowired
	private ModelMapper mapper;

	/** The entity manager. */
	@Autowired
	private EntityManager entityManager;

	/** The transaction manager. */
	@Autowired
	private PlatformTransactionManager transactionManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acm.service.AddressSettingService#find(java.lang.Long)
	 */
	@Override
	public AddressSettingDTO find(Long id) {

		logger.info("Find AddressSetting by ID : {}", id);
		AddressSetting addressSetting = addressSettingRepository.findById(id).orElse(null);
		// check if object is null
		if (addressSetting == null) {
			logger.error("object address null");

		}
		return mapper.map(addressSetting, AddressSettingDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acm.service.AddressSettingService#find(com.acm.utils.dtos.
	 * AddressSettingDTO)
	 */
	@Override
	public List<AddressSettingDTO> find(AddressSettingDTO addressSettingDTO) {

		// init QAddressSetting
		QAddressSetting qAddressSetting = QAddressSetting.addressSetting;
		// init Predicate
		BooleanBuilder predicate = buildQuery(addressSettingDTO, qAddressSetting);

		Iterable<AddressSetting> iterable = addressSettingRepository.findAll(predicate);
		List<AddressSetting> addressSettings = new ArrayList<>();
		iterable.forEach(addressSettings::add);
		logger.info("{} : AddressSetting was founded", addressSettings.size());

		List<AddressSettingDTO> addressSettingsDTOs = new ArrayList<>();
		addressSettings.forEach(
				addressSetting -> addressSettingsDTOs.add(mapper.map(addressSetting, AddressSettingDTO.class)));
		return addressSettingsDTOs;
	}

	/**
	 * Builds the query.
	 *
	 * @author HaythemBenizid
	 * @param addressSettingDTO the address setting DTO
	 * @param qAddressSetting   the q address setting
	 * @return the boolean builder
	 */
	private BooleanBuilder buildQuery(AddressSettingDTO addressSettingDTO, QAddressSetting qAddressSetting) {

		// init Predicate
		BooleanBuilder predicate = new BooleanBuilder();

		// find by table Abacus Name
		if (addressSettingDTO.getTableAbacusName() != null) {
			predicate.and(qAddressSetting.tableAbacusName.eq(addressSettingDTO.getTableAbacusName()));
		}

		// find by address List Id
		if (addressSettingDTO.getAddressListId() != null) {
			predicate.and(qAddressSetting.addressListId.eq(addressSettingDTO.getAddressListId()));
		}

		// find by Ids address List
		if (addressSettingDTO.getIdAddressList() != null) {
			predicate.and(qAddressSetting.idExtern.in(addressSettingDTO.getIdAddressList()));
		}

		// find by ID extern
		if (addressSettingDTO.getIdExtern() != null) {
			predicate.and(qAddressSetting.idExtern.eq(addressSettingDTO.getIdExtern()));
		}

		// find by parent ID
		if (addressSettingDTO.getParentId() != null) {
			predicate.and(qAddressSetting.parentId.eq(addressSettingDTO.getParentId()));
		}
		return predicate;
	}

}
