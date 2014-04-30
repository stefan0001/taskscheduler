package de.sep.innovativeoperation.taskscheduler.service.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import de.sep.innovativeoperation.taskscheduler.model.data.AbstractDataModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.AbstractGenericResourceModel;


/**
 * 
 * @author Stefan
 *
 * @param <D>
 * @param <R>
 */
public abstract class AbstractGenericDataResourceAssembler<D extends AbstractDataModel, R extends AbstractGenericResourceModel<D>> extends ResourceAssemblerSupport<D,R>{

	public AbstractGenericDataResourceAssembler(Class<?> controllerClass,
			Class<R> resourceType) {
		super(controllerClass, resourceType);
		// TODO Auto-generated constructor stub
	}



}