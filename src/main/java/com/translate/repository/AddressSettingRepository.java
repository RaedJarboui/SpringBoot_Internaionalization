package com.translate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.translate.entity.AddressSetting;

@Repository
public interface AddressSettingRepository
		extends JpaRepository<AddressSetting, Long>, QuerydslPredicateExecutor<AddressSetting>,
		CrudRepository<AddressSetting, Long>, PagingAndSortingRepository<AddressSetting, Long> {

}
