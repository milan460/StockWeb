import axios from "axios";

export default{

    getStockData(){
        return axios.get('/stock/TSLA');
    }
}