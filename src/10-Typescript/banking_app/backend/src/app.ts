import express from 'express';
import accountRouter from './routes/account.routes'; // No extension needed!

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware to parse incoming JSON payloads
app.use(express.json());

// Mount your account routes under the /api/account namespace
app.use('/api/account', accountRouter);

// Simple root health-check route
app.get('/', (req, res) => {
    res.status(200).json({ status: "healthy", message: "Server is running!" });
});

// Start the server
app.listen(PORT, () => {
    console.log(`🚀 Server successfully running on http://localhost:${PORT}`);
});

export default app;
