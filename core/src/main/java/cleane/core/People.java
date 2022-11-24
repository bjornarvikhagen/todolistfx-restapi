package cleane.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People {

  private ArrayList<Person> people = new ArrayList<>();

  public People() {}
    
  public People(ArrayList<Person> people) {
    this.people = new ArrayList<>(people);
  }

  public List<Person> getPeople() {
    return Collections.unmodifiableList(people);
  }

  /**
   * Adds parameter to private field people.
   *
   * @param person to be added to field.
   */
  public void add(Person person) {
    if (person != null) {
      people.add(person);
    }
  }

  public Person get(int n) {
    return people.get(n);
  }

  public void set(Person person, int n) {
    people.set(n, person);
  }

  public int size() {
    return people.size();
  }

  public void remove(int n) {
    people.remove(n);
  }
}
