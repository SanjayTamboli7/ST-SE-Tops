import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Button, Form, Alert } from "react-bootstrap";
import OUChangePasswordModal from "./OUChangePasswordModal";
import OUForgotPasswordModal from "./OUForgotPasswordModal";
import axios from "axios";

const OULogin = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [showChangeModal, setShowChangeModal] = useState(false);
    const [showForgotModal, setShowForgotModal] = useState(false);
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            const res = await axios.post("http://localhost:8080/api/ouuser/login", { email, password });
            if (res.data) {
                localStorage.setItem("ouserdata", JSON.stringify(res.data));
                // New code begins here to prepare session variables
                const {ouserid, ousername, ouseremailid, ousercontactno, ouserdeptid, ouserdesignationid, ouserpassword, ouserstatus} = res.data;
                sessionStorage.setItem('userid', ouserid);
                sessionStorage.setItem('username', ousername);
                sessionStorage.setItem('useremailid', ouseremailid);
                sessionStorage.setItem('usercontactno', ousercontactno);
                sessionStorage.setItem('userdeptid', ouserdeptid);
                sessionStorage.setItem('userdesignationid', ouserdesignationid);
                sessionStorage.setItem('userpassword', ouserpassword);
                sessionStorage.setItem('userstatus', ouserstatus);          
                // alert("ouserid-" + ouserid + " ousername-" + ousername + " ouseremailid-" + ouseremailid + " ousercontactno-" + ousercontactno + " ouserdeptid-" + ouserdeptid + " ouserdesignationid-" + ouserdesignationid + " ouserpassword-" + ouserpassword + " ouserstatus-"  + ouserstatus)
                // New code begins here to prepare session variables
                navigate("/home");
            }
        } catch {
            setError("Invalid credentials");
        }
    };

    const handleReset = () => {
        setEmail("");
        setPassword("");
        setError("");
    };

    return (
        <div className="container mt-5" style={{ maxWidth: "400px" }}>
            <h3 className="text-center mb-3">OU Login</h3>
            {error && <Alert variant="danger">{error}</Alert>}
            <Form>
                <Form.Group className="mb-3">
                    <Form.Label>Email ID</Form.Label>
                    <Form.Control type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </Form.Group>
                <div className="d-flex justify-content-between">
                    <Button onClick={handleLogin}>Login</Button>
                    <Button variant="secondary" onClick={handleReset}>Reset</Button>
                </div>
                <div className="mt-3 d-flex justify-content-between">
                    <Button variant="link" onClick={() => setShowChangeModal(true)}>Change Password</Button>
                    <Button variant="link" onClick={() => setShowForgotModal(true)}>Forgot Password?</Button>
                </div>
            </Form>

            <OUChangePasswordModal show={showChangeModal} onHide={() => setShowChangeModal(false)} />
            {/* <OUForgotPasswordModal show={showForgotModal} onHide={() => setShowForgotModal(false)} /> */}
            <OUForgotPasswordModal
                show={showForgotModal}
                handleClose={() => setShowForgotModal(false)} // ✅ this fixes it!
            />

        </div>
    );
};

export default OULogin;
