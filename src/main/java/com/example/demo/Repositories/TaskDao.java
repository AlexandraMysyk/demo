package com.example.demo.Repositories;

import com.example.demo.entities.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
    @Query(value = "SELECT task.answer, task.complexity_level, task.task_content FROM task,task_to_user WHERE task.id_task=task_to_user.task_id_task and task.complexity_level=? and task_to_user.user_id_user=? ", nativeQuery = true)
    <idUser>
    List<String> findByLevel(String complexityLevel , int idUser);
    @Query(value = "SELECT task.answer, task.complexity_level, task.task_content FROM task,task_to_user,kind_of_task WHERE task.id_task=task_to_user.task_id_task and task.id_kot=kind_of_task.id_kot and kind_of_task.name=? and task_to_user.user_id_user=? ", nativeQuery = true)
    <idUser>
    List<String> findByKind(String kindOfTask, int idUser);
    @Query(value = "SELECT task.answer, task.complexity_level, task.task_content FROM task,task_to_user WHERE task.id_task=task_to_user.task_id_task  and task_to_user.user_id_user=? ", nativeQuery = true)
    List<String> getAllByUser(int idUser);
    @Modifying
    @Transactional
    @Query(value="UPDATE task SET id_user=? WHERE id_task=?", nativeQuery = true)
    Task saveTaskById( int idUser, int idTask);
}
