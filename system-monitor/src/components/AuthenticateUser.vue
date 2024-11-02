<template>
  <div class="bg-one">
    <div class="login-container">
      <div class="logo-container">
        <div class="zoho_logo"></div>
        <span class="head">System Monitoring</span>
      </div>

      <h2 class="title">Sign in</h2>
      <form @submit.prevent="handleSubmit" class="login-form">
        <div class="form-group">
          <label for="username">Username</label>
          <input
            type="text"
            id="username"
            v-model="username"
            required
            placeholder="Enter your username"
            @input="validateInput"
          />
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input
            type="password"
            id="password"
            v-model="password"
            required
            placeholder="Enter your password"
            @input="validateInput"
          />
        </div>
        <div v-if="errorMessage" class="error-message">
          {{ errorMessage }}
        </div>
        <button type="submit" :disabled="!isFormValid" class="login-button">Login</button>
      </form>
      <div class="footer">
        <p>&copy; {{ new Date().getFullYear() }} monitoring. All Rights Reserved.</p>
      </div>
    </div>
  </div>
</template>



<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      errorMessage: '',
      isFormValid: false,
    };
  },
  methods: {
    validateInput() {
      const usernameRegex = /^[a-zA-Z0-9!@#$%^&*()_+\-={};':"\\|,.<>/?]*$/;
      const passwordRegex = /^[a-zA-Z0-9!@#$%^&*()_+\-={};':"\\|,.<>/?]*$/;

      this.isFormValid =
        usernameRegex.test(this.username) &&
        passwordRegex.test(this.password);
    },

    async handleSubmit() {

      this.errorMessage ='';
      
      // Input validation
      if (!this.username || !this.password) {
        this.errorMessage = 'Username and password are required.';
        return;
      }

      try {
        // Send POST request to the Java Servlet for authentication
        const response = await fetch('https://192.168.11.251:8443/SystemMonitoring/LoginServlet', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            username: this.username,
            password: this.password,
          }),
        });

        if (response.ok) {
          const result = await response.json();
          console.log(result);
          if (result.success) {
        // Store authentication status in localStorage
        localStorage.setItem('isAuthenticated', 'true');

        // Redirect to the main dashboard
        this.$router.push('/system-health');
      } else {
        this.errorMessage = 'Invalid username or password.';
      }
    } else {
      this.errorMessage = 'Server error. Please try again later.';
    }
  } catch (error) {
    this.errorMessage = 'Unable to connect to the server.';
  }
}
  },
};
</script>

<style scoped>
.logo-container {
  display: flex;
  align-items: center; /* Align items vertically center */
  margin-bottom: 20px; /* Space below the logo and heading */
}

.zoho_logo {
  display: block;
  background-image: url('../assets/zoho-logo.png'); /* Ensure this path is correct */
  background-repeat: no-repeat;
  background-size: contain; /* Use 'contain' to fit within the dimensions */
  height: 40px; /* Set height according to your needs */
  width: 150px; /* Set a fixed width for the logo */
  margin-right: 10px; /* Add some space between logo and text */
}

.head {
  font-size: 30px;
  font-family: sans-serif;
}

.bg-one{
  display: block;
  position: fixed;
  top:0px;
  left:0px;
  height: 100%;
  width: 100%;
   background: url(https://static.zohocdn.com/iam/v2/components/images/bg.49756b7c711696d95133fa95451f8e13.svg); 
  background-size: cover;
  z-index: -1;
}
.login-container {
  max-width: 500px;
  margin-left: 35%;
  margin-top: 50px;
  padding: 30px;
  border-radius: 10px;
  background-color: #ffffff;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.logo {
  font-size: 2.5em;
  font-weight: bold;
  margin-bottom: 20px;
  color: #102377; /* Company color */
}

.title {
  margin-bottom: 20px;
  font-size: 1.5em;
  color: #333;
}

.form-group {
  margin-bottom: 20px;
  text-align: left;
}

label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
  color: #555;
}

input {
  width: 95%;
  padding: 12px;
  border-radius: 5px;
  border: 1px solid #ddd;
  font-size: 16px;
  transition: border-color 0.3s;
}

input:focus {
  border-color: #4caf50;
  outline: none;
}

.login-button {
  width: 90%;
  padding: 12px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.3s;
}

.login-button:hover {
  background-color: #45a049;
  transform: translateY(-2px);
}

.login-button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}

.error-message {
  color: red;
  margin-top: 10px;
  text-align: center;
}

.footer {
  margin-top: 20px;
  font-size: 0.9em;
  color: #888;
}
</style>
