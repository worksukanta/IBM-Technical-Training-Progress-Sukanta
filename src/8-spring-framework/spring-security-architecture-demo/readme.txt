========================================================================
             SPRING SECURITY SYSTEM COMPONENT ARCHITECTURE GUIDE
========================================================================

------------------------------------------------------------------------
1. ENDPOINT TESTING MATRIX
------------------------------------------------------------------------
Test these routes in your browser to observe how components interact 
based on the provided credentials.

Mock Database Account Profiles:
  • Standard Account -> Username: john_doe   | Password: pass123
  • Management Entry -> Username: admin_user | Password: admin123

---
ROUTE A: Public Status Portal
URL: http://localhost:8080/api/public/status
  • Execution Behavior: 
    Bypasses authentication filters entirely. Returns a simple text string 
    immediately without triggering internal database lookups.
---
ROUTE B: Thread-Context Secured Profile
URL: http://localhost:8080/api/secure/profile
  • Execution Behavior:
    1. Triggers an HTTP Basic authentication login prompt.
    2. Enter "john_doe" and "pass123" to verify matching database hashes.
    3. Returns a JSON payload showing details extracted from system memory:
       {
         "assignedRoles": "[ROLE_USER]",
         "extractedUsername": "john_doe",
         "verificationStatus": true,
         "message": "Access approved via active token details"
       }

------------------------------------------------------------------------
2. COMPONENT STEP-BY-STEP BREAKDOWN: HOW THEY ENTER THE PICTURE
------------------------------------------------------------------------
When you hit a protected URL, each core security bean takes turns 
processing the data request in a strict chain-of-custody order:

[ Incoming Request with Credentials Header ]
                    │
                    ▼
┌──────────────────────────────────────────────────────────────────────┐
│ COMPONENT 1: AuthenticationManager (Entrypoint Coordinator)         │
│ • What it does: Acts as the structural manager of the process.       │
│ • How it enters: It receives the unverified username and password,   │
│   packs them into an Authentication object, and delegates execution  │
│   to a specialized provider that handles credential matching.        │
└──────────────────────────────────────────────────────────────────────┘
                    │
                    ▼
┌──────────────────────────────────────────────────────────────────────┐
│ COMPONENT 2: AuthenticationProvider (The Logic Engine)               │
│ • What it does: Orchestrates credential verification.                │
│ • How it enters: It manages the login check steps by first calling   │
│   the data layer to retrieve the user's records, and then calling   │
│   the hashing engine to verify the password.                         │
└──────────────────────────────────────────────────────────────────────┘
                    │
          ┌─────────┴─────────┐
          ▼                   ▼
┌──────────────────────────────────┐ ┌─────────────────────────────────┐
│ COMPONENT 3: UserDetailsService  │ │ COMPONENT 4: PasswordEncoder    │
│ (The Database Bridge)            │ │ (The Cryptographic Hashing Bean)│
│ • What it does: Fetches metadata.│ │ • What it does: Matches strings.│
│ • How it enters: The Provider    │ │ • How it enters: The Provider   │
│   calls this service to look up  │ │   passes the raw text password  │
│   the user record from memory or │ │   and the database hash to this │
│   a database, returning it as a  │ │   bean to verify if they match, │
│   clean UserDetails object.      │ │   using a safe algorithm.       │
└──────────────────────────────────┘ └─────────────────────────────────┘
          │                   │
          └─────────┬─────────┘
                    │
        [ Valid Match Confirmed ]
                    │
                    ▼
┌──────────────────────────────────────────────────────────────────────┐
│ COMPONENT 5: SecurityContextHolder (Global Thread Registry)          │
│ • What it does: Keeps track of the currently logged-in user.         │
│ • How it enters: Once the password check passes, the provider stores │
│   the verified identity token here. The REST controller can then     │
│   safely pull this data at any point during the request lifecycle.   │
└──────────────────────────────────────────────────────────────────────┘
                    │
                    ▼
[ Target Controller Execution -> Renders Secure JSON Data Output ]

========================================================================
