import Link from 'next/link';
import { useState } from 'react';

const HomePage = () => {
    const [searchQuery, setSearchQuery] = useState('');

    const handleSearch = () => {
        //handle the search logic here
    }

    return (
        <div>
            <h1>HomePage</h1>
            <input type="text"
                placeholder='Search...'
                value={searchQuery} 
                onChange={(e) => setSearchQuery(e.target.value)}
            />
            <Link href={`/search-results?query=${searchQuery}`}>
                <button onClick={handleSearch}>Search</button>
            </Link>
        </div>
    )
    
}

export default HomePage;