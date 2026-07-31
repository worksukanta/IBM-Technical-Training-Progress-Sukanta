========================================================================
                 SPRING SECURITY ROUTING & FLOW GUIDE
========================================================================

------------------------------------------------------------------------
1. ENDPOINT TESTING MATRIX
------------------------------------------------------------------------
Test these routes in your browser to verify how access permissions change 
depending on who logs in.

Mock Account Profiles:
  • Regular User  ->  Username: regularuser  |  Password: password123
  • Administrator ->  Username: sysadmin     |  Password: admin456

---
ROUTE A: Public Endpoint
URL: http://localhost:8080/api/public/info
  • Anonymous Guest -> ALLOWED (200 OK - No credentials requested)
  • Regular User    -> ALLOWED (200 OK)
  • Administrator   -> ALLOWED (200 OK)
---
ROUTE B: Protected User Dashboard
URL: http://localhost:8080/api/user/dashboard
  • Anonymous Guest -> PROMPTED (Forces you to enter a login)
  • Regular User    -> ALLOWED (200 OK - Standard dashboard view)
  • Administrator   -> ALLOWED (200 OK - Admins inherit user rights)
---
ROUTE C: Restricted Admin Settings
URL: http://localhost:8080/api/admin/settings
  • Anonymous Guest -> PROMPTED (Forces you to enter a login)
  • Regular User    -> DENIED  (403 Forbidden - Insufficient role permissions)
  • Administrator   -> ALLOWED (200 OK - Management panel unlocked)
---
ROUTE D: Restricted Admin Actuators
URL: http://localhost:8080/actuator
  • Anonymous Guest -> PROMPTED (Forces you to enter a login)
  • Regular User    -> DENIED  (403 Forbidden - Insufficient role permissions)
  • Administrator   -> ALLOWED (200 OK - Actuator Route accessed)


------------------------------------------------------------------------
2. ARCHITECTURAL FLOW: WHAT IS HAPPENING UNDER THE HOOD
------------------------------------------------------------------------
When a web browser targets a URL in this application, it executes 
through a structural four-stage lifecycle pipeline:

[ Incoming HTTP Request ]
          │
          ▼
┌──────────────────────────────────────────────────────────────────────┐
│ STEP 1: Custom Filter Interception (CustomLoggingFilter)             │
│ Your custom component catches the raw request immediately. It reads  │
│ the HTTP method type (GET) and target URI path, prints them into the │
│ system terminal stdout logs, then forwards execution.                │
└──────────────────────────────────────────────────────────────────────┘
          │
          ▼
┌──────────────────────────────────────────────────────────────────────┐
│ STEP 2: Credential Verification (Authentication)                    │
│ The request hits UsernamePasswordAuthenticationFilter. If user info  │
│ is provided, Spring checks the data against the custom BCrypt hashed │
│ records stored inside your local InMemoryUserDetailsManager bean.    │
└──────────────────────────────────────────────────────────────────────┘
          │
          ▼
┌──────────────────────────────────────────────────────────────────────┐
│ STEP 3: Role & Boundary Checking (Authorization)                     │
│ The FilterSecurityInterceptor reads the security rules set up inside │
│ your SecurityFilterChain bean configuration. It compares the target  │
│ URL path requirements against the verified user's assigned roles     │
│ (e.g., checking if the user holds ROLE_ADMIN for the admin route).   │
└──────────────────────────────────────────────────────────────────────┘
          │
          ▼
┌──────────────────────────────────────────────────────────────────────┐
│ STEP 4: Target Controller Resource Execution                         │
│ If validation clears, traffic safely exits the security filter chain │
│ and lands on DemoController.java to build and return the JSON string.│
└──────────────────────────────────────────────────────────────────────┘
          │
          ▼
[ Outgoing HTTP Response (Returns through CustomLoggingFilter for Status Log) ]

========================================================================
