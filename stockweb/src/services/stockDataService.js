import axios from "axios";

const client = axios.create({
    baseURL: "http://localhost:8080/stock"
});

export const getStockData = () => {
        return client.get('/TSLA')
    };
