package com.memphis.guestbook;
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity // This tells Hibernate to make a table out of this class
public class MessageForm {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;

        @NotBlank(message = "First Name is mandatory")
        @Column(name = "firstName", length = 100)
        private String firstName;

        @NotBlank(message = "Last Name is mandatory")
        @Column(name = "lastName", length = 100)
        private String lastName;

        @NotBlank(message = "Email is mandatory")
        private String email;

        @NotBlank(message = "Age is a mandatory number")
        @Min(18)
        private Integer age;

        private String content;
        @NotBlank(message = "Content shouldn't be left blank. Thank you.")

        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String name) {
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
        public String getContent() { return content; }
        public void setContent(String content) {this.content = content; }
        public Integer getAge() {return age;}
        public void setAge(Integer age) {this.age = age;}

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
