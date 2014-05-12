package de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft;

import de.sep.innovativeoperation.taskscheduler.controller.TimeTaskController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;

public class IssueDraftResourceAssemblerForTimeTask extends AbstractGenericDataResourceAssembler<IssueDraft, IssueDraftResource>  {

	public IssueDraftResourceAssemblerForTimeTask() {
		super(TimeTaskController.class, IssueDraftResource.class);

	}

	@Override
	public IssueDraftResource toResource(IssueDraft entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
