import axios from "axios";

const BASE_URL = "http://localhost:8080/books";

class BookService {
  getAllBooks() {
    return axios.get(BASE_URL);
  }

  addBook(bookData) {
    return axios.post(BASE_URL + "/" + "add-book", bookData);
  }

  getBookById(id) {
    return axios.get(`${BASE_URL}/${id}`);
  }

  updateBook(id, bookData) {
    return axios.put(`${BASE_URL}/${id}`, bookData);
  }

  patchUpdate(id, bookData) {
    return axios.patch(`${BASE_URL}/${id}`, bookData);
  }
}

export default new BookService();
