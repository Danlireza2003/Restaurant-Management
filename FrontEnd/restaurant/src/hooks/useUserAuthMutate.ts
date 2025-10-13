import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { type AxiosPromise } from "axios"
import type{ UserData } from '../interface/UserData';
import type { JwtResponse } from "../interface/jwtResponse";

const API_URL = 'http://localhost:8080';

const postData = async (data: UserData): AxiosPromise<JwtResponse> => {
    const response = axios.post(API_URL + '/users/register', data);
    return response;
}
export function useUserAuthMutate(onSuccessCallback: () => void){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ['user-register'] })
            onSuccessCallback(); 
            console.log("Cadastro realizado com sucesso!");
        },
        onError: (error) => {
            console.error("Erro ao registrar usuário:", error);
          },
    })

    return mutate;
}