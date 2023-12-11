<template>
  <div class="container">
        <div class="titlecontainer">
            <div class="title">
                <h1>{{ stockObject.name }}</h1>
            </div>
            <div class="priceContainer">
                <div class="regularMarket">
                    Regular Market Price: {{ stockObject.regularMarketPrice }}
                    <span v-bind:style="{ color: stockObject.regularPriceChange.includes('+') ? 'green' : 'white' }">{{ stockObject.regularPriceChange }}</span>
                </div>
                <div class="postMarket">
                    Post Market Price: {{ stockObject.postMarketPrice }}
                    <span v-bind:style="{ color: stockObject.postMarketChange.includes('+') ? 'green' : 'white' }">{{ stockObject.postMarketChange }}</span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column">
                <table>
                    <tbody>
                        <tr>
                            <td>stock</td>
                            <td>asdjaksdasdasdasd</td>
                        </tr>
                        <tr>
                            <td>stock</td>
                            <td>asdjaksdasdasdasd</td>
                        </tr>
                        <tr>
                            <td>stock</td>
                            <td>asdjaksdasdasdasd</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="column">
                <table>
                    <tbody>
                        <tr>
                            <td>stock</td>
                            <td>asdjaksdasdasdasd</td>
                        </tr>
                        <tr>
                            <td>stock</td>
                            <td>asdjaksdasdasdasd</td>
                        </tr>
                        <tr>
                            <td>stock</td>
                            <td>asdjaksdasdasdasd</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
  </div>
</template>

<script>
import stockData from "../services/StockDataService.js";
export default {
    data(){
        return{
            stockObject: ""
        }
    },
    created(){
        stockData.getStockData().then( (res) => {
            this.stockObject = res.data
            console.log(this.stockObject)
        })
    }
}
</script>

<style>
* {
    box-sizing: border-box;
}
.container{
    width: auto;
    height: auto;
    background-color: white;
    margin: 10px auto;
    margin-top: 30px;
    border-radius: 10px;
    padding-top: 20px;
    padding-bottom: 10px;
    box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px;
}

.title{
    text-align: center;
}
.priceContainer{
    text-align: center;
}
.regularMarket{
    align-content: center;
    font-size: 20px;
    margin-right: 100px;
    display: inline-block;
}
.postMarket{
    display: inline-block;
}
.row{
    display: flex;
    margin-left: -5px;
    margin-right: -5px;
    border: 1px solid #b4b4b4;
    
}
.column{
    flex: 50%;
    padding: 5px;
}
table{
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
}
td{
    text-align: left;
    padding: 16px;
}
tr:nth-child(even){
    background-color: #f2f2f2;
}


</style>