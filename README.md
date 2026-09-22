#  Personal Growth API

A simple Spring Boot REST API built around the idea of personal growth.
The API represents a personal growth profile and provides different ways to view, search, filter, create, update, and delete personal goals.

##  Profile

**Name:** Noor

**Theme:** Personal Growth

**Introduction:**
I enjoy learning, building healthy habits, and becoming a better version of myself. I believe that personal growth comes from small, consistent changes in different areas of life.

<img width="592" height="224" alt="profile" src="https://github.com/user-attachments/assets/14213ec1-a8a8-4d99-a39c-7df816ca721e" />


##  Goals

The API currently contains goals related to different areas of personal growth:

* Learn a New Language
* Stay Active & Exercise
* Build Healthy Eating Habits
* Read More Books
* Strengthen My Faith
* Strengthen Family Relationships

## Technologies

* Java
* Spring Boot
* Spring Web
* Maven
* REST API
* Postman

##  API Endpoints

| Method | Endpoint                  | Description                                        |
| ------ | ------------------------- | -------------------------------------------------- |
| GET    | `/welcome`                | Introduces the application                         |
| GET    | `/profile`                | Returns the personal growth profile                |
| GET    | `/goals`                  | Returns all goals                                  |
| GET    | `/goals/{id}`             | Returns one goal by ID                             |
| GET    | `/goals/search?name=`     | Searches goals by name                             |
| GET    | `/goals/filter?category=` | Filters goals by category                          |
| POST   | `/goals`                  | Creates a new goal                                 |
| PUT    | `/goals/{id}`             | Updates an existing goal                           |
| DELETE | `/goals/{id}`             | Deletes a goal                                     |
| GET    | `/statistics`             | Returns statistics about the goals                 |
| GET    | `/goals/today`            | Returns a random goal as a daily growth suggestion |

##  Examples

### Get All Goals

```http
GET http://localhost:8080/goals
```
<img width="397" height="488" alt="all" src="https://github.com/user-attachments/assets/9e28df84-6262-4328-8ec4-aca10289af31" />


### Get One Goal

```http
GET http://localhost:8080/goals/1
```
<img width="274" height="133" alt="select" src="https://github.com/user-attachments/assets/58b4574f-0ece-4242-92e9-baa146b550a8" />


### Search

```http
GET http://localhost:8080/goals/search?name=language
```
<img width="274" height="133" alt="select" src="https://github.com/user-attachments/assets/bc2bdcf2-8735-4a9a-8281-59973882aad0" />


### Filter

```http
GET http://localhost:8080/goals/filter?category=Learning
```
<img width="252" height="191" alt="fliter" src="https://github.com/user-attachments/assets/b63a9f24-b79f-4a04-9943-2e106709fe81" />


### Create a Goal

```http
POST http://localhost:8080/goals
```

Request body:

```json
{
    "id": 7,
    "name": "Spend More Time With Family",
    "category": "Family"
}

```
<img width="437" height="395" alt="create" src="https://github.com/user-attachments/assets/38c0f153-cfb5-45a9-b5d6-fb206a05d06a" />


### Update a Goal

```http
PUT http://localhost:8080/goals/2
```

Request body:

```json
{
    "id": 2,
    "name": "Exercise 4 Times a Week",
    "category": "Fitness"
}

```
<img width="444" height="316" alt="edit" src="https://github.com/user-attachments/assets/f26d493b-9b1d-4e64-a5af-5e9fc03891a3" />


### Delete a Goal

```http
DELETE http://localhost:8080/goals/6
```
<img width="215" height="47" alt="delete" src="https://github.com/user-attachments/assets/252860c3-9a60-44e7-90d7-cfce2e099ac4" />

### Daily Growth Suggestion

```http
GET http://localhost:8080/goals/today
```
<img width="245" height="131" alt="random" src="https://github.com/user-attachments/assets/f531b4de-a981-4126-aa06-52cd4d0ccbe2" />

---

 **Small steps, consistent growth. 🌱**
