# Educational Peer Exchange Platform for Fachhochschule Nordwestschweiz Students (CommunityFHNW)

This project aims to facilitate a peer-to-peer learning and support environment for students at the Fachhochschule Nordwestschweiz (FHNW). It includes features for peer tutoring, project collaboration, and a buddy system for exchange students.

[![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

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
  - [Stakeholders](#stakeholders)
  - [Milestones](#milestones)
- [Copyright](#copyright)

### Analysis

> Add smth here

### Scenario

CommunityFHNW is designed to be a dynamic support and learning platform for students at Fachhochschule Nordwestschweiz (FHNW), fostering a strong sense of academic and social community. It's built on the idea that every student not only seeks knowledge but also has unique insights to share, creating a vibrant cycle of learning and teaching.

The platform allows students to easily find or offer tutoring across a variety of subjects, manage project collaborations, and even volunteer as buddies for international peers, helping them adjust to life at FHNW and in Switzerland. Through CommunityFHNW, students can set up one-time or recurring tutoring sessions, kick-start independent projects beyond the regular curriculum, and create real-world meetings for collaborative work, all within a framework that encourages innovation and mutual support.

For international students, the buddy system is a cornerstone of the platform, providing a welcoming introduction to the academic community and Swiss culture, thanks to the local students eager to share their knowledge and experiences.

Behind the scenes, admins ensure the platform runs smoothly, moderating content and managing accounts to keep the community safe and engaged. They have tools at their disposal to monitor activity, post needed advertisements for tutors or project collaborators, and pair international students with their local buddies. Super admins oversee this all, maintaining the high standards and vision of the platform.

Available on various devices, CommunityFHNW ensures that whether you're on campus or on the move, you can stay connected, making learning flexible and accessible for everyone involved.

### User Stories

**Student User Stories:**

- **As a student**, I want to offer or find tutoring in various subjects, specifying if the session is recurring or one-time, create a title and description for the offer, and set the timeline.

- **As a student**, I want to offer mentoring for projects in different subjects, indicating if the mentoring is recurring or not, naming the offer, providing a description, and selecting timelines.

- **As a student**, I want to initiate independent projects, distinct from the curriculum, deciding if they're recurring or one-time, naming the project, detailing it, and scheduling timelines.

- **As a student**, I want to volunteer as a buddy for international students, aiding their adaptation to the academic and cultural environment at FHNW.

- **As a student**, I wish to assign rooms to the created mentoring or collaboration events.

- *(optional, v2.0)* **As a student**, I want to create forum posts about any topic to share knowledge, seek advice, or discuss academic and non-academic matters with my peers.

- *(optional, v2.0)* **As a student**, I want to respond to forum threads, allowing me to contribute to discussions, offer my insights, or seek further clarification on topics of interest.

**Admin User Stories:**

- **As an admin**, I need to modify or delete any tutoring offers or requests, project mentoring, collaborations, and buddy offers to ensure the platform's content remains relevant and appropriate.

- **As an admin**, I want access to logs that monitor the creation of tutoring sessions, project collaborations, etc., including their titles and timelines, to maintain oversight.

- **As an admin**, I need to post advertisements seeking buddies, tutors, mentors, or project collaborators to fill gaps in the community's needs.

- **As an admin**, I should be able to assign international students to local buddies, ensuring a personalized and supportive integration experience.

- **As an admin**, I must manage user accounts, including the ability to create, modify, or delete them, to ensure the platform's users are genuine and active.

- *(optional)* **As an admin**, I want to add FHNW job advertisements to the platform, allowing students to access employment opportunities within the university and its affiliated institutions, enhancing their career prospects and integration into the professional community.

- *(optional, v2.0)* **As an admin**, I need the ability to modify or delete any forum post or response that violates our community guidelines to ensure discussions remain productive, respectful, and relevant.

**Super Admin Stories:**

- **As a super admin**, I need to manage admin accounts, granting me the authority to create, alter, and delete admin profiles to maintain a high standard of platform oversight.

**Common User Story:**

- **As both an admin and a student (user)**, I require a web application that is accessible on various mobile devices and desktop computers, ensuring wide accessibility and usability.

- **As a user**, regardless of being a student or an admin, I need to log in with different roles available on the platform, enabling personalized and role-appropriate access to features and functionalities.

### Use Case

**Student Use Cases:**

- **UC-1 [Offer/Find Tutoring]:** Students can offer or find tutoring in various subjects, specifying whether the session is recurring or one-time, creating a title and description for the offer, and setting the timeline.

- **UC-2 [Offer Mentoring for Projects]:** Students can offer mentoring for projects in different subjects, indicating if the mentoring is recurring or not, naming the offer, providing a description, and selecting timelines.

- **UC-3 [Initiate Independent Projects]:** Students can initiate independent projects, distinct from the curriculum, deciding if they're recurring or one-time, naming the project, detailing it, and scheduling timelines.

- **UC-4 [Volunteer as a Buddy]:** Students can volunteer as a buddy for international students, specifying the languages they can speak to aid in the adaptation to the academic and cultural environment at FHNW.

- **UC-5 [Assign Rooms for Events]:** Students can assign rooms for mentoring or collaboration events, specifying if the event is recurring or one-time, and setting specific timeframes.

- **UC-6 [Create Forum Posts]:** *(optional, v2.0)* Students can create forum posts on a variety of topics, setting the stage for open discussions, sharing of ideas, or solicitation of academic help.

- **UC-7 [Respond to Forum Threads]:** *(optional, v2.0)* Students can answer and engage in ongoing discussions within forum threads, allowing for dynamic exchanges of knowledge and perspectives.

**Admin Use Cases:**

- **UC-8 [Modify/Delete Offers and Requests]:** Admins can modify or delete any tutoring offers or requests, project mentoring, collaborations, and buddy offers to keep the platform's content appropriate and up-to-date.

- **UC-9 [Access Logs]:** Admins have access to logs that monitor the creation of tutoring sessions, project collaborations, etc., including their titles and timelines.

- **UC-10 [Post Advertisements]:** Admins can post advertisements seeking buddies, tutors, mentors, or project collaborators to address community needs.

- **UC-11 [Assign International Students to Buddies]:** Admins can assign international students to local buddies based on language abilities and other relevant criteria for a supportive integration.

- **UC-12 [Manage User Accounts]:** Admins can manage user accounts, with the ability to create, modify, or delete them to ensure authenticity and activity on the platform.

- **UC-13 [Add Job Advertisements]:** *(optional)* Admins can post job advertisements related to FHNW, including details about the role, requirements, application process, and deadlines, making it easier for students to find and apply for jobs that match their skills and interests.

- **UC-14 [Moderate Forum Content]:** *(optional, v2.0)* Admins can modify or delete any forum post or response, exercising oversight to maintain the integrity and positivity of the forum environment.

**Super Admin Use Cases:**

- **UC-15 [Manage Admin Accounts]:** Super admins have the authority to manage admin accounts, including the creation, alteration, and deletion of admin profiles to ensure platform integrity and oversight.

**Common Use Cases:**

- **UC-16 [Login with Roles]:** Users, regardless of being students or admins, can log in with different roles available on the platform, enabling personalized and role-appropriate access to features and functionalities.

> use case diagram here

## Design

**Color Scheme**
- The color palette should reflect the official FHNW colors, ensuring a visual connection between the platform and the institution's brand identity.

**Graphics**
- Use graphics that are stylistically similar to those found on FHNW's web presence, maintaining brand consistency.

**Typography**
- Typography choices should match those used by FHNW's official communications to maintain a cohesive look and feel.

**Layout**
- The layout should be clean, organized, and navigable, much like FHNW's website, providing a user-friendly experience that aligns with the institution's standards.

**User Experience (UX)**
- UX design should prioritize ease of use and intuitive navigation, considering the familiarity of the user base with FHNW's existing digital touchpoints.

*All design decisions must be made with FHNW's CI guidelines at the forefront to create a seamless and integrated user experience that resonates with the community.*


### Wireframe
> Add smth here

### Prototype
> Add smth here

### Domain Design

**Description:**

- **User**
  - UserID: INTEGER (Primary Key)
  - Username: VARCHAR(50)
  - Password: VARCHAR(255)  # Length to accommodate hashed passwords
  - Role: ENUM('Student', 'Admin', 'Super Admin')
  - Email: VARCHAR(100) *(optional)*
  - PhoneNumber: VARCHAR(15) *(optional)*

- **Tutoring Session**
  - SessionID: INTEGER (Primary Key)
  - Subject: VARCHAR(50)
  - Description: TEXT
  - TutorID: INTEGER (ForeignKey to User.UserID)
  - StudentID: INTEGER (ForeignKey to User.UserID) *(optional)*
  - Recurring: BOOLEAN
  - StartTime: TIMESTAMP
  - EndTime: TIMESTAMP
  - Status: ENUM('Active', 'Completed', 'Cancelled')

- **Mentoring for Projects**
  - ProjectID: INTEGER (Primary Key)
  - MentorID: INTEGER (ForeignKey to User.UserID)
  - Subject: VARCHAR(50)
  - Description: TEXT
  - Recurring: BOOLEAN
  - ProjectName: VARCHAR(100)
  - StartTime: TIMESTAMP
  - EndTime: TIMESTAMP

- **Independent Project**
  - ProjectID: INTEGER (Primary Key)
  - LeaderID: INTEGER (ForeignKey to User.UserID)
  - ProjectName: VARCHAR(100)
  - Description: TEXT
  - Recurring: BOOLEAN
  - StartTime: TIMESTAMP
  - EndTime: TIMESTAMP

- **Buddy System**
  - BuddyPairID: INTEGER (Primary Key)
  - LocalStudentID: INTEGER (ForeignKey to User.UserID)
  - InternationalStudentID: INTEGER (ForeignKey to User.UserID)
  - Languages: VARCHAR(100)
  - Status: ENUM('Active', 'Completed')

- **Room Assignment** *(optional, v2.0)*
  - RoomID: INTEGER (Primary Key)
  - Building: VARCHAR(50)
  - Capacity: INTEGER
  - Resources: TEXT
  - EventID: INTEGER (ForeignKey to Tutoring Session.SessionID or Independent Project.ProjectID)
  - StartTime: TIMESTAMP
  - EndTime: TIMESTAMP

- **Forum Post** *(optional, v2.0)*
  - PostID: INTEGER (Primary Key)
  - AuthorID: INTEGER (ForeignKey to User.UserID)
  - Content: TEXT
  - Topic: VARCHAR(50)
  - CreationTime: TIMESTAMP

- **Forum Response** *(optional, v2.0)*
  - ResponseID: INTEGER (Primary Key)
  - PostID: INTEGER (ForeignKey to Forum Post.PostID)
  - AuthorID: INTEGER (ForeignKey to User.UserID)
  - Content: TEXT
  - ResponseTime: TIMESTAMP

- **Admin Actions**
  - ActionID: INTEGER (Primary Key)
  - AdminID: INTEGER (ForeignKey to User.UserID)
  - ActionType: ENUM('Modify', 'Delete', 'Assign')
  - TargetID: INTEGER  # This would reference various entity IDs
  - Timestamp: TIMESTAMP

- **Job Advertisement** *(optional)*
  - JobAdID: INTEGER (Primary Key)
  - AdminID: INTEGER (ForeignKey to User.UserID)
  - Title: VARCHAR(100)
  - Description: TEXT
  - ApplicationDeadline: TIMESTAMP
  - ContactInfo: VARCHAR(100)

- **System Log**
  - LogID: INTEGER (Primary Key)
  - RelatedActionID: INTEGER (ForeignKey to Admin Actions.ActionID)
  - Timestamp: TIMESTAMP
  - Description: TEXT

- **Account Management**
  - ManagementID: INTEGER (Primary Key)
  - AdminID: INTEGER (ForeignKey to User.UserID)
  - TargetUserID: INTEGER (ForeignKey to User.UserID)
  - ActionType: ENUM('Create', 'Modify', 'Delete')
  - Timestamp: TIMESTAMP

**Associations:**

- Each **Tutoring Session** is related to one **Tutor** (User) and optionally to one **Student** (User).

- Each **Mentoring for Projects** instance is related to one **Mentor** (User).

- Each **Independent Project** is led by one **Leader** (User).

- Each **Buddy System** pair links one **Local Student** (User) and one **International Student** (User).

- Each **Room Assignment** is associated with either a **Tutoring Session** or an **Independent Project**.

- Each **Forum Post** and **Forum Response** is authored by a **User**.

- **Forum Responses** are linked to their respective **Forum Posts**.

- **Admin Actions** are performed by **Admins** and target various entities within the system.

- **Job Advertisements** are posted by **Admins**.

- **System Logs** record **Admin Actions**.

- **Account Management** actions are performed by **Admins** or **Super Admins** on **User** accounts.

> Add Domain Model

## Business Logic 
> Add smth here

## Implementation
> Add smth here

### Backend Technology
> Add smth here

### Frontend Technology
> Add smth here

## Execution
> Add smth here

## Project Management
> Add smth here

### Roles
- Backend Developer: Responsible for API development, database management, and server-side logic.
- Frontend Developer: Focuses on the user interface, ensuring a seamless and intuitive user experience.
- Project Manager: Oversees the project timeline, ensuring milestones are met and resources are allocated efficiently.
- Product Manager: Guides the platform's development strategy, focusing on aligning features with user needs and business objectives. Coordinates between users, technical teams, and stakeholders to prioritize and refine product features, ensuring CommunityFHNW meets its goals effectively.

### Stakeholders

- Students (Users) 
- University Administration *(optional)*
- IT Department Staff *(optional)*
- Faculty Members



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

### Copyright
Copyright © 2024 Mateusz Oskedra and Emirhan Akgün. All rights reserved.

No part of the CommunityFHNW project, including its ideas, documentation, code, and content, may be reproduced, distributed, or transmitted in any form or by any means, including photocopying, recording, or other electronic or mechanical methods, without the prior written permission of the author, except in the case of brief quotations embodied in critical reviews and certain other noncommercial uses permitted by copyright law. For permission requests, write to the author, addressed “Copyright permission,” at the address below.

oskedram@gmail.com
