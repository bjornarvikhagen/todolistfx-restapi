package cleane.core;

import java.util.ArrayList;

public class Values {

  private Tasks tasks;
  private People people;

  /**
   * Creates new Value object with People and Tasks. Adds all people
   * and tasks to internal fields tasks and people.
   *
   * @param people to be placed in field.
   * @param tasks to be placed in field.
   */
  public Values(People people, Tasks tasks) {
    People newPeople = new People();
    for (int i = 0; i < people.size(); i++) {
      newPeople.add(people.get(i));
    }
    Tasks newTasks = new Tasks();
    for (int i = 0; i < tasks.size(); i++) {
      newTasks.add(tasks.getTask(i));
    }
    this.tasks = newTasks;
    this.people = newPeople;
  }

  public Values() {
    tasks = new Tasks();
    people = new People();
  }

  /**
   * Returns a copy of the field People.
   *
   * @return copy of people.
   */
  public People getPeople() {
    ArrayList<Person> list = new ArrayList<>();
    for (int i = 0; i < this.people.size(); i++) {
      list.add(this.people.get(i));
    }
    People newPeople = new People(list);
    return newPeople;
  }

  /**
   * Returns copy of field Tasks.
   *
   * @return copy of tasks.
   */
  public Tasks getTasks() {
    ArrayList<Task> list = new ArrayList<>();
    for (int i = 0; i < this.tasks.size(); i++) {
      list.add(this.tasks.getTask(i));
    }
    Tasks newTasks = new Tasks(list);
    return newTasks;
  }

  public void removePerson(int n) {
    people.remove(n);
  }

  public void removeTask(int n) {
    tasks.remove(n);
  }

  public void setPerson(Person person, int n) {
    people.set(person, n);
  }

  public void setTask(Task task, int n) {
    tasks.set(task, n);
  }
}
