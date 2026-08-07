import React, { useState } from 'react';
import Account from '../components/Account';
import TransactionHistory from './../components/TransactionHistory';

export default function DashboardPage() {
  const [balance, setBalance] = useState(1000);
  const [history, setHistory] = useState([]);

  const handleTransaction = (type, amount) => {
    // Update balance state
    if (type === 'Debit') setBalance(prev => prev - amount);
    if (type === 'Credit') setBalance(prev => prev + amount);

    // Update history state array
    const newRecord = {
      id: Date.now(),
      type: type,
      amount: amount,
      time: new Date().toLocaleTimeString()
    };
    setHistory(prevHistory => [newRecord, ...prevHistory]);
  };

  return (
    <div style={{ background: '#121214', color: '#fff', padding: '20px', minHeight: '80vh' }}>
      <h2>Dashboard View</h2>
      <p>Welcome to your central banking command node.</p>
      
      {/* Prop Drilling down into child UI elements */}
      <Account 
        balance={balance} 
        bank="State Bank of India" 
        onTransaction={handleTransaction} 
      />
      
      <TransactionHistory history={history} />
    </div>
  );
}
