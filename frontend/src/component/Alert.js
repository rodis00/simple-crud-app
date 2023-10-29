import { useState } from "react";

const Alert = ({ message }) => {
  const [showAlert, setShowAlert] = useState(true);

  return (
    <>
      {showAlert && (
        <div className="my-alert">
          <div
            class="alert alert-warning alert-dismissible fade show"
            role="alert"
          >
            <strong>Warning</strong> {message}
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="alert"
              aria-label="Close"
              onClick={() => setShowAlert(false)}
            ></button>
          </div>
        </div>
      )}
    </>
  );
};

export default Alert;
