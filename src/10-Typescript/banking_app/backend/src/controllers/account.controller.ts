import { Request, Response } from 'express';
import { AccountService } from '../services/account.service'; // Adjust path as needed

// Create a single instance of the service to use across routes
const accountService = new AccountService();

export const getAccountDetails = (req: Request, res: Response): void => {
    try {
        const details = accountService.getUserDetails();
        res.status(200).json({ success: true, data: details });
    } catch (error) {
        res.status(500).json({ success: false, message: "Error fetching details" });
    }
};

export const withdrawAmount = (req: Request, res: Response): void => {
    try {
        const { amount } = req.body;
        
        if (!amount || typeof amount !== 'number') {
            res.status(400).json({ success: false, message: "Invalid amount" });
            return;
        }

        accountService.withdraw(amount);
        res.status(200).json({ success: true, message: `Successfully withdrew ${amount}` });
    } catch (error) {
        res.status(500).json({ success: false, message: "Withdrawal failed" });
    }
};

export const depositAmount = (req: Request, res: Response): void => {
    try {
        const { amount } = req.body;

        if (!amount || typeof amount !== 'number') {
            res.status(400).json({ success: false, message: "Invalid amount" });
            return;
        }

        accountService.deposit(amount);
        res.status(200).json({ success: true, message: `Successfully deposited ${amount}` });
    } catch (error) {
        res.status(500).json({ success: false, message: "Deposit failed" });
    }
};
