import axios from "axios";
import {API_BASE_URL, API_LOGIN} from "../consts/Consts";

export const userApi = {
    login
}

function login(email, password) {

    const loginRequest = {
        "email": email,
        "password": password
    };

    return instance.post(
        API_LOGIN,
        loginRequest,
        {
            headers: {'Content-type': 'application/json'}
        })
}


const instance = axios.create({
    baseURL: API_BASE_URL
})

instance.interceptors.request.use(function (config) {
    // If token is expired, redirect user to login
    if (config.headers.Authorization) {
        const token = config.headers.Authorization.split(' ')[1]
        const data = parseJwt(token)
        if (Date.now() > data.exp * 1000) {
            window.location.href = "/login"
        }
    }
    return config
}, function (error) {
    return Promise.reject(error)
})

export function parseJwt(token) {
    if (!token) {
        return
    }
    const base64Url = token.split('.')[1]
    const base64 = base64Url.replace('-', '+').replace('_', '/')
    return JSON.parse(window.atob(base64))
}