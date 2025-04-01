import React from "react";
import "./styles.css";

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-container">
        <div className="footer-links">
          <a href="#">Privacy Policy</a>
          <a href="#">Terms of Use</a>
          <a href="#">Help</a>
          <p>© 2025 Your Company. All Rights Reserved.</p>
        </div>
        <div className="social-media">
          <a href="#"><img src="/facebook.png" alt="Facebook" />Facebook</a>
          <a href="#"><img src="/twitter.png" alt="Twitter" />Twitter</a>
          <a href="#"><img src="/linkedin.png" alt="LinkedIn" />LinkedIn</a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
