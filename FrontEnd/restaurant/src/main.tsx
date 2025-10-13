import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { Register } from './Register'
import {Login} from './Login'

const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
    <BrowserRouter>
        <Routes>
          {/* Página inicial será o registro */}
          <Route path="/" element={<Register />} />

          {/* Página de login */}
          <Route path="/login" element={<Login/>} />

          {/* Página principal do cardápio */}
          <Route path="/cardapio" element={<App/>} />
        </Routes>
      </BrowserRouter>
    </QueryClientProvider>
  </React.StrictMode>,
)