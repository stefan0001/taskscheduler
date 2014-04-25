package de.sep.innovativeoperation.taskscheduler.model.resource;

import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.ResourceSupport;

public abstract class AbstractResource<T> extends ResourceSupport {

	protected T content;
	
	protected Set<AbstractResource> embedded;


	public AbstractResource(T content) {
		this.content = content;
		this.embedded = new HashSet<AbstractResource>();
	}

	public T getContent() {
		return content;
	}
	
	public void setContent(T content) {
		this.content = content;
	}
	
	
	public Set<AbstractResource> getEmbedded() {
		return embedded;
	}
	
	public void setEmbedded(Set<AbstractResource> embedded) {
		this.embedded = embedded;
	}
	

}
