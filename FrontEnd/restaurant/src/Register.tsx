import { useState } from "react"
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import "./Register.css"
import { useUserAuthMutate } from "./hooks/useUserAuthMutate";
import { type FormEvent } from "react";

export function Register(){
    const[login,setLogin]=useState("");
    const[email,setEmail]=useState("");
    const[password,setPassword]=useState("");
    const navigate = useNavigate();

    
    const handleSuccess = () => {
        navigate("/login");
    };
    const { mutate,isSuccess, isError } = useUserAuthMutate(handleSuccess);

    const handleSubmit=(e:FormEvent)=>{
        e.preventDefault();

    const newUser = { login, email, password };
    mutate(newUser);

   
   

    }
    return(<div className="register-container">
        <h1>Restaurant Management System</h1>
        <h2>Crie sua conta:</h2>
        
       
        <form className="register-form" onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Login"
            value={login}
            onChange={(e) => setLogin(e.target.value)}
          />
          <input
            type="email"
            placeholder="E-mail"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            type="password"
            placeholder="Senha"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button type="submit" className="register-btn">
            Registrar
          </button>
        </form>
        {isError && <p style={{ color: "red" }}>Erro ao registrar usuário</p>}
        {isSuccess && <p style={{ color: "green" }}>Cadastro realizado com sucesso!</p>}
  
        <p className="redirect-text">
          Já tem conta?{" "}
          <Link to="/login" className="login-link">
            Faça login
          </Link>
        </p>
      </div>

    )


}