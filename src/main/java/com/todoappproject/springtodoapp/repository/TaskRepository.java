package com.todoappproject.springtodoapp.repository;

import com.todoappproject.springtodoapp.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskList,Integer> {

    @Query(value = "select * from task_list t where t.task_name like %?1%",nativeQuery = true)
    List<TaskList> searchTask (String keyword);
}
