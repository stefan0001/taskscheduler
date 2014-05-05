package de.sep.innovativeoperation.taskscheduler.service.timetask;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericResourceService;


@Service
@Transactional
public class TimeTaskResourceService extends AbstractGenericResourceService<TimeTask,TimeTaskResource, TimeTasksResource>{

}
