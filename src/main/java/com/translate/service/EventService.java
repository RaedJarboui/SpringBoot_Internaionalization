package com.translate.service;

import java.util.List;

import com.translate.entity.Event;

public interface EventService {
	public List<Event> getAllEvents();

	public Event saveEvent(Event e);

}
