import React from 'react';
import { 
  FaFacebook, 
  FaTwitter, 
  FaInstagram, 
  FaLinkedin, 
  FaYoutube 
} from 'react-icons/fa';

function Footer() {
  return (
    <footer className="footer">
      <div className="footer-container">
        <div className="footer-column">
          <ul className="footer-links">
            <li><a href="/about">About Us</a></li>
            <li><a href="/contact">Contact Us</a></li>
            <li><a href="/careers">Careers</a></li>
          </ul>
          <div className="copyright">
            &copy; {new Date().getFullYear()} Company Name. All rights reserved.
          </div>
        </div>
        <div className="footer-column">
          <ul className="footer-links">
            <li><a href="/privacy">Privacy Policy</a></li>
            <li><a href="/terms">Terms of Service</a></li>
            <li><a href="/faq">FAQ</a></li>
          </ul>
          <div className="social-media">
            <a href="https://facebook.com" className="social-link">
              <FaFacebook /> Facebook
            </a>
            <a href="https://twitter.com" className="social-link">
              <FaTwitter /> Twitter
            </a>
            <a href="https://instagram.com" className="social-link">
              <FaInstagram /> Instagram
            </a>
            <a href="https://linkedin.com" className="social-link">
              <FaLinkedin /> LinkedIn
            </a>
            <a href="https://youtube.com" className="social-link">
              <FaYoutube /> YouTube
            </a>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
