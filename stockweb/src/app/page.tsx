"use client"
import Image from 'next/image'
import HomePage from "./pages/index"
import StockSearchResult from './components/StockSearchResult'

export default function Home() {
  return (
    <div>
      <HomePage/>
      <StockSearchResult/>
    </div>
  )
}
