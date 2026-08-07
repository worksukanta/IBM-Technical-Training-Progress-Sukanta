import React, { useState, useRef } from 'react';
import './Account.css'; 

export default function Account({ balance, bank, onTransaction }) {
  const [alert, setAlert] = useState("");
  const [amount, setAmount] = useState(100);
  
  // HOOK: useRef references the HTML element tree directly
  const inputRef = useRef(null);

  const getTransactionAmount = () => {
    const parsed = parseFloat(amount);
    if (isNaN(parsed) || parsed <= 0) {
      setAlert("Please enter a valid positive amount!");
      return 0;
    }
    return parsed;
  };

  const executeAction = (type) => {
    const value = getTransactionAmount();
    if (value === 0) return;

    if (type === 'Debit' && balance < value) {
      setAlert("Insufficient balance!");
    } else {
      setAlert("");
      onTransaction(type, value);
      
      // 💡 UX FIX: Check if the user is on a mobile screen before forcing focus
      // 'window.matchMedia' detects if the device relies on hover capabilities (like a mouse pointer)
      const isMobile = window.matchMedia("(max-width: 768px)").matches || 
                      ('ontouchstart' in window);

      if (inputRef.current && !isMobile) {
        inputRef.current.focus(); // Only auto-focus on Desktops/Laptops
      } else if (inputRef.current && isMobile) {
        inputRef.current.blur();  // Force mobile keyboards to close cleanly
      }
    }
  };

  return (
    <>
      <div>
        <h3>{bank}</h3>
        <p style={{ fontFamily: 'monospace' }}>Balance: <code>Rs. {balance}</code></p>
      </div>

      {alert && <p className="alert">{alert}</p>}

      <div className="amount-container">
        <label htmlFor="amount-input" className="amount-label">ENTER MUTATION AMOUNT: </label>
        <input
          id="amount-input"
          className="amount-field"
          type="number"
          min="1"
          ref={inputRef} /* 👈 Mapping hook connection directly to DOM element Node */
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
      </div>

      <div className="button-group">
        <button type="button" className="debit-amount counter" onClick={() => executeAction('Debit')}>
          Debit Amount
        </button>
        <button type="button" className="credit-amount counter" onClick={() => executeAction('Credit')}>
          Credit Amount
        </button>
      </div>
    </>
  );
}
