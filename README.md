## Introduction

This API allows users to register, log in, and manage their profile information. It also provides administrative functionality to view and search for user information, which is restricted to administrators. The API utilizes role-based permissions to control access to different resources.

## Endpoints

### Authentication Endpoints

#### Register

- **URL:** `/api/v1/user/auth/register`
- **Method:** `POST`
- **Access:** Public
- **Description:** Allows new users to create an account.

#### Login

- **URL:** `/api/v1/user/auth/login`
- **Method:** `POST`
- **Access:** Public
- **Description:** Allows existing users to log in to their account.

### User Profile Endpoints

These endpoints are accessible only to users with the `USER` authority.

#### Display Info

- **URL:** `/api/v1/user/display-Info`
- **Method:** `GET`
- **Access:** USER
- **Description:** Displays the user's profile information.

#### Update Profile

- **URL:** `/api/v1/profile/update-profile`
- **Method:** `PUT`
- **Access:** USER
- **Description:** Allows the user to update their profile information.

#### Add Profile

- **URL:** `/api/v1/profile/add-profile`
- **Method:** `POST`
- **Access:** USER
- **Description:** Allows the user to add new profile information.

### Administrative Endpoints

These endpoints are accessible only to users with the `ADMIN` authority.

#### Get All Users

- **URL:** `/api/v1/user/get-all-users`
- **Method:** `GET`
- **Access:** ADMIN
- **Description:** Retrieves a list of all users in the system.

#### Search User by ID

- **URL:** `/api/v1/user/search/{id}`
- **Method:** `GET`
- **Access:** ADMIN
- **Description:** Searches for a user by their ID.

## Roles and Access Levels

| Endpoint                                      | Role Required |
|-----------------------------------------------|---------------|
| `/api/v1/user/auth/register`                  | Public        |
| `/api/v1/user/auth/login`                     | Public        |
| `/api/v1/user/display-Info`                   | USER          |
| `/api/v1/profile/update-profile`              | USER          |
| `/api/v1/profile/add-profile`                 | USER          |
| `/api/v1/user/get-all-users`                  | ADMIN         |
| `/api/v1/user/search/{id}`                    | ADMIN         |

- **USER**: Can access their own profile information.
- **ADMIN**: Can access all users' information and perform administrative functions.
