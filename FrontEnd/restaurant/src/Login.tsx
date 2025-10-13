import { useNavigate } from "react-router-dom";
import { useUserLogin } from "./hooks/useUserLogin";
import { useState } from "react";
import React from "react";
import "./Login.css";
export function Login(){
    const[login,setLogin]=useState("");
    const[password,setPassword]=useState("");
    const navigate = useNavigate();
    const { mutate,isSuccess, isError } = useUserLogin();

    const handleSubmit=(e:React.FormEvent)=>{
        e.preventDefault();

    const userLogin = { login, password };
    mutate(userLogin);
    
   
    if (isSuccess) navigate("/cardapio");}


    return(
        <div className="Login-Container">
            <h2>Faça seu login:</h2>
            <form className="login-form" onSubmit={handleSubmit}>
            <input
            type="text"
            placeholder="Login"
            value={login}
            onChange={(e) => setLogin(e.target.value)}
          />
         
          <input
            type="password"
            placeholder="Senha"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button type="submit" className="login-btn">
            Entrar
          </button>
        </form>
        {isError && <p style={{ color: "red" }}>Erro ao logar usuário</p>}
        {isSuccess && <p style={{ color: "green" }}>Login realizado com sucesso!</p>}
  
        </div>
    )
}