import React, { useState, useEffect, useCallback } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Pages/Home';
import PortalPage from './Pages/PortalPage';
import AllTransactionsPage from './Pages/AllTransactionsPage';
import './App.css';

export default function App() {
  // HOOK: useState with functional initialization to load data from LocalStorage
  const [balance, setBalance] = useState(() => {
    const savedBalance = localStorage.getItem('felu_balance');
    return savedBalance ? parseFloat(savedBalance) : 1000;
  });

  const [history, setHistory] = useState(() => {
    const savedHistory = localStorage.getItem('felu_history');
    return savedHistory ? JSON.parse(savedHistory) : [];
  });

  // HOOK: useEffect to auto-save balance and ledger when global state shifts
  useEffect(() => {
    localStorage.setItem('felu_balance', balance);
  }, [balance]);

  useEffect(() => {
    localStorage.setItem('felu_history', JSON.stringify(history));
  }, [history]);

  // HOOK: useCallback memoizes the transaction handler so it isn't recreated on every render
  const handleTransaction = useCallback((type, amount) => {
    if (type === 'Debit') setBalance(prev => prev - amount);
    if (type === 'Credit') setBalance(prev => prev + amount);

    const newRecord = {
      id: Date.now(),
      type: type,
      amount: amount,
      time: new Date().toLocaleTimeString()
    };
    setHistory(prevHistory => [newRecord, ...prevHistory]);
  }, []);

  const clearLedger = useCallback(() => {
    setBalance(1000);
    setHistory([]);
  }, []);

  return (
    <BrowserRouter>
      <header className="bank-header">
        <h1 className="bank-logo">Felu Bank Engine</h1>
        <nav className="bank-nav">
          <Link to="/" className="nav-link">[ HOME ]</Link>
          <Link to="/portal" className="nav-link">[ PORTAL ]</Link>
          <Link to="/all-transactions" className="nav-link">[ LEDGER ]</Link>
        </nav>
      </header>

      <main className="main-content">
        <Routes>
          <Route path="/" element={<Home balance={balance} history={history} />} />
          <Route path="/portal" element={<PortalPage balance={balance} onTransaction={handleTransaction} />} />
          <Route path="/all-transactions" element={<AllTransactionsPage history={history} onClear={clearLedger} />} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}
