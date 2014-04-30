package de.sep.innovativeoperation.taskscheduler.model.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public abstract class AbstractGenericResourceModel<T> extends Resource<T>{

	/**
	 * @param content
	 * @param links
	 */
	public AbstractGenericResourceModel(T content, Iterable<Link> links) {
		super(content, links);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param content
	 * @param links
	 */
	public AbstractGenericResourceModel(T content, Link... links) {
		super(content, links);
		// TODO Auto-generated constructor stub
	}

}
