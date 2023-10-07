package main.java.exercises.set.search;

import java.util.HashSet;
import java.util.Set;

public class TaskList {

    //attribute

    private Set<Task> taskSet;

    public TaskList() {
        this.taskSet = new HashSet<>();
    }

    public void addTask(String description) {
        taskSet.add(new Task(description));
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        if (!taskSet.isEmpty()) {
            for (Task t : taskSet) {
                if (t.getDescription().equalsIgnoreCase(description)) {
                    taskToRemove = t;
                    break;
                }
            }
            taskSet.remove(taskToRemove);
        } else {
            System.out.println("The set is empty!!");
        }

        if(taskToRemove == null) {
            System.out.println("Task not found!");
        }
    }

    public void displayTasks() {
        if(!taskSet.isEmpty()) {
            System.out.println(taskSet);
        } else {
            System.out.println("Task not found!");
        }
    }

    public int countTasks() {
        return taskSet.size();
    }

    public Set<Task> getTasksCompleted() {
        Set<Task> tasksCompleted = new HashSet<>();
        for (Task t : taskSet) {
            if (t.isCompleted()) {
                tasksCompleted.add(t);
            }
        }
        return tasksCompleted;
    }

    public Set<Task> getToDos() {
        Set<Task> tasksNotCompleted = new HashSet<>();
        for (Task t : taskSet) {
            if (!t.isCompleted()) {
                tasksNotCompleted.add(t);
            }
        }
        return tasksNotCompleted;
    }

    public void markTaskCompleted(String description) {
        for (Task t : taskSet) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                t.setCompleted(true);
            }
        }
    }

    public void markTaskPending(String description) {
        Task taskToMarkAsPending = null;
        for (Task t : taskSet) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                taskToMarkAsPending = t;
                break;
            }
        }

        if (taskToMarkAsPending != null) {
            if(taskToMarkAsPending.isCompleted()) {
                taskToMarkAsPending.setCompleted(false);
            }
        } else {
            System.out.println("Task not found in the list.");
        }
    }

    public void clearTaskList() {
        if(taskSet.isEmpty()) {
            System.out.println("The list is already empty!");
        } else {
            taskSet.clear();
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the TaskList class
        TaskList taskList = new TaskList();

        // Adding tasks to the list
        taskList.addTask("Study Java");
        taskList.addTask("Do physical exercises");
        taskList.addTask("Organize the work table");
        taskList.addTask("Read a book");
        taskList.addTask("Prepare presentation");

        // Displaying tasks in the list
        taskList.displayTasks();

        // Removing a task
        taskList.removeTask("Do physical exercises");
        taskList.displayTasks();

        // Counting the number of tasks in the list
        System.out.println("Total tasks in list: " + taskList.countTasks());

        // Getting to-do tasks
        System.out.println(taskList.getToDos());

        // Marking tasks as complete
        taskList.markTaskCompleted("Read a book");
        taskList.markTaskCompleted("Study Java");

        // Getting tasks completed
        System.out.println(taskList.getToDos());

        // Marking tasks as pending
        taskList.markTaskPending("Study Java");
        taskList.displayTasks();

        // Limpando a lista de tarefas
        taskList.clearTaskList();
        taskList.displayTasks();
    }
}
