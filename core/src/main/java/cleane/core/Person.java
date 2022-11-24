package cleane.core;

public class Person {

  private String name;

  public Person(String name) {
    this.name = name;
  }

  public Person() {
    this.name = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
