package com.trilogyed.tasker.service;

import com.trilogyed.tasker.controller.TaskerController;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    // Access to Feign
    @Autowired
    AdserverClient client;

    // Access to the task database
    private TaskerDao taskerDao;

    // Access to the ads in Adserver.
    private TaskerController controller;

    @Autowired
    public TaskerServiceLayer(TaskerDao taskerDao, AdserverClient client) {
        this.taskerDao = taskerDao;
        this.client = client;
    }

    // All these methods need to interact with TVM.

    // TVM fetchTask(int id)
    // List<TVM> fetchAllTasks()
    // List<TVM> fetchTasksByCategory(String category)
    // TVM newTask(TVM tvm)
    // updateTask(TVM TVM)
    // deleteTask(int id)

    @Transactional
    public TaskViewModel newTask(TaskViewModel viewModel) {

        // Persist new Task object first
        Task t = new Task();
        t.setDescription(viewModel.getDescription());
        t.setCreateDate(viewModel.getCreateDate());
        t.setDueDate(viewModel.getDueDate());
        t.setCategory(viewModel.getCategory());

        // Add the task to the dao.
        t = taskerDao.createTask(t);
        System.out.println("t is:         " + t);

        // Assign id to the viewModel.
        viewModel.setId(t.getId());
        System.out.println("viewModel is: " + viewModel);

        return viewModel;
    }

    public TaskViewModel getTask(int id) {
        Task task = taskerDao.getTask(id);
        return buildTaskViewModel(task);
    }

    // This is where the ViewModel gets built,
    // advertisement will be added into here - tbd
    private TaskViewModel buildTaskViewModel(Task task) {

        // Get associated task.
        Task t  = taskerDao.getTask(task.getId());

        // Assemble the TaskViewModel
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(t.getId());
        tvm.setDescription(t.getDescription());
        tvm.setCreateDate(t.getCreateDate());
        tvm.setDueDate(t.getDueDate());
        tvm.setCategory(t.getCategory());
        tvm.setAdvertisement(client.getAd());

        return tvm;
    }

    public List<TaskViewModel> getAllTasks() {

        List<Task> taskList = taskerDao.getAllTasks();
        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task t : taskList) {
            TaskViewModel tvm = buildTaskViewModel(t);
            tvm.setId(t.getId());
            tvmList.add(tvm);
        }

        return tvmList;
    }

    public List<TaskViewModel> getTasksByCategory(String category) {

        List<Task> taskList = taskerDao.getTasksByCategory(category);
        List<TaskViewModel> tvmCategoryList = new ArrayList<>();

        for (Task t : taskList) {
            TaskViewModel tvm = buildTaskViewModel(t);
            tvm.setId(t.getId());
            tvmCategoryList.add(tvm);
        }

        return tvmCategoryList;
    }


    @Transactional
    public void updateTask(TaskViewModel viewModel) {
        // Update task info
        Task task = new Task();
        task.setId(viewModel.getId());
        task.setDescription(viewModel.getDescription());
        task.setCreateDate(viewModel.getCreateDate());
        task.setDueDate(viewModel.getDueDate());
        task.setCategory(viewModel.getCategory());

        taskerDao.updateTask(task);
    }

    @Transactional
    public void deleteTask(int id) {
        taskerDao.deleteTask(id);
    }



    // ---------------------------------------------------------------------

    // Task API
    public Task saveTask(Task task) { return taskerDao.createTask(task); }
    public Task findTask(int id) { return taskerDao.getTask(id); }
    public List<Task> findAllTasks() { return taskerDao.getAllTasks(); }
    public List<Task> findAllByCategory(String category) { return taskerDao.getTasksByCategory(category); }
    public void modifyTask(Task task) { taskerDao.updateTask(task); }
    public void removeTask(int id) { taskerDao.deleteTask(id); }
}
