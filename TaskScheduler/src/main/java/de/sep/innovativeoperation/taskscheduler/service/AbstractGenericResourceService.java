package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.AbstractDataModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourcesModel;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourcesAssembler;


@Service
@Transactional
public abstract class AbstractGenericResourceService<D extends AbstractDataModel, R extends AbstractGenericResourceModel<D>,S extends AbstractGenericResourcesModel<R>> {
	@Autowired
	protected AbstractGenericDataService<D> dataService;
	
	@Autowired
	protected AbstractGenericDataResourceAssembler<D,R> resourceAssembler;
	
	@Autowired
	protected AbstractGenericDataResourcesAssembler<R,S> resourcesAssembler;
	
	@Transactional
	public R getById(int id){
		D data = dataService.getById(id);
		R resource = resourceAssembler.toResource(data);
		return  resource;
	}
	@Transactional
	public void deleteById(int id){
		dataService.deleteById(id);
		System.out.println("TEST");
	}
	@Transactional
	public S getAll(){
		List<D> data = dataService.getAll();
		List<R> resources = resourceAssembler.toResources(data);
		S resourcesResource = resourcesAssembler.toResource(resources);
		return  resourcesResource;
	}
	
}
