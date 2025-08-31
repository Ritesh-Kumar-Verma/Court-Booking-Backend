Court Booking App
=================
A React application for booking court time slots with a Spring Boot backend. Users can view available time slots, enter their username and mobile number, and book slots. All bookings are stored in an H2 database on the backend.

Features
=================
View available court time slots.

Book slots using username and mobile number.

Booked slots are stored in the backend (H2 database).

Frontend and backend deployed and accessible online.
=================
Tech Stack
=================
Frontend
=================
React 18

Vite

Tailwind CSS (or your preferred styling)

Backend
=================

Spring Boot

Java 17+

H2 Database (file mode for persistence)

Spring Data JPA

RESTful API
=================
Deployed on Render
=================
Live Links : https://ritesh-kumar-verma.github.io/court-booking/

Frontend: https://ritesh-kumar-verma.github.io/court-booking/

Backend: xxx (Not providing for safety reasons)

Setup Instructions
Prerequisites

npm 

Java 17+

Maven

=================
React
=================

Frontend Setup
=================
Clone the repository

git clone https://github.com/Ritesh-Kumar-Verma/court-booking

cd court-booking


Install dependencies

npm install



Run the development server

npm run dev



Open http://localhost:5173
 in your browser.


Backend Setup
=================
Clone the backend repository

git clone https://github.com/Ritesh-Kumar-Verma/Court-Booking-Backend

cd Court-Booking-Backend


Build and run the application

./mvnw clean package

java -jar target/court-booking-backend-0.0.1-SNAPSHOT.jar


The backend runs on http://localhost:8080
 by default.

=================
Backend API
=================

POST /getavailability– get available time slot by date

POST /addbookings– Create a booking with mobile number and name

POST /getbookings– get bookings with mobile number


Body example:

[
{
  "username": "John Doe",
  "mobile": "9876543210",
  "timeSlot": "10:00 AM - 11:00 AM"
},
{
  "username": "Max",
  "mobile": "98731243210",
  "timeSlot": "11:00 AM - 12:00 AM"
}

]



=================
Database
=================
H2 Database in file mode: ~/court-booking.mv.db

Accessible via H2 console in Spring Boot at /h2-console

=================
How to Use
=================
Open the frontend in your browser.

Select a Date and press check Availability

Select one or more available time slot.

Enter your username and mobile number.

Click Book to save the booking to the backend.

Booked slots are automatically marked as unavailable and will not show in frontend.

=================
Deployment
=================
Frontend: Deployed via GitHub pages

Backend: Deployed on Render 

Make sure CORS is allowed on the backend for your frontend domain:

@CrossOrigin(origins = "https://your-frontend-link.com")

=================
Future Improvements
=================
User authentication & login system.

Email/SMS notifications on successful booking.

Admin panel to manage slots.
