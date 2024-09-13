import java.util.*;

// Kolkata Metro class
public class KolkataMetroApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the number of stations
        int numberOfStations = 20;
        Graph metroMap = new Graph(numberOfStations);

        // Predefined stations and connections (using station indices for simplicity)
        metroMap.addConnection(0, 1, 2, 5);   // Dum Dum to Noapara, Distance: 2 km, Time: 5 min
        metroMap.addConnection(1, 2, 5, 10);  // Noapara to Belgachia, Distance: 5 km, Time: 10 min
        metroMap.addConnection(2, 3, 4, 8);   // Belgachia to Shyambazar, Distance: 4 km, Time: 8 min
        metroMap.addConnection(3, 4, 3, 7);   // Shyambazar to Shovabazar, Distance: 3 km, Time: 7 min
        metroMap.addConnection(4, 5, 2, 5);   // Shovabazar to Girish Park, Distance: 2 km, Time: 5 min
        metroMap.addConnection(5, 6, 1, 3);   // Girish Park to MG Road, Distance: 1 km, Time: 3 min
        metroMap.addConnection(6, 7, 2, 5);   // MG Road to Central, Distance: 2 km, Time: 5 min
        metroMap.addConnection(7, 8, 2, 5);   // Central to Chandni Chowk, Distance: 2 km, Time: 5 min
        metroMap.addConnection(8, 9, 1, 3);   // Chandni Chowk to Esplanade, Distance: 1 km, Time: 3 min
        metroMap.addConnection(9, 10, 3, 7);  // Esplanade to Park Street, Distance: 3 km, Time: 7 min
        metroMap.addConnection(10, 11, 2, 5); // Park Street to Maidan, Distance: 2 km, Time: 5 min
        metroMap.addConnection(11, 12, 3, 7); // Maidan to Rabindra Sadan, Distance: 3 km, Time: 7 min
        metroMap.addConnection(12, 13, 4, 9); // Rabindra Sadan to Netaji Bhavan, Distance: 4 km, Time: 9 min
        metroMap.addConnection(13, 14, 3, 6); // Netaji Bhavan to Jatin Das Park, Distance: 3 km, Time: 6 min
        metroMap.addConnection(14, 15, 2, 4); // Jatin Das Park to Kalighat, Distance: 2 km, Time: 4 min
        metroMap.addConnection(15, 16, 3, 7); // Kalighat to Rabindra Sarobar, Distance: 3 km, Time: 7 min
        metroMap.addConnection(16, 17, 4, 8); // Rabindra Sarobar to Mahanayak Uttam Kumar, Distance: 4 km, Time: 8 min
        metroMap.addConnection(17, 18, 5, 10); // Mahanayak Uttam Kumar to Netaji, Distance: 5 km, Time: 10 min
        metroMap.addConnection(18, 19, 2, 5); // Netaji to Kavi Subhash, Distance: 2 km, Time: 5 min

        // Map station indices to station names
        String[] stationNames = {
            "Dum Dum", "Noapara", "Belgachia", "Shyambazar", "Shovabazar", 
            "Girish Park", "MG Road", "Central", "Chandni Chowk", "Esplanade", 
            "Park Street", "Maidan", "Rabindra Sadan", "Netaji Bhavan", "Jatin Das Park", 
            "Kalighat", "Rabindra Sarobar", "Mahanayak Uttam Kumar", "Netaji", "Kavi Subhash"
        };

        // Let user select the start and end stations
        System.out.println("Select the start station (enter the number):");
        for (int i = 0; i < stationNames.length; i++) {
            System.out.println(i + ": " + stationNames[i]);
        }
        int startStation = scanner.nextInt();

        System.out.println("Select the destination station (enter the number):");
        int endStation = scanner.nextInt();

        // Choose whether to calculate shortest path by time or distance
        System.out.println("Do you want to find the shortest path based on (1) Time or (2) Distance?");
        int choice = scanner.nextInt();
        boolean useTime = (choice == 1);
        
        // Call dijkstra with start and end stations
        int ans = metroMap.dijkstra(startStation, endStation, useTime);

        System.out.println((useTime ? "Shortest time" : "Shortest distance") + " from station " + stationNames[startStation] + " to station " + stationNames[endStation] + " : " + ans + (useTime ? " min" : " km"));

        scanner.close();
    }
}
