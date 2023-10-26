import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import BookService from "../service/BookService";

const BookList = () => {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    getAllBooks();
  }, []);

  function getAllBooks() {
    BookService.getAllBooks()
      .then((res) => {
        setBooks(res.data);
        console.log(res);
      })
      .catch((e) => console.log(e));
  }

  function deleteBookById(id) {
    BookService.deleteBook(id)
      .then(() => {
        console.log("delete successfully");
        getAllBooks();
      })
      .catch((e) => console.log(e));
  }

  return (
    <div className="container">
      <Link to={"/add-book"} className="btn btn-primary mb-2 mt-3" href="#">
        Add Book
      </Link>
      <h2 className="text-center mb-4">Book List</h2>
      <table className="table table-bordered table striped">
        <thead>
          <th>Book ID</th>
          <th>Book Title</th>
          <th>Book Raiting</th>
          <th>Actions</th>
        </thead>
        <tbody>
          {books.map((book) => (
            <tr id={book.id}>
              <td>{book.id}</td>
              <td>{book.title}</td>
              <td>{book.rating}</td>
              <td>
                <Link to={`/books/${book.id}`} className="btn btn-info">
                  Update
                </Link>
                <a
                  className="btn btn-danger"
                  onClick={() => deleteBookById(book.id)}
                >
                  Delete
                </a>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default BookList;
