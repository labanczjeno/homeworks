
package xyz.codingmentor.beanvalidationhw.beans;

import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import xyz.codingmentor.beanvalidationhw.constraint.Birthday;
import xyz.codingmentor.beanvalidationhw.constraint.Name;

@Name
@Birthday
public class UserEntity {
    
    @NotNull
    @Size(min = 6)
    private String username;
    @NotNull
    @Size(min = 6)
    @Pattern.List({
        @Pattern(regexp = ".*[a-z].*"), 
        @Pattern(regexp = ".*[A-Z].*"), 
        @Pattern(regexp = ".*[0-9=+<>.,].*")
    })
    private String password;
    private String firstname;
    private String lastname;
    @Pattern(regexp = "^[0-9]{4}.*")
    private String address;
    @Pattern(regexp = "^(06|\\+36)[0-9]{9}")
    private String phone;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z-.]+$")
    private String email;
    private Gender gender;
    @NotNull
    @Past
    private Date registrationDate;
    @NotNull
    @Past
    private Date lastModifiedDate;
    private Date dateOfBirth;
    private boolean admin;
    
    public UserEntity(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.gender = builder.gender;
        this.registrationDate = builder.registrationDate;
        this.lastModifiedDate = builder.lastModifiedDate;
        this.dateOfBirth = builder.dateOfBirth;
        this.admin = builder.admin;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public static class Builder{
        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private String address;
        private String phone;
        private String email;
        private Gender gender;
        private Date registrationDate;
        private Date lastModifiedDate;
        private Date dateOfBirth;
        private boolean admin;
        
        public Builder username(String username) {
             this.username = username;
             return this;
         }
         
         public Builder password(String password) {
             this.password = password;
             return this;
         }
         
         public Builder firstname(String firstname) {
             this.firstname = firstname;
             return this;
         }
         
         public Builder lastname(String lastname) {
             this.lastname = lastname;
             return this;
         }
         
         public Builder address(String address) {
             this.address = address;
             return this;
         }
         
         public Builder phone(String phone) {
             this.phone = phone;
             return this;
         }
         
         public Builder email(String email) {
             this.email = email;
            return this;
         }
         
         public Builder gender(Gender gender) {
             this.gender = gender;
             return this;
         }
         
         public Builder registrationDate(Date registrationDate) {
             this.registrationDate = registrationDate;
             return this;
         }
         
        public Builder lastModifiedDate(Date lastModifiedDate) {
             this.lastModifiedDate = lastModifiedDate;
             return this;
         }
         
         public Builder dateOfBirth(Date dateOfBirth) {
             this.dateOfBirth = dateOfBirth;
             return this;
         }
         
         public Builder admin(boolean admin) {
             this.admin = admin;
             return this;
         }
         
         public UserEntity build() {
             return new UserEntity(this);
         }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.firstname);
        hash = 59 * hash + Objects.hashCode(this.lastname);
        hash = 59 * hash + Objects.hashCode(this.address);
        hash = 59 * hash + Objects.hashCode(this.phone);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.gender);
        hash = 59 * hash + Objects.hashCode(this.registrationDate);
        hash = 59 * hash + Objects.hashCode(this.lastModifiedDate);
        hash = 59 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 59 * hash + (this.admin ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserEntity other = (UserEntity) obj;
        if (this.admin != other.admin) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        if (!Objects.equals(this.lastModifiedDate, other.lastModifiedDate)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }
        @Override
    public String toString() {
        return "UserEntity{" + "username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", registrationDate=" + registrationDate + ", lastModifiedDate=" + lastModifiedDate + ", dateOfBirth=" + dateOfBirth + ", admin=" + admin + '}';
    }
}