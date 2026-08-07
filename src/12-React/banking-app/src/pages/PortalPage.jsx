import React from 'react';
import Account from '../Components/Account';
import './PortalPage.css';

export default function PortalPage({ balance, onTransaction }) {
  return (
    <div className="portal-container">
      <h2 className="portal-title">Mutation Vault</h2>
      <p className="portal-desc">Perform direct operations on your accounts.</p>
      <Account balance={balance} bank="State Bank of India" onTransaction={onTransaction} />
    </div>
  );
}
