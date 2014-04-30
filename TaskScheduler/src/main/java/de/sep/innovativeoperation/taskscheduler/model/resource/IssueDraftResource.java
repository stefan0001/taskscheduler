package de.sep.innovativeoperation.taskscheduler.model.resource;

import org.springframework.hateoas.Link;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;


public class IssueDraftResource extends AbstractGenericResourceModel<IssueDraft>{

	/**
	 * @param content
	 * @param links
	 */
	public IssueDraftResource(IssueDraft content, Iterable<Link> links) {
		super(content, links);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param content
	 * @param links
	 */
	public IssueDraftResource(IssueDraft content, Link... links) {
		super(content, links);
		// TODO Auto-generated constructor stub
	}




}
