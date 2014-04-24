package de.sep.innovativeoperation.taskscheduler.resource;

import org.springframework.hateoas.ResourceSupport;

public abstract class AbstractResource<T> extends ResourceSupport {

	protected T content;


	public AbstractResource(T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}
	

}
