package com.epam.training.microservices.banking.users.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "USERS")
public class User {
  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(min = 5, max = 1024)
  @Column(name = "USER_LOGIN")
  private String userLogin;

  @NotNull
  @Size(min = 5, max = 1024)
  @Column(name = "USER_PASSWORD")
  private String userPassword;

  @Column(name = "USER_ACTIVE")
  @Type(type = "yes_no")
  private boolean active;

  @NotNull
  @Column(name = "USER_CREATED_AT")
  private LocalDate createdDate = LocalDate.now();

  @NotNull
  @Column(name = "USER_UPDATED_AT")
  private LocalDate updatedDate = LocalDate.now();
}

