<template>
  <HeaderComponent />
  <div class="main">
    <div class="form">
      <div class="signup" :class="{ 'slide-up': isSignUp }">
        <h2 class="form-title" @click="isSignUp=!isSignUp;"><span>or</span>Sign up</h2>
        <div class="form-holder">
          <input v-model="signUpUsername" type="text" class="input" placeholder="Name" />
          <input v-model="signUpEmail" type="email" class="input" placeholder="Email" />
          <input v-model="signUpPassword" type="password" class="input" placeholder="Password" />
        </div>
        <button class="submit-btn" @click="doSignUp(signUpUsername, signUpEmail, signUpPassword)">Sign up</button>
      </div>
      <div class="login" :class="{ 'slide-up': !isSignUp }">
        <div class="center">
          <h2 class="form-title" @click="isSignUp=!isSignUp;"><span>or</span>Log in</h2>
          <div class="form-holder">
            <input v-model="loginUsername" type="email" class="input" placeholder="Username" />
            <input v-model="loginPassword" type="password" class="input" placeholder="Password" />
          </div>
          <button class="submit-btn" @click="doLogin(loginUsername, loginPassword)">Log in</button>
        </div>
      </div>
    </div>
  </div>
  <FooterComponent />
</template>

<script>
import { signin, signup } from "../api";
import HeaderComponent from "@/components/HeaderComponent";
import FooterComponent from "@/components/FooterComponent";

export default {
  name: "LoginView",
  components: {
    HeaderComponent,
    FooterComponent
  },
  data() {
    return {
      loginUsername: '',
      loginPassword: '',
      signUpUsername: '',
      signUpEmail: '',
      signUpPassword: '',
      isSignUp: true
    }
  },
  methods: {
    async doLogin(username, password) {
      try {
        const { data } = await signin(username, password)
        localStorage.setItem('username', data.username)
        localStorage.setItem('accessToken', data.accessToken)
        this.$router.push('/')
      } catch (error) {
        console.error(error)
        alert('Something went wrong', error)
      }
    },
    async doSignUp(username, email, password) {
      try {
        await signup(username, email, password)
        alert('Your Sign Up was successful. You can sign in now!')
      } catch (error) {
        console.error(error)
        alert('Something went wrong', error)
      }
    }
  }
}
</script>

<style scoped>
.main {
  position: relative;
  min-height: 100vh;
  background-color: #f9eff0;
  display: flex;
  align-items: center;
  justify-content: center;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.form {
  background-color: #222;
  border-radius: 15px;
  height: 550px;
  width: 350px;
  position: relative;
  overflow: hidden;
}

.form::after {
  content: '';
  opacity: .8;
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-repeat: no-repeat;
  background-image: url("../assets/login.jpg");
  height: 100%;
  width: 100%;
  background-size: cover;
  background-position: center;
}

.form .signup {
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  width: 65%;
  z-index: 5;
  -webkit-transition: all .3s ease;
}

.form .signup.slide-up {
  top: 5%;
  -webkit-transform: translate(-50%, 0%);
  -webkit-transition: all .3s ease;
}

.form .signup.slide-up .form-holder,
.form .signup.slide-up .submit-btn {
  opacity: 0;
  visibility: hidden;
}

.form .signup.slide-up .form-title {
  font-size: 1em;
  cursor: pointer;
}

.form .signup.slide-up .form-title span {
  margin-right: 5px;
  opacity: 1;
  visibility: visible;
  -webkit-transition: all .3s ease;
}

.form .signup .form-title {
  color: #fff;
  font-size: 1.7em;
  text-align: center;
}

.form .signup .form-title span {
  color: rgba(255, 255, 255, 0.8);
  opacity: 0;
  visibility: hidden;
  -webkit-transition: all .3s ease;
}

.form .signup .form-holder {
  border-radius: 15px;
  background-color: #fff;
  overflow: hidden;
  margin-top: 50px;
  opacity: 1;
  visibility: visible;
  -webkit-transition: all .3s ease;
}

.form .signup .form-holder .input {
  border: 0;
  outline: none;
  box-shadow: none;
  display: block;
  height: 30px;
  line-height: 30px;
  padding: 8px 15px;
  border-bottom: 1px solid #eee;
  width: 100%;
  font-size: 12px;
}

.form .signup .form-holder .input:last-child {
  border-bottom: 0;
}

.form .signup .form-holder .input::-webkit-input-placeholder {
  color: rgba(0, 0, 0, 0.4);
}

.form .signup .submit-btn {
  background-color: rgba(0, 0, 0, 0.4);
  color: rgba(256, 256, 256, 0.7);
  border: 0;
  border-radius: 15px;
  display: block;
  margin: 15px auto;
  padding: 15px 45px;
  width: 100%;
  font-size: 13px;
  font-weight: bold;
  cursor: pointer;
  opacity: 1;
  visibility: visible;
  -webkit-transition: all .3s ease;
}

.form .signup .submit-btn:hover {
  transition: all .3s ease;
  background-color: rgba(0, 0, 0, 0.8);
}

.form .login {
  position: absolute;
  top: 20%;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #fff;
  z-index: 5;
  -webkit-transition: all .3s ease;
}

.form .login::before {
  content: '';
  position: absolute;
  left: 50%;
  top: -20px;
  -webkit-transform: translate(-50%, 0);
  background-color: #fff;
  width: 200%;
  height: 250px;
  border-radius: 50%;
  z-index: 4;
  -webkit-transition: all .3s ease;
}

.form .login .center {
  position: absolute;
  top: calc(50% - 10%);
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  width: 65%;
  z-index: 5;
  -webkit-transition: all .3s ease;
}

.form .login .center .form-title {
  color: #000;
  font-size: 1.7em;
  text-align: center;
}

.form .login .center .form-title span {
  color: rgba(0, 0, 0, 0.4);
  opacity: 0;
  visibility: hidden;
  -webkit-transition: all .3s ease;
}

.form .login .form-holder {
  border-radius: 15px;
  background-color: #fff;
  border: 1px solid #eee;
  overflow: hidden;
  margin-top: 50px;
  opacity: 1;
  visibility: visible;
  -webkit-transition: all .3s ease;
}

.form .login .form-holder .input {
  border: 0;
  outline: none;
  box-shadow: none;
  display: block;
  height: 30px;
  line-height: 30px;
  padding: 8px 15px;
  border-bottom: 1px solid #eee;
  width: 100%;
  font-size: 12px;
}

.form .login .form-holder .input:last-child {
  border-bottom: 0;
}

.form .login .form-holder .input::-webkit-input-placeholder {
  color: rgba(0, 0, 0, 0.4);
}

.form .login .submit-btn {
  background-color: #6B92A4;
  color: rgba(256, 256, 256, 0.7);
  border: 0;
  border-radius: 15px;
  display: block;
  margin: 15px auto;
  padding: 15px 45px;
  width: 100%;
  font-size: 13px;
  font-weight: bold;
  cursor: pointer;
  opacity: 1;
  visibility: visible;
  -webkit-transition: all .3s ease;
}

.form .login .submit-btn:hover {
  transition: all .3s ease;
  background-color: rgba(0, 0, 0, 0.8);
}

.form .login.slide-up {
  top: 90%;
  -webkit-transition: all .3s ease;
}

.form .login.slide-up .center {
  top: 10%;
  -webkit-transform: translate(-50%, 0%);
  -webkit-transition: all .3s ease;
}

.form .login.slide-up .form-holder,
.form .login.slide-up .submit-btn {
  opacity: 0;
  visibility: hidden;
  -webkit-transition: all .3s ease;
}

.form .login.slide-up .form-title {
  font-size: 1em;
  margin: 0;
  padding: 0;
  cursor: pointer;
  -webkit-transition: all .3s ease;
}

.form .login.slide-up .form-title span {
  margin-right: 5px;
  opacity: 1;
  visibility: visible;
  -webkit-transition: all .3s ease;
}
</style>