import React from 'react';
import TransactionHistory from '../Components/TransactionHistory';
import './AllTransactionsPage.css';

export default function AllTransactionsPage({ history, onClear }) {
  return (
    <div className="ledger-container">
      <div className="ledger-header-block">
        <h2 className="ledger-title">System Audit Vault</h2>
        {history.length > 0 && (
          <button onClick={onClear} className="clear-btn">WIPE ALL TRANSACTIONS</button>
        )}
      </div>
      <TransactionHistory history={history} />
    </div>
  );
}
