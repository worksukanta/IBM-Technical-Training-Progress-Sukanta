import { Router } from 'express';
import { 
    getAccountDetails, 
    withdrawAmount, 
    depositAmount 
} from '../controllers/account.controller'; // Adjust path as needed

const router = Router();

// GET /api/account
router.get('/', getAccountDetails);

// POST /api/account/withdraw
router.post('/withdraw', withdrawAmount);

// POST /api/account/deposit
router.post('/deposit', depositAmount);

export default router;
