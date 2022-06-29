package com.spring.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.regex.Pattern;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private int age;

    @Column
    @NonNull
    private String phoneNumber;

    @Column
    @Email
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        if(age > 5 && age<20){
            this.age = age;
        }else {
            throw new RuntimeException("Invalid");
        }
    }

    public void setPhoneNumber(String phoneNumber) {

      if(phoneNumber.length() < 11 ||phoneNumber.length() >  11 ){

          throw new RuntimeException("Invalid");
      }else {
          this.phoneNumber=phoneNumber;
      }

    }

    public void setEmail(String email) {
        if(email == null || email.isEmpty()){
            throw new RuntimeException("Invalid");
        }
        String emailReg="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern p=Pattern.compile(emailReg);
        if(p.matcher(email).matches()){
            this.email = email;
        }else{
            throw new RuntimeException("Invalid");
        }

    }
}
