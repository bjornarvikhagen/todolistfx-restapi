package cleane.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Tasks {
    
  private List<Task> tasks = new ArrayList<>();

  public Tasks()  {}

  public Tasks(List<Task> tasks) {
    this.tasks = new ArrayList<Task>(tasks);
  }

  public Tasks(Collection<Task> tasks) {
    this.tasks = new ArrayList<Task>(tasks);
  }

  public List<Task> getTasks() {
    return Collections.unmodifiableList(tasks);
  }

  public void add(Task task) {
    tasks.add(task);
  }
    
  public Task getTask(int n) {
    return tasks.get(n);
  }

  public void set(Task task, int n) {
    tasks.set(n, task);
  }

  public int size() {
    return tasks.size();
  }

  public void remove(int n) {
    tasks.remove(n);
  }

  public void remove(Task task) {
    tasks.remove(task);
  }
}
