package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {
        List<Task> taskList = taskerDao.getAllTasks();
        for (Task t : taskList) {
            taskerDao.deleteTask(t.getId());
        }
    }

    @Test
    public void addGetDeleteTask() {

        Task task = new Task();
        task.setDescription("Buy groceries");
        task.setCreateDate(LocalDate.now());
        task.setDueDate(LocalDate.of(2019, 8, 31));
        task.setDescription("food");

        task = taskerDao.createTask(task);

        Task task2 = taskerDao.getTask(task.getId());
        assertEquals(task2, task);

        taskerDao.deleteTask(task.getId());
        task2 = taskerDao.getTask(task.getId());
        assertNull(task2);
    }

    @Test
    public void updateTask() {

        Task task = new Task();
        task.setDescription("Buy groceries");
        task.setCreateDate(LocalDate.now());
        task.setDueDate(LocalDate.of(2019, 8, 31));
        task.setDescription("food");
        task = taskerDao.createTask(task);

        task.setDescription("Buy kitchen supplies");
        task.setDueDate(LocalDate.of(2019, 9, 9));
        task.setCategory("cleaning");
        taskerDao.updateTask(task);

        Task task2 = taskerDao.getTask(task.getId());
        assertEquals(task2, task);
    }

    @Test
    public void getAllTasks() {

        Task task = new Task();
        task.setDescription("Buy groceries");
        task.setCreateDate(LocalDate.now());
        task.setDueDate(LocalDate.of(2019, 8, 31));
        task.setDescription("food");
        task = taskerDao.createTask(task);

        Task task2 = new Task();
        task2.setDescription("Clean the oven");
        task2.setCreateDate(LocalDate.now());
        task2.setDueDate(LocalDate.of(2019, 9, 9));
        task2.setDescription("cleaning");
        task2 = taskerDao.createTask(task2);

        Task task3 = new Task();
        task3.setDescription("Cook dinner");
        task3.setCreateDate(LocalDate.now());
        task3.setDueDate(LocalDate.of(2019, 8, 26));
        task3.setDescription("food");
        task3 = taskerDao.createTask(task3);

        List<Task> getAllTasks = taskerDao.getAllTasks();
        assertEquals(3, getAllTasks.size());

    }
}
