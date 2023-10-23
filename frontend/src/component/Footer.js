import React from "react";

const Footer = () => {
  return (
    <div>
      <footer className="footer">
        <span>All right reserved &copy; {new Date().getFullYear()}</span>
      </footer>
    </div>
  );
};

export default Footer;
