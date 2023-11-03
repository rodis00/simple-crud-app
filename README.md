# simple-crud-app
Springboot and React Crud Book Management App `React` was used to create the `frontend` and `Java` for the backend `API`

## 1. Frontend
![book-list](https://github.com/rodis00/simple-crud-app/assets/93495745/593bd12c-768e-4f92-aa11-f59e36a4bb92)
![empty-list](https://github.com/rodis00/simple-crud-app/assets/93495745/4f677700-92f6-4235-8540-8e024f6d02e9)

## 1.1 Add book
![add-book-button](https://github.com/rodis00/simple-crud-app/assets/93495745/0af8207e-1f34-411c-8c96-871c35a43b2b)
![add-book-form](https://github.com/rodis00/simple-crud-app/assets/93495745/ea743a35-0324-4bdf-aabd-2cc393a08368)
![fill-data-form](https://github.com/rodis00/simple-crud-app/assets/93495745/898ba047-ef48-4d2c-99b4-9fba509bc377)

> [!WARNING]
> If you do not complete the form, you will see the following error message:
![empty-form-error](https://github.com/rodis00/simple-crud-app/assets/93495745/9a3b1146-c504-410b-91c6-412e03c23bba)

## 1.2 Update book:
![update-book-1](https://github.com/rodis00/simple-crud-app/assets/93495745/1b7c2ee3-5516-4832-abae-2497c3459f8c)
![update-book-2](https://github.com/rodis00/simple-crud-app/assets/93495745/005d3e87-3300-4335-8cd2-88219159934b)
![update-book-3](https://github.com/rodis00/simple-crud-app/assets/93495745/56c28fb4-d34c-4a6d-8c02-7397289f3db3)

## 1.3 Delete book:
![delete-book-1](https://github.com/rodis00/simple-crud-app/assets/93495745/5aef90dd-0d66-4c0b-9efd-c81a1cd5b8a6)
![delete-book-2](https://github.com/rodis00/simple-crud-app/assets/93495745/f8b0b44e-3b6e-404b-ae22-a65449dd3734)

## 2. Backend
### books
**Get all books**
`http://localhost:8080/books`
![getBooks](https://github.com/rodis00/simple-crud-app/assets/93495745/2b957baf-e420-46d6-84de-737b73f1cc74)

**Get book by id**
`http://localhost:8080/books/2`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/6795fb1d-e6a3-401f-a17d-16ae83b80c12)

> [!WARNING]
> If the book was not found:
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/411e6346-3113-48ba-bc9d-f644eaf4bccb)

**Update book:**
`http://localhost:8080/books/2`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/e6451f9c-cec8-4379-a10d-2bc1ed4ffb80)

**Patch update:**
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/1274919b-8a50-403e-bf0a-135537882e2a)

**Delete book:**
`http://localhost:8080/books/2`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/33aaa874-27d4-434f-97bf-f23d345d203e)

### Creating user and user profile
**Creating user with his profile and return** `DTO` **object:**
`http://localhost:8080/users`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/25798098-ac61-4f2e-aed7-2eb60f6e6ea4)

**Update User profile:**
`http://localhost:8080/user-profile/1`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/9154b106-bf90-439c-b31c-a01453d4882f)

**Get user by id to confirm changes:**
`http://localhost:8080/users/1`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/d57ada91-adf0-4037-adf4-9fd4228a9810)

### Authorization and Authentication
**Creating token** `JWT`
`http://localhost:8080/auth/generate-token`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/f09dfbd8-9158-466c-a644-4f5fef917c3d)

**Validate token:**
`http://localhost:8080/auth/validate-token`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/1c9d0eb5-f130-4f6e-84b1-8ee4b5792e08)

**Get Restricted books using** `JWT` **access:**
`http://localhost:8080/books/restricted-books`
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/35933757-e324-4ccd-b642-e696d3c70703)

> [!WARNING]
> Invalid credentials:
![image](https://github.com/rodis00/simple-crud-app/assets/93495745/4bf4dd7c-a951-4b44-ac28-fa9a23695b3b)







