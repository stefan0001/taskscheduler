package de.sep.innovativeoperation.taskscheduler.service.assembler.generic;

import java.util.Collection;

import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericPagedResourcesModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;

@Service
public abstract class AbstractGenericPagedResourcesAssembler< R extends AbstractGenericResourceModel<?>, S extends AbstractGenericPagedResourcesModel<R>   > extends ResourceAssemblerSupport<Collection<R>, S >{

	public AbstractGenericPagedResourcesAssembler(Class<?> controllerClass,Class<S> resourceType) {
		super(controllerClass, resourceType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public S toResource(Collection<R> content){
		return this.toResource(content, new PageMetadata(0,0,0,0));
	}
	
	public abstract S toResource(Collection<R> content, PageMetadata metaData);

	


	
	


}