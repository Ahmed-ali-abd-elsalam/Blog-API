# Blog API

A simple personal Blog API implemented using Spring Boot and PostgreSQL.

## Table of Contents

- [Introduction](#introduction)
- [Database scheme](#database-class-diagram)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [API Endpoints](#api-endpoints)

## Introduction

The Blog API is designed to provide a backend service for managing blog posts and Author interactions. It offers endpoints for creating, reading, updating, and deleting blog posts.

## Database Class Diagram
![database Class diagram](https://github.com/user-attachments/assets/99b08995-4ec8-4adf-bc9f-8d8815570499)

## Features

- Create, read, update, and delete blog posts
- Data validation on create/update endpoints

## Technologies Used

- Java
- Spring Boot
- Maven
- JPA (Java Persistence API)
- Hibernate
- PostgreSQL


## Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- PostgreSQL installed and running

## API Endpoints

![image](https://github.com/user-attachments/assets/35bdc745-d8f5-45bb-b312-40a80e85592c)

- [POST `/blogs`](#post-blogs)
- [GET `/blogs`](#get-blogs)
- [GET `/blogs/{blogsID}`](#get-blogsblogsid)
- [DELETE `/blogs/{blogsID}`](#delete-blogsblogsid)
- [POST `/blog`](#post-blog)
- [GET `/blog`](#get-blog)
- [POST `/authors`](#post-authors)
- [GET `/authors`](#get-authors)
- [GET `/authors/{AuthorID}`](#get-authorsauthorid)
- [DELETE `/authors/{AuthorID}`](#delete-authorsauthorid)
- [POST `/author`](#post-author)
- [GET `/author`](#get-author)

### POST `/blogs`
- **Description:**  
save array of blogs.
- **Request Body:**
 ```JSON
[
  {
    "author": "string",
    "title": "string",
    "content": "string"
  }
]
```
### GET `/blogs`
**Description:**  
get all blogs in database as an array.
### GET `/blogs/{blogsID}`
**Description:**  
get a blog by its id.
### DELETE `/blogs/{blogsID}`
**Description:**  
delete a blog by its id.
### POST `/blog`
- **Description:**  
save a single blog.
- **Request Body:**
 ```JSON
{
  "author": "string",
  "title": "string",
  "content": "string"
}
```
### GET `/blog`
**Description:**  
return an array with all blogs by the same title.
### POST `/authors`
- **Description:**  
save an array of authors.
- **Request Body:**
 ```JSON
[
  {
    "name": "string",
    "email": "string",
    "dob": "string",
    "noOfBlogs": 0,
    "blogNames": [
      "string"
    ]
}
]
```
### GET `/authors`
**Description:**  
return an array of all the authors in the database.
### GET `/authors/{AuthorID}`
**Description:**  
return an author with this id.
### DELETE `/authors/{AuthorID}`
**Description:**  
delete an author with this id.
### POST `/author`
**Description:**  
save a single author .
- **Request Body:**
 ```JSON
  {
    "name": "string",
    "email": "string",
    "dob": "string",
    "noOfBlogs": 0,
    "blogNames": [
      "string"
    ]
}
```
### GET `/author`
**Description:**  
get all authors by name.




