
public class BusinessAnalysis {
	// Apa Penyebab Keterlambatan Pengiriman? Hitung jumlah On-Time vs Delayed
	public static void analyzeDeliveryPerformance(DataWarehouseStore warehouse) {

	    int onTime = 0;
	    int delayed = 0;

	    for (Shipment s : warehouse.getShipmentTable()) {

	        if (s.getDeliveryStatus().equalsIgnoreCase("On-Time")) {
	            onTime++;
	        } else {
	            delayed++;
	        }
	    }

	    System.out.println("\n=== DELIVERY PERFORMANCE ===");
	    System.out.println("On-Time Shipments : " + onTime);
	    System.out.println("Delayed Shipments : " + delayed);

	    double delayRate =
	            ((double) delayed / warehouse.getShipmentTable().size()) * 100;

	    System.out.printf("Delay Rate : %.2f%%\n", delayRate);
	}
	//Carrier Mana yang Paling Efisien? Karena tabel Logistics punya Carrier dan Delay Hours.
	public static void analyzeCarrierEfficiency(DataWarehouseStore warehouse) {

	    System.out.println("\n=== CARRIER PERFORMANCE ===");

	    for (LogisticsPerformance l : warehouse.getLogisticsTable()) {

	        System.out.printf(
	                "Carrier: %-15s Delay Avg: %.2f jam\n",
	                l.getCarrier(),
	                l.getDelayHoursAvg()
	        );
	    }
	}
	//carrier dengan delay paling kecil
	public static void bestCarrier(DataWarehouseStore warehouse) {

	    LogisticsPerformance best =
	            warehouse.getLogisticsTable().get(0);

	    for (LogisticsPerformance l : warehouse.getLogisticsTable()) {

	        if (l.getDelayHoursAvg() < best.getDelayHoursAvg()) {
	            best = l;
	        }
	    }

	    System.out.println("\n=== MOST EFFICIENT CARRIER ===");

	    System.out.println("Carrier : " + best.getCarrier());

	    System.out.println("Average Delay : "
	            + best.getDelayHoursAvg());
	}
	//Apakah Lead Time Mempengaruhi Kepuasan Pelanggan? Hitung rata-rata.
	public static void analyzeCustomerSatisfaction(DataWarehouseStore warehouse) {

	    int highLeadLowSat = 0;

	    for (Customer c : warehouse.getCustomerTable()) {

	        if (c.getLeadTimeDays() > 7 &&
	            c.getSatisfactionScore() <= 2) {

	            highLeadLowSat++;
	        }
	    }

	    System.out.println("\n=== CUSTOMER SATISFACTION ANALYSIS ===");

	    System.out.println(
	        "Customer dengan Lead Time > 7 hari dan Satisfaction <= 2 : "
	        + highLeadLowSat
	    );
	}
	//Rute Mana yang Memiliki Biaya Logistik Tertinggi? Cari freight cost terbesar.
	public static void highestCostRoute(DataWarehouseStore warehouse) {

	    Shipment highest =
	            warehouse.getShipmentTable().get(0);

	    for (Shipment s : warehouse.getShipmentTable()) {

	        if (s.getFreightCost() > highest.getFreightCost()) {
	            highest = s;
	        }
	    }

	    System.out.println("\n=== HIGHEST COST ROUTE ===");

	    System.out.println(
	            highest.getOrigin()
	                    + " -> "
	                    + highest.getDestination()
	    );

	    System.out.println(
	            "Freight Cost : "
	                    + highest.getFreightCost()
	    );
	}
	//KPI Apa yang Harus Diprioritaskan? Buat Executive Summary.
	public static void executiveKPI(DataWarehouseStore warehouse) {

	    int delayed = 0;

	    double totalFreight = 0;

	    double totalSatisfaction = 0;

	    for (Shipment s : warehouse.getShipmentTable()) {

	        totalFreight += s.getFreightCost();

	        if (!s.getDeliveryStatus()
	                .equalsIgnoreCase("On-Time")) {

	            delayed++;
	        }
	    }

	    for (Customer c : warehouse.getCustomerTable()) {

	        totalSatisfaction +=
	                c.getSatisfactionScore();
	    }

	    System.out.println("\n=== EXECUTIVE KPI ===");

	    System.out.println(
	            "Total Shipment : "
	                    + warehouse.getShipmentTable().size());

	    System.out.printf(
	            "Average Freight Cost : %.2f\n",
	            totalFreight /
	                    warehouse.getShipmentTable().size());

	    System.out.printf(
	            "Average Satisfaction : %.2f\n",
	            totalSatisfaction /
	                    warehouse.getCustomerTable().size());

	    System.out.printf(
	            "Delay Rate : %.2f%%\n",
	            ((double) delayed /
	                    warehouse.getShipmentTable().size()) * 100);
	}
}

