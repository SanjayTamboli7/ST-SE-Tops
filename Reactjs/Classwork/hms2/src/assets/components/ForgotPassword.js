import React, { useState } from "react";
import axios from "axios";

const ForgotPassword = () => {
    const [email, setEmail] = useState("");
    const [newPassword, setNewPassword] = useState("");

    const handleReset = async () => {
        try {
            const response = await axios.post("http://localhost:8080/api/admin/reset-password", { email, newPassword });
            alert(response.data);
        } catch (error) {
            alert("Error resetting password.");
        }
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-4">
                    <h3 className="text-center">Reset Password</h3>
                    <input type="email" className="form-control mb-3" placeholder="Email"
                           value={email} onChange={(e) => setEmail(e.target.value)} />
                    <input type="password" className="form-control mb-3" placeholder="New Password"
                           value={newPassword} onChange={(e) => setNewPassword(e.target.value)} />
                    <button className="btn btn-success w-100" onClick={handleReset}>Reset Password</button>
                </div>
            </div>
        </div>
    );
};

export default ForgotPassword;
