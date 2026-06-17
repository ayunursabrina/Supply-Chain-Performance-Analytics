import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ETL {
    public static void main(String[] args) {
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        
        DataWarehouseStore warehouse = new DataWarehouseStore();

        String shipmentPath = "./shipment.csv";
        String customerPath = "./customer.csv";
        String logisticsPath = "./logistics_performance.csv";
        loadShipmentData(shipmentPath, warehouse);
        loadCustomerData(customerPath, warehouse);
        loadLogisticsData(logisticsPath, warehouse);

        System.out.println("\n=== DATA WAREHOUSE LOADED SUCCESSFULLY ===");
        System.out.println("Total Shipment Data  : " + warehouse.getShipmentTable().size() + " baris");
        System.out.println("Total Customer Data  : " + warehouse.getCustomerTable().size() + " baris");
        System.out.println("Total Logistics Data : " + warehouse.getLogisticsTable().size() + " baris");
    
     // ===================== BUSINESS ANALYSIS =====================
        BusinessAnalysis.analyzeDeliveryPerformance(warehouse);
        BusinessAnalysis.analyzeCarrierEfficiency(warehouse);
        BusinessAnalysis.bestCarrier(warehouse);
        BusinessAnalysis.analyzeCustomerSatisfaction(warehouse);
        BusinessAnalysis.highestCostRoute(warehouse);
        BusinessAnalysis.executiveKPI(warehouse);
        
     // ===================== TAMPILKAN DATA SHIPMENT =====================
        System.out.println("=================================================");
        System.out.println("DATA SHIPMENT PERTAMA");
        System.out.println("=================================================");
        for (int i = 0; i < Math.min(10, warehouse.getShipmentTable().size()); i++) {
            System.out.println(warehouse.getShipmentTable().get(i));
        }

        // ===================== TAMPILKAN 10 DATA CUSTOMER =====================
        System.out.println("\n=================================================");
        System.out.println("           10 DATA CUSTOMER PERTAMA");
        System.out.println("=================================================");

        for (int i = 0; i < Math.min(10, warehouse.getCustomerTable().size()); i++) {
            System.out.println(warehouse.getCustomerTable().get(i));
        }

        // ===================== TAMPILKAN 10 DATA LOGISTICS =====================
        System.out.println("\n=================================================");
        System.out.println("           10 DATA LOGISTICS PERTAMA");
        System.out.println("=================================================");

        for (int i = 0; i < Math.min(10, warehouse.getLogisticsTable().size()); i++) {
            System.out.println(warehouse.getLogisticsTable().get(i));
        }
    }

    // ===================== SHIPMENT =====================
    private static void loadShipmentData(String filePath, DataWarehouseStore store) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip Header

            while ((line = br.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) continue;

                String[] data = line.split(",");

                // ================= DATA CLEANSING =================
                if (data.length == 11) {
                    String destination = data[6].trim();
                    String country = CountryReference.getCountry(destination);
                    String[] fixed = new String[12];

                    fixed[0] = data[0];
                    fixed[1] = data[1];
                    fixed[2] = data[2];
                    fixed[3] = data[3];
                    fixed[4] = data[4];
                    fixed[5] = data[5];
                    fixed[6] = data[6];
                    fixed[7] = country;
                    fixed[8] = data[7];
                    fixed[9] = data[8];
                    fixed[10] = data[9];
                    fixed[11] = data[10];

                    data = fixed;

                    System.out.println(
                        "[ETL CLEANING] Missing destination country diperbaiki untuk shipment "
                        + data[0]
                    );
                }

                if (data.length != 12) {
                    System.out.println("ERROR FORMAT CSV:");
                    System.out.println(line);
                    continue;
                }

                String fullOrigin = data[4].trim() + "," + data[5].trim();
                String fullDestination = data[6].trim() + "," + data[7].trim();

                Shipment s = new Shipment(
                        data[0].trim(),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        fullOrigin,
                        data[5].trim(),
                        fullDestination,
                        data[7].trim(),
                        Double.parseDouble(data[8].trim()),
                        Double.parseDouble(data[9].trim()),
                        Double.parseDouble(data[10].trim()),
                        data[11].trim()
                );

                store.addShipment(s);
            }
            System.out.println("Shipment data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading shipment data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number dalam shipment: " + e.getMessage());
        }
    }

    // ===================== CUSTOMER =====================
    private static void loadCustomerData(String filePath, DataWarehouseStore store) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip Header

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // SOLUSI: Lewati jika ada baris kosong di akhir file

                String[] data = line.split(",");

                // Validasi minimal panjang kolom untuk mengamankan data yang rusak/tidak lengkap
                if (data.length < 12) continue; 

                Customer c = new Customer(
                        data[0].trim(),
                        data[1].trim(),
                        Double.parseDouble(data[2].trim()),
                        data[3].trim(),
                        data[4].trim(),
                        data[5].trim(),
                        data[6].trim(),
                        Double.parseDouble(data[7].trim()),
                        data[8].trim(),
                        Integer.parseInt(data[9].trim()),
                        Integer.parseInt(data[10].trim()),
                        Integer.parseInt(data[11].trim())
                );
                store.addCustomer(c);
            }
            System.out.println("Customer data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading customer data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number dalam customer: " + e.getMessage());
        }
    }

    // ===================== LOGISTICS =====================
    private static void loadLogisticsData(String filePath, DataWarehouseStore store) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip Header

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // SOLUSI: Lewati jika ada baris kosong

                String[] data = line.split(",");
                if (data.length < 8) continue;

                LogisticsPerformance l = new LogisticsPerformance(
                        data[0].trim(),
                        data[1].trim(),
                        data[2].trim(),
                        Integer.parseInt(data[3].trim()),
                        Double.parseDouble(data[4].trim()),
                        Double.parseDouble(data[5].trim()),
                        Double.parseDouble(data[6].trim()),
                        Integer.parseInt(data[7].trim())
                );
                store.addLogistics(l);
            }
            System.out.println("Logistics data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading logistics data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number dalam logistics: " + e.getMessage());
        }
    }
    
}

