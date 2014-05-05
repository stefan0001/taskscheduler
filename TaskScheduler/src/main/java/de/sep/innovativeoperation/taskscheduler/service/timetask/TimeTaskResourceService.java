package de.sep.innovativeoperation.taskscheduler.service.timetask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TimeTaskResourceService {
	@Autowired
	private TimeTaskDataService timeTaskdataService;
}
