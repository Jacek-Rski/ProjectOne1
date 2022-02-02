//Jacek Rzepczynski
//CSCI 2447
//Project One
package com.company;

import java.util.Scanner;

public class Main {

    public Main() {

    }



    public static void main(String[] args) {
        String[] tasks = new String[0];
        Scanner scanner = new Scanner(System.in);

        boolean continueLoop;
        continueLoop = true;




        while (continueLoop) {

            System.out.println("Please choose an option:");
            System.out.println("[1] Add a task.");
            System.out.println("[2] Delete a task.");
            System.out.println("[3] Change a task.");
            System.out.println("[4] List all tasks.");
            System.out.println("[0] Exit.");
            String input = scanner.nextLine();
            byte selection = -1;
            switch (input.hashCode()) {
                case 48:
                    if (input.equals("0")) {
                        selection = 4;
                    }


                    break;
                case 49:
                    if (input.equals("1")) {
                        selection = 0;
                    }


                    break;
                case 50:
                    if (input.equals("2")) {
                        selection = 1;
                    }


                    break;
                case 51:
                    if (input.equals("3")) {
                        selection = 2;
                    }


                    break;
                case 52:
                    if (input.equals("4")) {
                        selection = 3;
                    }


            }

            int index;
            switch (selection) {
                case 0 -> {
                    System.out.println("Enter your new task.");
                    String newTask = scanner.nextLine();
                    tasks = add(tasks, newTask);
                }
                case 1 -> {
                    System.out.println("Enter number of the task you want to delete.");
                    index = Integer.parseInt(scanner.nextLine());
                    tasks = delete(tasks, index);
                }
                case 2 -> {
                    System.out.println("Enter the number of the task to change.");
                    index = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter your new task.");
                    String newTask = scanner.nextLine();
                    change(tasks, index, newTask);
                }
                case 3 -> list(tasks);
                case 4 -> continueLoop = false;
            }
        }

    }



    static String[] add(String[] tasks, String newTask) {

    String[] newTasks = new String[tasks.length + 1];


        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);

    newTasks[newTasks.length - 1] = newTask;
    return newTasks;
}

    static String[] delete(String[] tasks, int index) {

        if (index >= 0 && index < tasks.length) {
            String[] newTasks = new String[tasks.length - 1];


            for (int i = 0; i < tasks.length; ++i) {
                if (i < index) {
                    newTasks[i] = tasks[i];
                } else if (i != index) {
                    newTasks[i - 1] = tasks[i];
                }
            }


            return newTasks;
        } else {
            return tasks;
        }


    }

    static void change(String[] tasks, int index, String newTask) {


        if (index >= 0 && index < tasks.length) {
            tasks[index] = newTask;
        }
    }

    static void list(String[] tasks) {

        for (int i = 0; i < tasks.length; ++i) {
            System.out.println(i + ". " + tasks[i]);
        }

    }
}