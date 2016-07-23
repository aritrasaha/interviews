**Scenario:**
- Imagine you are in charge of Github's API
- GitHub has a public API to search for repositories, users, etc
- This API has strict rate limits applied to it
- Otherwise clients can crawl indiscriminately
- The rate limits are different for authenticated & unauthenticated users. (Anonymous users have a much lower rate at which they can call the API)

**Problem statement:**
- Build a similar rate limiting implementation on your framework of choice. (Anything you are familiar with)
- The actual rate limit should be a configurable parameter, not hard-coded
- The consumer of the service should get a `403 Forbidden` response in case they invoke the API too often.
- The API response should mention the current rate limit, and the number of calls available for the client.

**Expected output:**
- A working API Server, with a few stub API endpoints that have rate limits applied.
- External test cases (HTTP based test case) that will demonstrate that the rate limiting is actually applied.
