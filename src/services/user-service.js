import { myAxios } from "./helper";
 
export const signUp = (user) => {
    return myAxios.post('/register', user);
};

// In user-service.js
// export const loginUser = async (data) => {
//     try {
//       const response = await myAxios.post('/login', {
//         username: data.email,  // Map email to username
//         password: data.password
//       });
      
//       // Store the JWT token if login is successful
//       if (response.data) {
//         localStorage.setItem('token', response.data);
        
//         // Add token to default headers for future requests
//         myAxios.defaults.headers.common['Authorization'] = `Bearer ${response.data}`;
//       }
//       return response;
//     } catch (error) {
//       throw error;
//     }
//   };
  
//   // Add a function to check if user is logged in
//   export const isLoggedIn = () => {
//     return localStorage.getItem('token') != null;
//   };

export const loginUser = async (data) => {
    try {
        const response = await myAxios.post('/login', {
            username: data.email,
            password: data.password
        });
        
        if (response.data) {
            const { token, designation } = response.data;
            localStorage.setItem('token', token);
            localStorage.setItem('designation', designation);
            myAxios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        }
        return response;
    } catch (error) {
        throw error;
    }
};
