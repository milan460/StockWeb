import { getStockData } from "./services/stockDataService";
import { useEffect, useState } from "react";

function App() {
  const [stockData, setStockData] = useState([]);

  useEffect( () => {
      getStockData().then( (res) => setStockData(res.data));
      
  }, []);

  return (
    <main className="App">
      <div>
      </div>
    </main>
  );
}

export default App;
