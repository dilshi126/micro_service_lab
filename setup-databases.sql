-- Run this script in pgAdmin or psql to create all databases

CREATE DATABASE studentsdb;
CREATE DATABASE coursedb;
CREATE DATABASE enrollmentdb;
CREATE DATABASE resultdb;

-- Grant privileges (if needed)
GRANT ALL PRIVILEGES ON DATABASE studentsdb TO postgres;
GRANT ALL PRIVILEGES ON DATABASE coursedb TO postgres;
GRANT ALL PRIVILEGES ON DATABASE enrollmentdb TO postgres;
GRANT ALL PRIVILEGES ON DATABASE resultdb TO postgres;
