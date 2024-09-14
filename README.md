# ZIP Code Service 🚀

## Overview
This Spring Boot application allows you to manage ZIP code data through a RESTful API. It supports uploading ZIP code data from a CSV file, searching for specific ZIP codes, and finding nearby ZIP codes.

## Features
- 📁 Upload ZIP code data in CSV format
- 🔍 Search for a specific ZIP code
- 🌍 Find nearby ZIP codes by radial distance

## Technologies Used
- ☕ Java 17
- 🛠 Spring Boot
- 🗄 H2 Database
- 📊 OpenCSV

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

- Sample US Zipcode Data `https://arcg.is/1DjevT0`

### APIs

#### 1. Upload ZIP Code Data
- **Endpoint**: `POST /uploadFile`
- **Request**: 
  - Parameter: `file` (CSV file)
- **Response**:
  - Status 200 if successful
  - Status 400 if file is empty
  - Status 500 on server error

#### 2. Get Data by ZIP Code
- **Endpoint**: `GET /{stdZip5}`
- **Path Variable**: 
  - `stdZip5`: The ZIP code to search for
- **Response**:
  - Status 200 with ZIP data if found
  - Status 404 if not found

#### 3. Get Nearby ZIP Codes
- **Endpoint**: `GET /nearbyZipCodes`
- **Query Parameters**: 
  - `zipcode`: The ZIP code to search nearby for
  - `radius`: Optional radius in kilometers (default is 20)
- **Response**:
  - Status 200 with a list of nearby ZIP codes if found
  - Status 404 if none found

### Contributing 🤝
Feel free to open issues or submit pull requests for any improvements or features you'd like to see!
