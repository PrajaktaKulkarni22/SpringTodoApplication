package com.todoappproject.springtodoapp.repository;

import com.todoappproject.springtodoapp.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TaskRepository extends JpaRepository<TaskList,Integer> {

    @Query(value = "select t.task_id as value, t.task_name as label from task_list t where t.task_name like %?%",nativeQuery = true)
    List<Map<String,Object>> searchTask (String keyword);
}
