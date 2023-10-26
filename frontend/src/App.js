import AddBook from "./component/AddBook";
import BookList from "./component/BookList";
import Footer from "./component/Footer";
import Header from "./component/Header";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import UpdateBook from "./component/UpdateBook";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<BookList />} />
          <Route path="/add-book" element={<AddBook />} />
          <Route path="/books/:id" element={<UpdateBook />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
