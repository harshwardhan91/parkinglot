# parkinglot

This project is a system for a Parking lot.
It is a multi storey parking lot.
Each slot is given a number starting at 1 increasing with increasing distance from the
entry point in steps of one. It creates an automated ticketing system that allows
the customers to use parking lot without human intervention.
When a car enters the parking lot,a ticket is issued to the driver. The ticket
issuing process includes us documenting the registration number (number plate) and
the colour of the car and allocating an available parking slot to the car before actually
handing over a ticket to the driver (we assume that our customers are nice enough to
always park in the slots allocated to them). The customer is allocated a parking
slot which is nearest to the entry. At the exit the customer returns the ticket which then
marks the slot they were using as being available.
We interact with the system via a simple set of commands or a file input which produce a specific
output.

It has features to:
1. Create a new parking log with command "create_parking_lot"<br>
e.g. create_parking_lot 6
2. Park a vehicle  "park" with registration number followed by color<br>
e.g. park KA-01-HH-1234 White
3. Leave the parking lot "leave" with given slot number<br>
e.g. leave 4
4. Get the status of Parking lot with parked cars "status"<br>
e.g. status
5. Get all registration numbers with given color "registration_numbers_for_cars_with_colour"<br>
e.g. registration_numbers_for_cars_with_colour White
6. Get all slot numbers with given color "slot_numbers_for_cars_with_colour"<br>
e.g. slot_numbers_for_cars_with_colour White
7. Get slot of the vehivcle given registration number "slot_number_for_registration_number"<br>
e.g. slot_number_for_registration_number KA-01-HH-3141

This solution is adaptable to the High Scalable situations.<br>
Each of the different components have been separated out and separation of concern principle is tried to be adhered at all possible levels.<br>
Client input and application level handling is defined in controller and actions.<br>
Data layer handling has been done by data.<br>
<t>   ParkingLotData.java acts as layer above the actual data parkingLot.java.<br>
Interaction between them is maintained using service.<br>
<br>
<br>
Right now all data is stored in memory, hence no caching and database interaction is needed here.<br>
But in case we need data scaling that can be done in ParkingLotData interface.<br>
if application layer scaling is needed we can scale out from ParkingLotServiceImpl.<br>
Caching can be provided by keeping caching at ParkingLotData by maintaining key value pair with key input and response set.<br> 
Since here it didn't make much of the performance hit here haven't kept a separate for Map here.<br>
<br>
<br>
Steps to execute the programme:
1. Unzip the folder, and go to the directory where directory.
2. run mvn clean install.
3. gojek.parkinglot-1.0.jar will be generated in the target folder.
4. run the command java -jar target/gojek.parkinglot-1.0-SNAPSHOT.jar to execute from command line (type 'exit' to discontinue)<br>
or <br>
java -jar target/gojek.parkinglot-1.0-SNAPSHOT.jar ''filePath" to read commands from given file "filePath". Sample command file is in the directory as commands.txt.
