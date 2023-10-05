package main.java.studies.list.basicoperations;

import main.java.exercises.list.basicoperations.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    // attribute
    private List<main.java.exercises.list.basicoperations.Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(String description) {
        taskList.add(new main.java.exercises.list.basicoperations.Task(description));
    }

    public void removeTask(String description){
       List<main.java.exercises.list.basicoperations.Task> tasksToRemove = new ArrayList<>();

        for (Task t: taskList) {
          if (t.getDescription().equalsIgnoreCase(description)) {
              tasksToRemove.add(t);
          }
        }

        taskList.removeAll(tasksToRemove);
    }

    public int getTotalNumberTasks () {
        return taskList.size();
    }

    public void getDescriptionsTasks() {
        System.out.println(taskList);
    }

    public static void main(String[] args) {
        TaskList taskList1 = new TaskList();

        System.out.println("O número total de elementos na lista é: " + taskList1.getTotalNumberTasks());

        taskList1.addTask("Tarefa 1");
        taskList1.addTask("Tarefa 1");
        taskList1.addTask("Tarefa 2");

        System.out.println("O número total de elementos na lista é: " + taskList1.getTotalNumberTasks());

        taskList1.removeTask("tarefa 2");

        System.out.println("O número total de elementos na lista é: " + taskList1.getTotalNumberTasks());

        taskList1.getDescriptionsTasks();

    }
}
