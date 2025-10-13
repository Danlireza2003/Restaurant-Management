import { useMutation,useQueryClient} from "@tanstack/react-query";
import axios, { type AxiosPromise } from "axios";
import type { UserLoginData } from "../interface/UserLoginData";
import type { JwtResponse } from "../interface/jwtResponse";

const API_URL = 'http://localhost:8080';

const postData = async (data: UserLoginData): AxiosPromise<JwtResponse> => {
    const response = axios.post(API_URL + '/users/login', data);
    return response;
}

export function useUserLogin(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: (Response) => {
            const jwt  = Response.data.token;
            localStorage.setItem('token', jwt);
            console.log("Login realizado com sucesso! Token salvo");
            queryClient.invalidateQueries({ queryKey: ['user-login'] })
        },
        onError: (error) => {
            console.error("Erro ao fazer login:", error);
          },
    })

    return mutate;
}