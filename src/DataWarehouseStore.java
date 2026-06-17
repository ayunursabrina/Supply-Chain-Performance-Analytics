import java.util.ArrayList;
import java.util.List;

public class DataWarehouseStore {

    // In-Memory Tables
    private List<Shipment> shipmentTable;
    private List<Customer> customerTable;
    private List<LogisticsPerformance> logisticsTable;

    // Constructor
    public DataWarehouseStore() {
        shipmentTable = new ArrayList<>();
        customerTable = new ArrayList<>();
        logisticsTable = new ArrayList<>();
    }

    // Insert Data
    public void addShipment(Shipment shipment) {
        shipmentTable.add(shipment);
    }

    public void addCustomer(Customer customer) {
        customerTable.add(customer);
    }

    public void addLogistics(LogisticsPerformance logistics) {
        logisticsTable.add(logistics);
    }

    // Get Data
    public List<Shipment> getShipmentTable() {
        return shipmentTable;
    }

    public List<Customer> getCustomerTable() {
        return customerTable;
    }

    public List<LogisticsPerformance> getLogisticsTable() {
        return logisticsTable;
    }

    // Utility Methods
    public int getShipmentCount() {
        return shipmentTable.size();
    }

    public int getCustomerCount() {
        return customerTable.size();
    }

    public int getLogisticsCount() {
        return logisticsTable.size();
    }
}