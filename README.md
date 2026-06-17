# Supply Chain Performance Analytics Dashboard
Java-based ETL and Business Intelligence project for analyzing shipment performance, customer satisfaction, and logistics efficiency.

## Business Problem
The organization needs to monitor logistics performance, shipment delays, freight costs, and customer satisfaction to support operational and strategic decision making.
1. What is the shipment delay rate?
2. Which carrier is the most efficient?
3. Which shipment route has the highest logistics cost?
4. Does lead time affect customer satisfaction?
5. Which KPIs should management prioritize?
   
## Dataset
The project uses three datasets:
- Shipment Data
- Customer Data
- Logistics Performance Data

<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/349edf57-1a98-4b49-8838-4d1eeb170012" />

## ETL Process
1. Extract data from CSV files
2. Validate record structure
3. Detect missing destination country values
4. Recover missing country values using Master Data Lookup
5. Load cleansed data into the Data Warehouse

## Data Cleansing
Some shipment records contained missing destination country values.
Example:
Destination = Singapore
Country = NULL
The ETL process automatically restored missing values using a Country Reference Master Data lookup.

## Business Insights
### Delivery Performance
- On-Time Shipments: 612
- Delayed Shipments: 116
- Delay Rate: 15.93%

### Most Efficient Carrier
- Carrier: ReliableLogistics
- Average Delay: 0.9 hours

### Highest Cost Route
- Yokohama, Japan → Mumbai, India
- Freight Cost: 20,750

### Customer Satisfaction
- Average Satisfaction: 4.18 / 5

### Executive KPI
- Total Shipment: 728
- Average Freight Cost: 7,121.33
- Delay Rate: 15.93%

## Recommendations
1. Prioritize ReliableLogistics for critical shipments due to the lowest average delay.
2. Investigate delayed shipments because the delay rate reached 15.93%.
3. Review the Yokohama → Mumbai route because it has the highest freight cost.
4. Continue maintaining customer satisfaction above 4.0.
5. Build a management dashboard to continuously monitor logistics KPIs.
