package com.example.animals.model;

import com.example.animals.validation.annotation.DoubleNameInDb;
import com.example.animals.validation.annotation.Enum;
import com.example.animals.validation.annotation.IdExistsInDb;
import com.example.animals.validation.group.Create;
import com.example.animals.validation.group.Update;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(groups = {Create.class}, message = "The POST request must not contain an ID")
    @NotNull(groups = {Update.class}, message = "The PUT request must contain an ID")
    @IdExistsInDb(groups = {Update.class})
    private Integer id;

    @NotNull(groups = {Create.class, Update.class}, message = "Request must include a name")
    @Size(groups = {Create.class, Update.class}, min = 2, max = 30, message = "Name should contain from 2 to 30 letters")
    @DoubleNameInDb(groups = {Create.class, Update.class})
    private String name;

    @NotNull(groups = {Create.class, Update.class}, message = "NotNull")
    @Enum(groups = {Create.class, Update.class}, enumClass = Gender.class, message = "GenderEnum")
    private String gender;

    @NotNull(groups = {Create.class, Update.class}, message = "Request must include a name")
    @PastOrPresent(groups = {Create.class, Update.class}, message = "PastOrPresent")
    private LocalDate dateOfBirth;

    @NotNull(groups = {Create.class, Update.class}, message = "NotNull")
    @Enum(groups = {Create.class, Update.class}, enumClass = AnimalType.class, message = "AnimalTypeEnum")
    private String type;

}
