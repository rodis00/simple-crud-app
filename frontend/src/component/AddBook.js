import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import BookService from "../service/BookService";
import Alert from "./Alert";

const AddBook = () => {
  const [title, setTitle] = useState("");
  const [rating, setRating] = useState("");
  const navigate = useNavigate();
  const [showAlert, setShowAlert] = useState({});

  const bookData = { title, rating };

  function saveBook(e) {
    e.preventDefault();
    if (bookData.rating !== "" && bookData.title !== "") {
      if (bookData.rating > 0 && bookData.rating < 11) {
        return BookService.addBook(bookData)
          .then(() => navigate("/"))
          .catch((e) => console.log(e));
      } else {
        setShowAlert({
          isActive: true,
          message: "Rating should be between 1 and 10.",
        });
      }
    } else {
      setShowAlert({
        isActive: true,
        message: "Please fill the title and rating.",
      });
    }
  }

  return (
    <div>
      {showAlert.isActive && <Alert message={showAlert.message} />}
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
                    type="number"
                    min="1"
                    max="10"
                    value={rating}
                    onChange={(e) => setRating(e.target.value)}
                    placeholder="Enter book rating (1-10)"
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
