SYSTEM MONITORING
This project consists of a UI that displays live data from connected agents and processes incoming JSON data via WebSocket. The server processes the data, stores it in a database, and sends live updates to the UI.

Prerequisites
Before you begin, make sure you have the following installed on your system:

Node.js (version 18 or later)
Vue.js (version 3)
WebSocket server (running at your server-side setup)

Access the UI: Open your browser and navigate to http://localhost:8080. Here you will find:
SideMenu.vue: This holds the button to toggle the dashboard view.
Dashboard: Displays live data such as the number of connected agents and systems in real-time.
Incident Tracking: Shows historical data and events based on the system's history.

Backend Server (Data Processing):
Process incoming JSON data: The server receives the JSON data sent by the agent, verifies the key, and stores the data in the database.

Store in database: The server stores any relevant information such as system names, events, and incidents in the database for historical tracking.

Send live data to UI: The server sends live updates to the UI via WebSocket, showing the current number of connected agents and their corresponding systems.

Dashboard UI Features
Live Data Display: Real-time information on how many agents are connected.
System Monitoring: Displays the connected systems and their corresponding data, including event occurrences.
Incident Tracking: Shows any incidents or events that have occurred in the system, using data from the database.
Usage
Start the WebSocket server and ensure the UI and agent scripts are running.
From the UI:
Click the button in the SideMenu.vue to show the dashboard.
Monitor live data, including the number of connected agents, systems, and any events.
