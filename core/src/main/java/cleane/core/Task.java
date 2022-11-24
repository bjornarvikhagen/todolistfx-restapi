package cleane.core;

import java.time.LocalDate;

public class Task {

  private String description;
  private LocalDate deadline;
  private Person person;

  /**
   * Create a task object with a description, deadline, and an assigned person.
   *
   * @param description String describing what the task is.
   * @param deadline LocalDate object that acts as a deadline for the task to be completed in.
   * @param person Person object to be assigned the Task object. 
  **/
  public Task(String description, LocalDate deadline, Person person) {
    this.description = description;
    this.deadline = deadline;
    this.person = new Person(person.getName());
  }

  /**
   * Creates empty task constructor for jacoco and ValuesService.java.
   */
  public Task() {
    this.description = null;
    this.deadline = null;
    this.person = new Person();
  }

  public Person getPerson() {
    return new Person(this.person.getName());
  }

  public void setPerson(Person person) {
    this.person = new Person(person.getName());
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  
}
