package main.java.exercises.list.basicoperations;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    // attribute
    private List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(String description) {
        taskList.add(new Task(description));
    }

    public void removeTask(String description){
       List<Task> tasksToRemove = new ArrayList<>();

       if (!taskList.isEmpty()) {
           for (Task t : taskList) {
               if (t.getDescription().equalsIgnoreCase(description)) {
                   tasksToRemove.add(t);
               }
           }
           taskList.removeAll(tasksToRemove);
       } else {
           System.out.println("The list is empty!!");
       }
    }

    public int getTotalNumberTasks () {
        return taskList.size();
    }

    public void getDescriptionsTasks() {
        if (!taskList.isEmpty()) {
            System.out.println(taskList);
        } else {
            System.out.println("The list is empty!!");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the TaskList class
        TaskList taskList1 = new TaskList();

        // Adding tasks to the list
        taskList1.addTask("Buy coffee");
        taskList1.addTask("Study for the OOP test");
        taskList1.addTask("do the tasks");

        // Displaying the total number of tasks in the list
        System.out.println("The total number of elements in the list is: " + taskList1.getTotalNumberTasks());

        // Displaying task descriptions in the list
        taskList1.getDescriptionsTasks();

        // Removing a task from the list
        taskList1.removeTask("Leisure");

        // Displaying the total number of tasks in the list after removal
        System.out.println("Now you have it: " + taskList1.getTotalNumberTasks() + " list tasks:");

        // Displaying updated task descriptions in the list
        taskList1.getDescriptionsTasks();

        // Removing a task from the list when the list is empty
        taskList1.removeTask("");

        // Displaying the total number of tasks in the list after trying to remove from an empty list
        System.out.println("Now you have it: " + taskList1.getTotalNumberTasks() + " list tasks:");


    }
}
