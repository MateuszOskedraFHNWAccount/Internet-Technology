# Educational Peer Exchange Platform for Fachhochschule Nordwestschweiz Students (EduPeerFHNW)

This project aims to facilitate a peer-to-peer learning and support environment for students at the Fachhochschule Nordwestschweiz (FHNW). It includes features for peer tutoring, project collaboration, and a buddy system for exchange students.

[![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

> 🚧: **This is a template project**: Ensure you adapt this documentation and the source code for your specific needs and use case. Guidance comments marked with "🚧" should be addressed or removed in your final documentation.

#### Contents:
- [Analysis](#analysis)
  - [Scenario](#scenario)
  - [User Stories](#user-stories)
  - [Use Case](#use-case)
- [Design](#design)
  - [Prototype Design](#prototype-design)
  - [Domain Design](#domain-design)
  - [Business Logic](#business-logic)
- [Implementation](#implementation)
  - [Backend Technology](#backend-technology)
  - [Frontend Technology](#frontend-technology)
- [Project Management](#project-management)
  - [Roles](#roles)
  - [Milestones](#milestones)

## Analysis
> 🚧: Tailor the analysis to reflect the requirements and objectives of the EduPeerFHNW project.

### Scenario

EduPeerFHNW is conceived as a comprehensive support system for FHNW students, promoting academic excellence and social integration through peer-to-peer engagement and support for exchange students.

### User Stories

Student User Stories:

1. As a student, I want to offer or find tutoring in various subjects, specifying if the session is recurring or one-time, create a title and description for the offer, and set the timeline.
2. As a student, I want to offer mentoring for projects in different subjects, indicating if the mentoring is recurring or not, naming the offer, providing a description, and selecting timelines.
3. As a student, I want to initiate independent projects, distinct from the curriculum, deciding if they're recurring or one-time, naming the project, detailing it, and scheduling timelines.
4. As a student, I want to volunteer as a buddy for international students, aiding their adaptation to the academic and cultural environment at FHNW.
5. As a student, I wish to assign rooms to the created mentoring or collaboration events.

Admin User Stories:

1. As an admin, I need to modify or delete any tutoring offers or requests, project mentoring, collaborations, and buddy offers to ensure the platform's content remains relevant and appropriate.
2. As an admin, I want access to logs that monitor the creation of tutoring sessions, project collaborations, etc., including their titles and timelines, to maintain oversight.
3. As an admin, I need to post advertisements seeking buddies, tutors, mentors, or project collaborators to fill gaps in the community's needs.
4. As an admin, I should be able to assign international students to local buddies, ensuring a personalized and supportive integration experience.
5. As an admin, I must manage user accounts, including the ability to create, modify, or delete them, to ensure the platform's users are genuine and active.

Super Admin Stories:

1. As a super admin, I need to manage admin accounts, granting me the authority to create, alter, and delete admin profiles to maintain a high standard of platform oversight.

Common User Story:

1. As both an admin and a student (user), I require a web application that is accessible on various mobile devices and desktop computers, ensuring wide accessibility and usability.
2. As a user, regardless of being a student or an admin, I need to log in with different roles available on the platform, enabling personalized and role-appropriate access to features and functionalities.

### Use Case

- UC-1 [Peer Tutoring]: Facilitates students in offering or seeking tutoring services.
- UC-2 [Project Collaboration]: Enables students to initiate or join collaborative projects.
- UC-3 [Buddy System]: Connects incoming exchange students with local buddies for support.

## Design
> 🚧: Design with consideration for FHNW's Corporate Identity, focusing on user experience and accessibility.

### Wireframe
> 🚧: Start with wireframes to layout the web app's structure using tools like draw.io.

### Prototype
> 🚧: Develop an interactive prototype using Budibase to test and refine the user interface and experience.

### Domain Design
> 🚧: Describe the system's domain model, using Entity-Relationship Diagrams or UML class diagrams to illustrate entity relationships.

## Business Logic 
> 🚧: Explain the business logic, especially the algorithm for matching students in the buddy system, including expected paths and methods.

## Implementation
> 🚧: Detail the implementation strategy, covering both backend and frontend technologies, and any significant libraries or frameworks utilized.

### Backend Technology
> 🚧: This project is built on Spring Boot, using H2 Database for development purposes. Document any additional libraries or frameworks integrated into the project.

### Frontend Technology
> 🚧: The frontend is developed with Budibase, focusing on responsive design and user-friendly interfaces. Outline how the frontend interacts with the backend services.

## Execution
> 🚧: Provide comprehensive instructions for setting up, running, and deploying the project, including necessary configurations.

## Project Management
> 🚧: Summarize the project management approach, detailing roles, contributions, and milestones. Include descriptions of how collaborative efforts were organized and managed.

### Roles
- Backend Developer: Responsible for API development, database management, and server-side logic.
- Frontend Developer: Focuses on the user interface, ensuring a seamless and intuitive user experience.
- Project Manager: Oversees the project timeline, ensuring milestones are met and resources are allocated efficiently.

### Milestones
1. Requirement Analysis and Planning: Defining scope, objectives, and user stories.
2. Design Phase: Wireframing, prototyping, and domain modeling.
3. Implementation Phase: Development of backend and frontend components.
4. Testing & Refinement: Iterative testing and refinement of the application.
5. Deployment: Preparing and executing the deployment strategy.

#### Maintainers
- Mateusz Oskedra (special boi)
- Emirhan Akgün (ma man)

#### License
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
