package com.memphis.guestbook;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "guest_message")
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First Name is mandatory")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    @Column(name = "lastName")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Column(name="email")
    @Email
    private String email;

    @Column(name="age")
    @Min(value=18, message="Age should be greater than 17")
    private Integer age;

    @NotBlank(message = "Content shouldn't be left blank. Thank you.")
    @Column(name="content")
    private String content;


    public Integer getId() {return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {this.lastName = lastName; }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}
    public String getContent() { return content; }
    public void setContent(String content) {this.content = content; }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", content='" + content + '\'' +
                '}';
    }
}
