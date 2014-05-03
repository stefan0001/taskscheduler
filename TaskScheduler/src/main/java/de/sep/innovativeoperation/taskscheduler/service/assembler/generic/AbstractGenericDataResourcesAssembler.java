package de.sep.innovativeoperation.taskscheduler.service.assembler.generic;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourcesModel;

//TODO
public abstract class AbstractGenericDataResourcesAssembler< R extends AbstractGenericResourceModel<?>, S extends AbstractGenericResourcesModel<R>   > extends ResourceAssemblerSupport<Iterable<R>, S >{

	public AbstractGenericDataResourcesAssembler(Class<?> controllerClass,Class<S> resourceType) {
		super(controllerClass, resourceType);
		// TODO Auto-generated constructor stub
	}




	
	


}