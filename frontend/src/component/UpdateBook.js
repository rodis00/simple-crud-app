import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import BookService from "../service/BookService";

const UpdateBook = () => {
  const [title, setTitle] = useState("");
  const [rating, setRating] = useState("");
  const [new_title, setNewTitle] = useState("");
  const [new_rating, setNewRating] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const bookData = { new_title, new_rating };
  const example_data = {
    title: "test",
    rating: 22,
  };

  useEffect(() => {
    BookService.getBookById(id)
      .then((res) => {
        setTitle(res.data.title);
        setRating(res.data.rating);
      })
      .catch((e) => console.log(e));
  }, []);

  // TODO: update method send empty data
  function update(e) {
    e.preventDefault();
    console.log("rating: " + rating + "\ntitle: " + title);
    console.log("new_rating: " + new_rating + "\nnew_title: " + new_title);
    BookService.updateBook(id, example_data)
      .then((res) => console.log(res))
      .catch((e) => console.log(e));
  }
  return (
    <div>
      <div className="container mt-5">
        <div className="row">
          <div className="card col-md-6 offset-md-3">
            <h2 className="text-center">Update book</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  Title:
                  <input
                    className="form-control"
                    type="text"
                    value={new_title}
                    onChange={(e) => setNewTitle(e.target.value)}
                    placeholder={title}
                  />
                </div>
                <div className="form-group mb-2">
                  Rating:
                  <input
                    className="form-control"
                    type="text"
                    value={new_rating}
                    onChange={(e) => setNewRating(e.target.value)}
                    placeholder={rating}
                  />
                </div>
                <div className="btn-group me-2">
                  <button
                    className="btn btn-success"
                    onClick={(e) => update(e)}
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

export default UpdateBook;
