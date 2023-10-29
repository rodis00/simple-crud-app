import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import BookService from "../service/BookService";

const UpdateBook = () => {
  const [oldTitle, setOldTitle] = useState("");
  const [oldRating, setOldRating] = useState("");
  const [title, setTitle] = useState("");
  const [rating, setRating] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const bookData = { title, rating };

  useEffect(() => {
    BookService.getBookById(id)
      .then((res) => {
        setOldTitle(res.data.title);
        setOldRating(res.data.rating);
      })
      .catch((e) => console.log(e));
  }, []);

  function update(e) {
    e.preventDefault();
    let updatePromise;

    if (bookData.title === "")
      updatePromise = BookService.patchUpdate(id, { rating: bookData.rating });
    else if (bookData.rating === "")
      updatePromise = BookService.patchUpdate(id, { title: bookData.title });
    else updatePromise = BookService.updateBook(id, bookData);

    updatePromise
      .then(() => {
        console.log(updatePromise);
        navigate("/");
      })
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
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    placeholder={oldTitle}
                  />
                </div>
                <div className="form-group mb-2">
                  Rating:
                  <input
                    className="form-control"
                    type="number"
                    value={rating}
                    onChange={(e) => setRating(e.target.value)}
                    placeholder={oldRating}
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
