package com.example.animals.validation;

public enum ErrorList {

    PostIdNotNull("1", "POST request must not contain an ID"),
    PutIdNull("2", "PUT request must contain an ID"),
    IdNotExistInDb("3", "ID not found in database"),
    NameNull("4", "Request must include a name"),
    NameSize("5", "Name should contain from 2 to 30 letters");

    ErrorList(String s, String s1) {
    }
}
