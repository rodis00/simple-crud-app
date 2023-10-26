import React from "react";

const Header = () => {
  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark p-3">
          <div>
            <a className="navbar-brand m-5" href="/">
              Books Management
            </a>
          </div>
        </nav>
      </header>
    </div>
  );
};

export default Header;
