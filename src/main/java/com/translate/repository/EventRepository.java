/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.translate.entity.Event;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
