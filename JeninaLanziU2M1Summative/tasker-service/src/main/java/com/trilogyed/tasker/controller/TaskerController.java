package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RefreshScope
public class TaskerController {

    // Dependency injection for accessing Adserver.
    @Autowired
    private final AdserverClient client;

    TaskerController(AdserverClient client) {
        this.client = client;
    }


    // Dependency injection for accessing serviceLayer methods into controller.)
    // This also has access to taskerDao.
    @Autowired
    TaskerServiceLayer service;

    // -----------------------------------------------------------------------------------------

    // Refactored to use Feign client.
    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String getAd() {
        return client.getAd();
    }

    // POST METHOD
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel addTask(@RequestBody @Valid TaskViewModel tvm) {
        service.newTask(tvm);

        return service.getTask(tvm.getId());
    }

    // PUT METHOD
    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTask(@RequestBody @Valid TaskViewModel tvm) {
                service.updateTask(tvm);
    }

    // GET ALL METHOD
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> retrieveAllTasks() {
        return service.getAllTasks();
    }

    // GET BY ID METHOD
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel retrieveTask(@PathVariable @Valid int id) {
        return service.getTask(id);
    }

    // GET BY CATEGORY METHOD
    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> retrieveTasksByCategory(@PathVariable @Valid String category) {
        return service.getTasksByCategory(category);
    }

    // DELETE METHOD
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeTask(@PathVariable @Valid int id) {
        service.deleteTask(id);
    }




    // -----------------------------------------------------------------------------------------
}
