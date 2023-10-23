import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import BookService from "../service/BookService";

const AddBook = () => {
  const [title, setTitle] = useState("");
  const [rating, setRating] = useState("");
  const navigate = useNavigate();

  const bookData = { title, rating };

  function saveBook(e) {
    e.preventDefault();
    if (bookData.rating !== "" && bookData.title !== "")
      return BookService.addBook(bookData)
        .then(navigate("/"))
        .catch((e) => console.log(e));
    alert("Please fill the title and rating.");
  }
  return (
    <div>
      <div className="container mt-5">
        <div className="row">
          <div className="card col-md-6 offset-md-3">
            <h2 className="text-center">Add book</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  Title:
                  <input
                    className="form-control"
                    type="text"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    placeholder="Enter book title"
                  />
                </div>
                <div className="form-group mb-2">
                  Rating:
                  <input
                    className="form-control"
                    type="text"
                    value={rating}
                    onChange={(e) => setRating(e.target.value)}
                    placeholder="Enter book rating"
                  />
                </div>
                <div className="btn-group me-2">
                  <button
                    className="btn btn-success"
                    onClick={(e) => saveBook(e)}
                  >
                    Save
                  </button>
                </div>
                <div className="btn-group me-2">
                  <Link to={"/"} className="btn btn-danger" href="">
                    Cancel
                  </Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddBook;
