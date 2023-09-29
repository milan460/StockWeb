import { useRouter } from "next/router";
import { useState } from "react";

const StockSearchResult = () => {
    const router = useRouter();
    const { query } = router.query

    //fetch the api

    return (
        <div>
            <h1>Search Result for {query}</h1>

        </div>
    )
};

export default StockSearchResult;