package de.sep.innovativeoperation.taskscheduler.model.resource;

import org.springframework.hateoas.Link;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;

public class IssueEntityResource extends AbstractGenericResourceModel<IssueEntity> {

	/**
	 * @param content
	 * @param links
	 */
	public IssueEntityResource(IssueEntity content, Iterable<Link> links) {
		super(content, links);

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param content
	 * @param links
	 */
	public IssueEntityResource(IssueEntity content, Link... links) {
		super(content, links);
		// TODO Auto-generated constructor stub
	}


	

}
