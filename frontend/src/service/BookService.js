import axios from "axios";

const BASE_URL = "http://localhost:8080/books";

class BookService {
  getAllBooks() {
    return axios.get(BASE_URL);
  }

  addBook(bookData) {
    return axios.post(BASE_URL + "/" + "add-book", bookData);
  }
}

export default new BookService();
