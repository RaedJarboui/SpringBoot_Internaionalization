/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.translate.entity.Event;
import com.translate.service.EventService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/api/event")
public class EventController {
	@Autowired
	EventService eventService;

	@GetMapping
	@ResponseBody
	public List<Event> getAllEvents() {

		return eventService.getAllEvents();
	}

	@PostMapping
	@ResponseBody
	public Event saveEvent(@RequestBody Event event) {

		return eventService.saveEvent(event);

	}

}
