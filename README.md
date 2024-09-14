# ZIP Code Service 🚀

## Overview
This Spring Boot application allows you to manage ZIP code data through a RESTful API. It supports uploading ZIP code data from a CSV file, searching for specific ZIP codes, and finding nearby ZIP codes.

## Features
- 📁 Upload ZIP code data in CSV format
- 🔍 Fetch data of specific ZIP code
- 🌍 Find nearby ZIP codes by radial distance

## Technologies Used
- ☕ Java 17
- 🛠 Spring Boot
- 🗄 SQL Database

## Getting Started

### Prerequisites
- Java 17 or later
- Gradle

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd zipcode-service
   ```

2. Run the application using Gradle:
   ```bash
   ./gradlew bootRun
   ```

### Required CSV Data Format

To upload ZIP code data, make sure your CSV file includes the following fields:

| **Field Name**             | **Data Type** | **Description**                                       |
|----------------------------|----------------|-------------------------------------------------------|
| `stdZip5`                  | String         | Standard 5-digit ZIP code (required, unique)         |
| `uspsZipPrefCity`         | String         | Preferred city name for the ZIP code                  |
| `uspsZipPrefState`        | String         | State abbreviation for the ZIP code                   |
| `latitude`                | Double         | Geographical latitude of the location                  |
| `longitude`               | Double         | Geographical longitude of the location                 |
| `x`                       | Double         | Unused coordinate (optional)                           |
| `y`                       | Double         | Unused coordinate (optional)                           |

- ### [Sample US Zipcode Data](https://arcg.is/1DjevT0)

### API Documentation
For detailed API usage and endpoints, refer to the [API Documentation](https://snitin06820.github.io/Finding-Nearby-Zipcodes/).

### Contributing 🤝
Feel free to open issues or submit pull requests for any improvements or features you'd like to see!
