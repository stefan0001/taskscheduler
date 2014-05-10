package de.sep.innovativeoperation.taskscheduler.model.resource.generic;

import java.util.Collection;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;

public abstract class AbstractGenericPagedResourcesModel<R extends AbstractGenericResourceModel<?>> extends PagedResources<R> {

	public AbstractGenericPagedResourcesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractGenericPagedResourcesModel(Collection<R> content,
			org.springframework.hateoas.PagedResources.PageMetadata metadata,
			Iterable<Link> links) {
		super(content, metadata, links);
		// TODO Auto-generated constructor stub
	}

	public AbstractGenericPagedResourcesModel(Collection<R> content,
			org.springframework.hateoas.PagedResources.PageMetadata metadata,
			Link... links) {
		super(content, metadata, links);
		// TODO Auto-generated constructor stub
	}

	



}
