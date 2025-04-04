import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

const Login = () => {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  // const [auserid, setauserid] = useState(null);
  // const [auserstatus, setauserstatus] = useState("");
  
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
        console.log("Attempting login...");  // Debugging log
        const response = await axios.post("http://localhost:8080/api/admin/login", { email, password });
        if (response.data) {                    
          localStorage.setItem("auth", "true"); // Store auth state
          // New code begins here to fetch auserid and auserstatus
          const response = await axios.get(`http://localhost:8080/api/adminuserdetails/fetchUserDetails?email=`+email);
          const { auserid, auserstatus } = response.data;      
          console.log("Login 11 : " + email);
          console.log("Login 12 : " + auserid);
          console.log("Login 13 : " + auserstatus);
          // Store user data in sessionStorage
          sessionStorage.setItem('useremailid', email);
          sessionStorage.setItem('userid', auserid);
          sessionStorage.setItem('userstatus', auserstatus);          
          // New code ends here to fetch auserid and auserstatus
          navigate("/home"); // Redirect to home page
        } else {
            alert("Invalid credentials!");
        }
    } catch (error) {
        alert("Login failed! " + error.response?.data?.message || error.message);
    }
};

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleLogin} className="p-4 border rounded shadow-sm bg-light">
        <div className="mb-3">
          <label htmlFor="email" className="form-label">Email</label>
          <input
            type="email"
            id="email"
            className="form-control"
            placeholder="Enter your email"
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <div className="mb-3">
          <label htmlFor="password" className="form-label">Password</label>
          <input
            type="password"
            id="password"
            className="form-control"
            placeholder="Enter your password"
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        <button type="submit" className="btn btn-primary w-100">Login</button>
      </form>

    </div>
  );
};

export default Login;
