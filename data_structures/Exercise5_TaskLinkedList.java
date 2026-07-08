class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }

    @Override
    public String toString() {
        return String.format("Task[id=%s, name=%s, status=%s]", taskId, taskName, status);
    }
}

public class Exercise5_TaskLinkedList {

    private static class Node {
        Task task;
        Node next;
        Node(Task task) { this.task = task; }
    }

    private Node head;
    private int size;

    public void add(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Task search(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean delete(String taskId) {
        if (head == null) return false;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            size--;
            return true;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Exercise5_TaskLinkedList list = new Exercise5_TaskLinkedList();
        list.add(new Task("T1", "Write report", "Pending"));
        list.add(new Task("T2", "Review code", "In Progress"));

        list.traverse();
        System.out.println(list.search("T2"));

        list.delete("T1");
        list.traverse();
    }
}
