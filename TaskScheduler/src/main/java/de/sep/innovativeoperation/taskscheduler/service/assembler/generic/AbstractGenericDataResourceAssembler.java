package de.sep.innovativeoperation.taskscheduler.service.assembler.generic;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.model.data.AbstractDataModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;


/**
 * 
 * @author SEP
 *Converts a Data Class to a Resource Class
 * @param <D>The Data Class
 * @param <R>The Resource Class
 */

@Service
public abstract class AbstractGenericDataResourceAssembler<D extends AbstractDataModel, R extends AbstractGenericResourceModel<D> > extends ResourceAssemblerSupport<D,R>{

	public AbstractGenericDataResourceAssembler(Class<?> controllerClass, Class<R> resourceType) {
		super(controllerClass, resourceType);
	}

	
	




	

	

	
	


}