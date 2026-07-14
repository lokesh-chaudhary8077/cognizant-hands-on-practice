class Task {
    //
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return taskId + " " + taskName + " " + status;
    }
}

public class Library_Management_System {

    Task head;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);

        if (head == null) {
            head = newTask;
            return;
        }

        Task temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newTask;
    }

    public Task searchTask(int taskId) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == taskId) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    public void traverseTasks() {
        Task temp = head;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void deleteTask(int taskId) {

        if (head == null) {
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {

        Library_Management_System list = new Library_Management_System();

        list.addTask(101, "Design UI", "Pending");
        list.addTask(102, "Write Code", "In Progress");
        list.addTask(103, "Testing", "Pending");
        list.addTask(104, "Deployment", "Completed");

        System.out.println("All Tasks:");
        list.traverseTasks();

        System.out.println("\nSearch Task:");
        Task task = list.searchTask(103);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task Not Found");
        }

        System.out.println("\nDelete Task 102");
        list.deleteTask(102);

        System.out.println("\nTasks After Deletion:");
        list.traverseTasks();
    }
}