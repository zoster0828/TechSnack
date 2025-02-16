# Agile Testing Pyramid in the Web Server Business Project

This document briefly outlines how we applied an **Agile Testing Pyramid** strategy to our web server business project. It includes collaboration with an **external core domain** (previously referred to as a “model” or ML/AI server) and an **external domain** (previously “OB”), plus a sample Gantt chart demonstrating 1st and 2nd Shadow Tests for final verification.

---

## 1. Agile Testing Pyramid Overview

1. **Unit Tests**
   - **Bottom layer**: Validate small, isolated logic (classes/functions).
   - Fast execution, uses mocks/stubs, aims for high coverage (e.g., 95%+).

2. **Integration Tests**
   - **Middle layer**: Check interactions with DB, external APIs, third-party libraries, etc.
   - Ensures correct data flow and interface alignment.

3. **End-to-End (E2E) / Acceptance Tests**
   - **Top layer**: Simulate complete user journeys.
   - Covers UI + business logic + external services.

---

## 2. Testing Phases and Sequence

### 2.1 Development & Unit Tests
- Develop core functionalities, immediately write unit tests for each class/method.
- Catch logic errors early, maintain stable refactoring.

### 2.2 External Core Domain Integration & 1st Shadow Test
- Implement minimal code to communicate with the external core domain (ML/AI, previously “model”).
- **1st Shadow Test**: Duplicate real production traffic to test functionality and performance of the external core domain in a safe “shadow” environment.
- The external core domain team fixes issues without impacting live operations.

### 2.3 Use Case BDD & Adapter (External Domain) Integration Tests
- **Use Case BDD**: “Given-When-Then” acceptance tests to verify core business requirements.
- **Adapter Integration**:
   - Check DB, external APIs (including the external core domain) and especially align with the **external domain** team’s interface (request/response format, authentication).
   - Early detection and resolution of integration issues.

### 2.4 Frontend Mocking for E2E
- Before or alongside actual frontend development, create a mocked UI to simulate user interactions with the backend.
- Quickly spot data format or interface mismatches, fix them early.

### 2.5 Final Frontend Integration & Visualization
- Replace the mocked UI with the real frontend, running full E2E scenarios.
- **Visualization**: Validate how data from the external core domain (ML/AI) appears on the UI. Provide feedback on functionality or UX to that team.
- Confirm seamless interaction with the **external domain** in real user flows; address any final bugs.

### 2.6 2nd Shadow Test (Final Verification)
- After fully integrating all features, conduct a **2nd Shadow Test** to confirm final performance and stability.
- Use real traffic duplication again, checking for any unforeseen issues in the external core domain or the external domain integrations.
- Resolve any last-minute performance bottlenecks or response errors prior to production deployment.

---

## 3. Sample Gantt Chart

| **Tasks**                                                           | W1  | W2  | W3  | W4  | W5  | W6  | W7  |
| ------------------------------------------------------------------- |:--: |:--: |:--: |:--: |:--: |:--: |:--: |
| **1. Dev & Unit Tests**                                            | ■■  | ■■  |     |     |     |     |     |
| **2. External Core Domain Integration & 1st Shadow Test**           |     | ■■  | ■■  |     |     |     |     |
| **3. Use Case BDD & Adapter (External Domain) Integration Tests**   |     |     | ■■  | ■■  | ■■  |     |     |
| **4. Frontend Mocking for E2E**                                     |     |     |     | ■■  | ■■  |     |     |
| **5. Final Frontend Integration & Visualization**                   |     |     |     |     | ■■  | ■■  |     |
| **6. 2nd Shadow Test (Final Verification)**                         |     |     |     |     |     | ■■  | ■■  |

> **■** indicates the period of active work.

---

## 4. Advantages

1. **Layered, Incremental Testing**
   - Detect issues early at the unit level, then in integration, then finalize with E2E and shadow tests.
2. **Better Collaboration**
   - **External Core Domain**: 1st and 2nd Shadow Tests use real traffic to pinpoint performance or functional issues.
   - **External Domain**: Adapter integration tests reveal compatibility or format problems early.
3. **Efficient Frontend-Backend Parallel**
   - Frontend mocking avoids “big-bang” integration late in development.
   - Early bug fixes reduce large-scale refactoring.
4. **Operational Stability**
   - Two-phase Shadow Testing ensures minimal issues once in production.
   - Realistic traffic duplication highlights performance bottlenecks or response errors.

---

## 5. Conclusion & Next Steps
- **Automate** all levels (Unit, Integration, E2E, Shadow Tests) in CI/CD pipelines.
- **Contract Testing** (e.g., Pact) for the external domain to ensure backward compatibility.
- **Continuous Collaboration**: Keep external core domain (ML/AI) and external domain teams fully updated on any interface changes.

By combining the **Agile Testing Pyramid** with **two-stage Shadow Testing** and **frontend mocking**, we can deliver high-quality, low-risk releases and continuously improve the service.

