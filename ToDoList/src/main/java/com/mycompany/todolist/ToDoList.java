    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    public class ToDoList{
        public static void main(String[] args) {
             Scanner scanner = new Scanner(System.in);
             List<Task> tasks = new ArrayList<>();
             boolean running = true;

             System.out.println("Welcome to the To-Do List App!");

             while (running) {
                displayMenu();
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();
                System.out.println("");

                switch (choice) {
                 case "1":
                   addTask(scanner, tasks);
                   break;
                 case "2":
                   listTasks(tasks);
                   break;
                 case "3":
                   markTaskComplete(scanner, tasks);
                   break;
                 case "4":
                   removeTask(scanner, tasks);
                   break;
                 case "5":
                   running = false;
                   System.out.println("Exiting the To-Do List App. Goodbye!");
                   break;
                  default:
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            scanner.close();
        }

        private static void displayMenu() {
          System.out.println("Menu:");
          System.out.println("1. Add Task");
          System.out.println("2. List Tasks");
          System.out.println("3. Mark Task Complete");
          System.out.println("4. Remove Task");
          System.out.println("5. Exit");
        }

         private static void addTask(Scanner scanner, List<Task> tasks) {
          System.out.print("Enter task description: ");
          String description = scanner.nextLine();
          Task task = new Task(description, false);
          tasks.add(task);
          System.out.println("Task added: " + description);
          System.out.println("");
        }
        
         private static void listTasks(List<Task> tasks) {
          if(tasks.isEmpty()){
            System.out.println("Your to do list is empty.\n");
            return;
          }
          System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                String status = task.isComplete() ? "[x]" : "[ ]";
                System.out.println((i+1) + ". " + status + " " + task.description());
            }
            System.out.println("");
          }

         private static void markTaskComplete(Scanner scanner, List<Task> tasks) {
          listTasks(tasks);
           if (tasks.isEmpty()) {
               return;
             }
          System.out.print("Enter the number of the task to mark as complete: ");
          try{
            int taskNumber = Integer.parseInt(scanner.nextLine()) -1;
            if(taskNumber >= 0 && taskNumber < tasks.size()){
                Task task = tasks.get(taskNumber);
                tasks.set(taskNumber, new Task(task.description(), true));
                System.out.println("Task '" + task.description() + "' marked as complete.\n");
            } else {
              System.out.println("Invalid task number.\n");
            }

          } catch (NumberFormatException e) {
            System.out.println("Invalid task number format.\n");
          }

        }

        private static void removeTask(Scanner scanner, List<Task> tasks) {
           listTasks(tasks);
            if (tasks.isEmpty()) {
              return;
            }
           System.out.print("Enter the number of the task to remove: ");
           try{
                int taskNumber = Integer.parseInt(scanner.nextLine()) -1;

                if (taskNumber >= 0 && taskNumber < tasks.size()) {
                    Task task = tasks.remove(taskNumber);
                    System.out.println("Task '" + task.description() + "' removed.\n");
                } else {
                  System.out.println("Invalid task number.\n");
                }

           } catch (NumberFormatException e) {
              System.out.println("Invalid task number format.\n");
            }
         }
    }