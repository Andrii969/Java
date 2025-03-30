import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DesktopPath {

    public static void main(String[] args) {
        // Path to the CSV file
        String fileName = "/Users/andriisavonov/Desktop/NewRoomData.csv";

        // ArrayList to store UUIDs
        ArrayList<String> uuids = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Skip the header
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the first line (header)
                    continue;
                }

                // Split the line by comma
                String[] values = line.split(",");

                // Add the first column (UUID) to the ArrayList
                if (values.length > 0) {
                    uuids.add(values[1]);
                }
            }

            System.out.println("UUIDs imported successfully:");
            for (String uuid : uuids) {
                System.out.println(uuid);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
