import axios from 'axios';

const AuthUrl = 'http://localhost:8081/api/auth';

const GatewayUrl = 'http://localhost:9292';

export const supportedCurrencies = {
    EUR: 'EUR',
    USD: 'USD',
    RUB: 'RUB',
    YEN: 'YEN',
    CNY: 'CNY'
}

export const signin = async (username, password) => {
    try {
        return axios.post(AuthUrl + '/signin', {
            username: username,
            password: password
        })
    } catch (error) {
        console.log(error)
    }
}

export const signup = async (username, email, password) => {
    try {
        return axios.post(AuthUrl + '/signup', {
            username: username,
            email: email,
            password: password
        })
    } catch (error) {
        console.log(error)
    }
}

export const getProducts = async () => {
    try {
        return axios.get(GatewayUrl + '/services/product/products')
    } catch (error) {
        console.log(error)
    }
}

export const getProductsByUser = async (username) => {
    try {
        return axios.get(GatewayUrl + '/services/product/userProducts/' + username)
    } catch (error) {
        console.log(error)
    }
}

export const getProductById = async (id) => {
    try {
        return axios.get(GatewayUrl + '/services/product/getProduct/' + id)
    } catch (error) {
        console.log(error)
    }
}

export const createNewProduct = async (name, description, teig, size, fill, glasur, extras) => {
    const userName = localStorage.getItem('username')
    try {
        return axios.post(GatewayUrl + '/services/product/createNewProduct', {
            name, size, teig, fill, glasur, extras, description, userName
        })
    } catch (error) {
        console.log(error)
    }
}

export const getComponents = async () => {
    try {
        return axios.get(GatewayUrl + '/services/product/components')
    } catch (error) {
        console.log(error)
    }
}

export const changeCurrency = async (from, to, amount) => {
    try {
        const { data } = await axios.post(`${GatewayUrl}/services/currency/${from}/${to}/${amount}`, {})
        localStorage.setItem('currency', to)
        return data
    } catch (error) {
        console.log(error)
    }
}