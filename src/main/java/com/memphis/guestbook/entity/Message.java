package com.memphis.guestbook.entity;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

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

    @Column(name="subject")
    private String subject;

    @Column(name="age")
    @Min(value=18, message="Age should be greater than 17")
    private Integer age;

    @NotBlank(message = "Content shouldn't be left blank. Thank you.")
    @Column(name="content")
    private String content;

    @Column(name="gender")
    private String gender;

    @Column(name="rating")
    private Integer rating;

    //Mapping TimeStamp using java.util.Date
    @Column(name = "sentTime", updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentTime;

    public Integer getId() {return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}

    public String getContent() { return content; }
    public void setContent(String content) {this.content = content; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Integer getRating() { return rating;}
    public void setRating(Integer rating) {this.rating = rating;}

    public Date getSentTime() { return sentTime; }
    public void setSentTime(Date sentTime) { this.sentTime = sentTime; }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", email='" + subject + '\'' +
                ", age=" + age +
                ", content='" + content + '\'' +
                ", gender='" + gender + '\'' +
                ", rating=" + rating +
                ", sentTime='" + sentTime + '\'' +
                '}';
    }
}
