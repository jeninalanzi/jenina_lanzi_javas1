package com.trilogyed.tasker;

import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImplTest;
import com.trilogyed.tasker.service.TaskerServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        // Include the JdbcTemplate tests and service layer test classes here.
        TaskerDaoJdbcTemplateImplTest.class,
        TaskerServiceTest.class
})
@RunWith(Suite.class)
public class TaskerServiceTestSuite {
}
