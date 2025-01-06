import React, { useState } from 'react';
import './LoginRegisterPage.css';

const LoginRegisterPage = () => {
  const [isLogin, setIsLogin] = useState(true);
  const [isLoading, setIsLoading] = useState(false);

  const handleLogin = (e) => {
    e.preventDefault();
    setIsLoading(true);
    // Add your login logic here
    setTimeout(() => setIsLoading(false), 1000);
  };

  const handleRegister = (e) => {
    e.preventDefault();
    setIsLoading(true);
    // Add your registration logic here
    setTimeout(() => setIsLoading(false), 1000);
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
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="password"
                placeholder="Password"
                required
                className="input-field"
              />
            </div>
            <div className="form-extras">
              <label className="remember-me">
                <input type="checkbox" />
                Remember me
              </label>
              <a href="#" className="forgot-password">Forgot password?</a>
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
                placeholder="Full Name"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="email"
                placeholder="Email"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="password"
                placeholder="Password"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="password"
                placeholder="Confirm Password"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="text"
                placeholder="Employee ID"
                required
                className="input-field"
              />
            </div>
            <div className="form-group">
              <input
                type="tel"
                placeholder="Phone Number"
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