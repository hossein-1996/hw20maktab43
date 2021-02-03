package entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName", nullable = false, length = 40)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 65)
    private String lastName;

    @Column(name = "userName", nullable = false, length = 65 ,unique = true)
    private String userName;

    @Column(name = "email", nullable = false, length = 80, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;


    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String fnamename) {
        this.firstName = fnamename;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "entity.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", Lastname='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
