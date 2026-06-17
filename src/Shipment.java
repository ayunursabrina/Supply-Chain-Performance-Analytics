public class Shipment {
    private String shipmentId;
    private String type;
    private String date;
    private String productCategory;
    private String origin;
    private String oCountry;
    private String destination;
    private String dCountry;
    private double value;
    private double freightCost;
    private double customsClearanceTimeDays;
    private String deliveryStatus;

    // Constructor
    public Shipment(String shipmentId, String type, String date,
                    String productCategory, String origin, String oCountry,
                    String destination, String dCountry, double value,
                    double freightCost, double customsClearanceTimeDays,
                    String deliveryStatus) {

        this.shipmentId = shipmentId;
        this.type = type;
        this.date = date;
        this.productCategory = productCategory;
        this.origin = origin;
        this.oCountry = oCountry;
        this.destination = destination;
        this.dCountry = dCountry;
        this.value = value;
        this.freightCost = freightCost;
        this.customsClearanceTimeDays = customsClearanceTimeDays;
        this.deliveryStatus = deliveryStatus;
        
    }

    // Getters
    public String getShipmentId() {
        return shipmentId;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getOrigin() {
        return origin;
    }

    public String getOCountry() {
        return oCountry;
    }

    public String getDestination() {
        return destination;
    }

    public String getDCountry() {
        return dCountry;
    }

    public double getValue() {
        return value;
    }

    public double getFreightCost() {
        return freightCost;
    }

    public double getCustomsClearanceTimeDays() {
        return customsClearanceTimeDays;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    // Setters
    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setOCountry(String oCountry) {
        this.oCountry = oCountry;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDCountry(String dCountry) {
        this.dCountry = dCountry;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setFreightCost(double freightCost) {
        this.freightCost = freightCost;
    }

    public void setCustomsClearanceTimeDays(double customsClearanceTimeDays) {
        this.customsClearanceTimeDays = customsClearanceTimeDays;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
   
    @Override
    public String toString() {
        return String.format(
            "ID: %-10s | Type: %-8s | Category: %-15s | Origin: %-20s | Destination: %-20s | Value: %.2f | Status: %s",
            shipmentId,
            type,
            productCategory,
            origin,
            destination,
            value,
            deliveryStatus
        );
    }
}