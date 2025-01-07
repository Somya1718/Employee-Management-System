import React, { useState } from 'react';
import './LoginRegisterPage.css';
import { signUp, loginUser } from '../services/user-service'; 
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom'; // Import useNavigate

const LoginRegisterPage = () => {
  const [isLogin, setIsLogin] = useState(true);
  const [isLoading, setIsLoading] = useState(false);
  const [email, setEmail] = useState(""); // State to store email
  const [password, setPassword] = useState(""); // State to store password
  const navigate = useNavigate(); // Replace useHistory with useNavigate

  // const handleLogin = async (e) => {
  //   e.preventDefault();
  //   setIsLoading(true);
    
  //   try {
  //     const response = await loginUser({ email, password });
  //     if (response.data) {
  //       toast.success("Login Successful!");
  //       const role = response.data.role; // Assuming role is part of the response
  //       if (role === 'admin') {
  //         navigate('/admin'); // Navigate to admin page if the user is an admin
  //       } else {
  //         navigate('/user'); // Navigate to user page if the user is a regular user
  //       }
  //     }
  //   } catch (error) {
  //     let errorMessage = "Login Failed";
  //     if (error.response?.data) {
  //       errorMessage += `: ${error.response.data}`;
  //     }
  //     toast.error(errorMessage);
  //   } finally {
  //     setIsLoading(false);
  //   }
  // };

  const handleLogin = async (e) => {
    e.preventDefault();
    setIsLoading(true);
    
    try {
        const response = await loginUser({ email, password });
        if (response.data) {
            toast.success("Login Successful!");
            const designation = response.data.designation?.toLowerCase();
            
            // Check if designation is admin
            if (designation === 'admin') {
                navigate('/admin');
            } else {
                navigate('/user');
            }
        }
    } catch (error) {
        let errorMessage = "Login Failed";
        if (error.response?.data) {
            errorMessage += `: ${error.response.data}`;
        }
        toast.error(errorMessage);
    } finally {
        setIsLoading(false);
    }
};
  
  

  const handleRegister = async (e) => {
    e.preventDefault();
    setIsLoading(true);

    const formData = new FormData(e.target);
    const data = {
      firstName: formData.get("firstName"),
      lastName: formData.get("lastName"),
      email: formData.get("email"),
      password: formData.get("password"),
      yrsOfExp: parseInt(formData.get("yrsOfExp")),
      designation: formData.get("designation"),
      phoneNumber: formData.get("phoneNumber"),
    };

    try {
      const response = await signUp(data);
      toast.success("Registration Successful!");
      console.log("User Registered Successfully", response.data);
    } catch (error) {
      toast.error("Registration Failed");
      console.error("User Registration Failed", error);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="container">
      <div className="form-container">
        <div className="logo">
          <h1>StatusNeo</h1>
        </div>
        <h2>Employee Management System</h2>

        <div className="tabs">
          <button
            className={`tab ${isLogin ? 'active' : ''}`}
            onClick={() => setIsLogin(true)}
          >
            Login
          </button>
          <button
            className={`tab ${!isLogin ? 'active' : ''}`}
            onClick={() => setIsLogin(false)}
          >
            Register
          </button>
        </div>

        {isLogin ? (
          <form onSubmit={handleLogin} className="form">
            <div className="form-group">
              <input
                type="email"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
                className="input-field"
              />
            </div>
            <button type="submit" disabled={isLoading} className="submit-btn">
              {isLoading ? "Logging in..." : "Login"}
            </button>
          </form>
        ) : (
          <form onSubmit={handleRegister} className="form">
            <div className="form-group">
              <input
                type="text"
                name="firstName"
                placeholder="First Name"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="text"
                name="lastName"
                placeholder="Last Name"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="email"
                name="email"
                placeholder="Email"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="password"
                name="password"
                placeholder="Password"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="number"
                name="yrsOfExp"
                placeholder="Years of Experience"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="text"
                name="designation"
                placeholder="Designation"
                required
                className="input-field"
              />
            </div>
            <button type="submit" disabled={isLoading} className="submit-btn">
              {isLoading ? "Registering..." : "Register"}
            </button>
          </form>
        )}
      </div>
    </div>
  );
};

export default LoginRegisterPage;
