package de.sep.innovativeoperation.taskscheduler.resource;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public abstract class AbstractAssembler<T,R extends ResourceSupport> extends ResourceAssemblerSupport<T,R >{

	public AbstractAssembler(Class<?> controllerClass, Class<R> resourceType) {
		super(controllerClass, resourceType);
	}



}
