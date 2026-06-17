public class LogisticsPerformance {
    private String date;
    private String region;
    private String carrier;
    private int shipmentsProcessed;
    private double delayHoursAvg;
    private double fuelPriceUsdPerBarrel;
    private double warehouseUtilizationPercent;
    private int damageClaimsCount;

    // Constructor
    public LogisticsPerformance(String date, String region, String carrier,
                                int shipmentsProcessed, double delayHoursAvg,
                                double fuelPriceUsdPerBarrel,
                                double warehouseUtilizationPercent,
                                int damageClaimsCount) {

        this.date = date;
        this.region = region;
        this.carrier = carrier;
        this.shipmentsProcessed = shipmentsProcessed;
        this.delayHoursAvg = delayHoursAvg;
        this.fuelPriceUsdPerBarrel = fuelPriceUsdPerBarrel;
        this.warehouseUtilizationPercent = warehouseUtilizationPercent;
        this.damageClaimsCount = damageClaimsCount;
    }

    // Getters
    public String getDate() {
        return date;
    }

    public String getRegion() {
        return region;
    }

    public String getCarrier() {
        return carrier;
    }

    public int getShipmentsProcessed() {
        return shipmentsProcessed;
    }

    public double getDelayHoursAvg() {
        return delayHoursAvg;
    }

    public double getFuelPriceUsdPerBarrel() {
        return fuelPriceUsdPerBarrel;
    }

    public double getWarehouseUtilizationPercent() {
        return warehouseUtilizationPercent;
    }

    public int getDamageClaimsCount() {
        return damageClaimsCount;
    }

    // Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setShipmentsProcessed(int shipmentsProcessed) {
        this.shipmentsProcessed = shipmentsProcessed;
    }

    public void setDelayHoursAvg(double delayHoursAvg) {
        this.delayHoursAvg = delayHoursAvg;
    }

    public void setFuelPriceUsdPerBarrel(double fuelPriceUsdPerBarrel) {
        this.fuelPriceUsdPerBarrel = fuelPriceUsdPerBarrel;
    }

    public void setWarehouseUtilizationPercent(double warehouseUtilizationPercent) {
        this.warehouseUtilizationPercent = warehouseUtilizationPercent;
    }

    public void setDamageClaimsCount(int damageClaimsCount) {
        this.damageClaimsCount = damageClaimsCount;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Date: %-12s | Region: %-15s | Carrier: %-15s | Shipments: %-6d | Delay Avg: %-6.2f | Fuel Price: %-6.2f | Utilization: %-6.2f%% | Damage Claims: %d",
            date,
            region,
            carrier,
            shipmentsProcessed,
            delayHoursAvg,
            fuelPriceUsdPerBarrel,
            warehouseUtilizationPercent,
            damageClaimsCount
        );
    }
}