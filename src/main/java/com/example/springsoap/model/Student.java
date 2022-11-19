package com.example.springsoap.model;

public class Student {

  private Long id;
  private String name;
  private String passportNumber;

  public Student() {
    super();
  }

  public Student(final Long id, final String name, final String passportNumber) {
    this.id = id;
    this.name = name;
    this.passportNumber = passportNumber;
  }

  public Student(final String name, final String passportNumber) {
    this.name = name;
    this.passportNumber = passportNumber;
  }


  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", passportNumber='" + passportNumber + '\'' +
        '}';
  }
}
