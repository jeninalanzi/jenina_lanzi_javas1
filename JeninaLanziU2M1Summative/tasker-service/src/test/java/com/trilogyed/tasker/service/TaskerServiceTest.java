package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class TaskerServiceTest {

    TaskerDao mockTaskerDao;
    TaskerServiceLayer mockTaskerServiceLayer;
    AdserverClient mockAdserverClient;

    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMock();
        setUpMockAdserver();
        mockTaskerServiceLayer = new TaskerServiceLayer(mockTaskerDao, mockAdserverClient);
    }


    // Test methods
    @Test
    public void saveFindTaskViewModel() {

        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("Buy groceries");
        tvm.setCreateDate(LocalDate.of(2019, 8, 27));
        tvm.setDueDate(LocalDate.of(2019, 9, 9));
        tvm.setCategory("food");
        tvm.setAdvertisement(mockAdserverClient.getAd());

        tvm = mockTaskerServiceLayer.newTask(tvm);

        TaskViewModel mockFromService = mockTaskerServiceLayer.getTask(tvm.getId());
        assertEquals(tvm, mockFromService);
    }

    @Test
    public void saveTask() {
        Task task = new Task();
        task.setDescription("Buy groceries");
        task.setCreateDate(LocalDate.of(2019, 8, 27));
        task.setDueDate(LocalDate.of(2019, 9, 9));
        task.setCategory("food");

        task = mockTaskerDao.createTask(task);

        Task mockFromService = mockTaskerDao.getTask(task.getId());
        assertEquals(task, mockFromService);
    }

    @Test
    public void findTaskByCategory() {
        Task task = new Task();
        task.setId(1);
        task.setDescription("Buy groceries");
        task.setCreateDate(LocalDate.of(2019, 8, 27));
        task.setDueDate(LocalDate.of(2019, 9, 9));
        task.setCategory("food");

        task = mockTaskerDao.createTask(task);

        List<Task> mockListFromService = mockTaskerDao.getTasksByCategory("food");
        assertEquals(1, mockListFromService.size());

    }

    @Test
    public void findAllTvmAndByCategory() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("Buy groceries");
        tvm.setCreateDate(LocalDate.of(2019, 8, 27));
        tvm.setDueDate(LocalDate.of(2019, 9, 9));
        tvm.setCategory("food");
        tvm.setAdvertisement(mockAdserverClient.getAd());

        List<TaskViewModel> mockList = mockTaskerServiceLayer.getTasksByCategory("food");
        assertEquals(1, mockList.size());

        List<TaskViewModel> mockAllList = mockTaskerServiceLayer.getAllTasks();
        assertEquals(1, mockAllList.size());

    }




    // Helper methods
    private void setUpTaskerDaoMock() {
        mockTaskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        // Create a mock task object.
        Task task = new Task();
        task.setId(1);
        task.setDescription("Buy groceries");
        task.setCreateDate(LocalDate.of(2019, 8, 27));
        task.setDueDate(LocalDate.of(2019, 9, 9));
        task.setCategory("food");

        Task task1 = new Task();
        //task1.setId(1);
        task1.setDescription("Buy groceries");
        task1.setCreateDate(LocalDate.of(2019, 8, 27));
        task1.setDueDate(LocalDate.of(2019, 9, 9));
        task1.setCategory("food");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(mockTaskerDao).createTask(task1);
        doReturn(task).when(mockTaskerDao).getTask(1);
        doReturn(taskList).when(mockTaskerDao).getTasksByCategory("food");
        doReturn(taskList).when(mockTaskerDao).getAllTasks();
    }

    private void setUpMockAdserver() {
        mockAdserverClient = mock(AdserverClient.class);

        String mockAd = "20% Off Cleaning Supplies Now! Click Here!";
        doReturn(mockAd).when(mockAdserverClient).getAd();
    }
}
