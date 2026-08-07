import React from 'react';
import './TransactionHistory.css';

export default function TransactionHistory({ history }) {
  return (
    <ul className="history-list">
      {history.map((tx) => (
        <li 
          key={tx.id} 
          className={`history-item ${tx.type === 'Credit' ? 'credit-type' : 'debit-type'}`}
        >
          <span>[{tx.type}] Rs. {tx.amount}</span>
          <span className="history-time">{tx.time}</span>
        </li>
      ))}
      {history.length === 0 && (
        <p style={{ color: '#444', fontFamily: 'monospace' }}>Empty stream.</p>
      )}
    </ul>
  );
}
