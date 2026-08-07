import React, { useMemo } from 'react';
import { Link } from 'react-router-dom';
import TransactionHistory from '../Components/TransactionHistory';
import './Home.css';

export default function Home({ balance, history }) {
  // HOOK: useMemo calculates financial metrics. Only re-computes if the history array shifts.
  const stats = useMemo(() => {
    let income = 0;
    let expenses = 0;
    history.forEach(tx => {
      if (tx.type === 'Credit') income += tx.amount;
      if (tx.type === 'Debit') expenses += tx.amount;
    });
    return { income, expenses };
  }, [history]);

  const recentHistory = useMemo(() => history.slice(0, 5), [history]);

  return (
    <div className="home-container">
      <h2 className="home-title">Felu Banking Terminal</h2>
      <p className="home-subtitle">Central telemetry monitor network.</p>
      
      <div className="balance-card">
        <span className="balance-label">TOTAL CURRENT FUNDS</span>
        <strong className="balance-display">Rs. {balance}</strong>
      </div>

      <div className="analytics-grid">
        <div className="metric-box income">
          <div className="metric-title">TOTAL CREDITED</div>
          <div className="metric-value" style={{ color: '#00ff66' }}>Rs. {stats.income}</div>
        </div>
        <div className="metric-box expense">
          <div className="metric-title">TOTAL DEBITED</div>
          <div className="metric-value" style={{ color: '#ff3b30' }}>Rs. {stats.expenses}</div>
        </div>
      </div>

      <div>
        <Link to="/portal">
          <button className="counter credit-amount">Access Transaction Nodes</button>
        </Link>
      </div>

      <div className="recent-wrapper">
        <h4 className="recent-title">LOG STREAM // RECENT OPERATIONS</h4>
        <TransactionHistory history={recentHistory} />
      </div>
    </div>
  );
}
