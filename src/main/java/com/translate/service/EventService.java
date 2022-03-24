/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.entity.Event;
import com.translate.repository.EventRepository;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class EventService {
	@Autowired
	EventRepository eventRepository;

	public List<Event> getAllEvents() {

		return eventRepository.findAll();
	}

	public Event saveEvent(Event e) {

		return eventRepository.save(e);
	}

}
