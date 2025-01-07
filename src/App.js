import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; // Use Routes instead of Switch
import LoginRegisterPage from './components/LoginRegisterPage'; // Import your LoginRegisterPage
import UserPage from './components/UserPage'; // Import user page component
import AdminPage from './components/AdminPage'; // Import admin page component

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<LoginRegisterPage />} />
        <Route path="/user" element={<UserPage />} />
        <Route path="/admin" element={<AdminPage />} />
        {/* Default route if no match */}
        <Route path="/" element={<LoginRegisterPage />} />
      </Routes>
    </Router>
  );
}

export default App;
