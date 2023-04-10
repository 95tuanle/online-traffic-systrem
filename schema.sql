DROP DATABASE IF EXISTS online_traffic_system;

CREATE DATABASE IF NOT EXISTS online_traffic_system;

USE online_traffic_system;

DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
                                    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                    email VARCHAR(256) UNIQUE NOT NULL,
                                    password VARCHAR(64) NOT NULL
);

DROP TABLE IF EXISTS vehicle;

CREATE TABLE IF NOT EXISTS vehicle (
                                       id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                       plate_number VARCHAR(16) UNIQUE NOT NULL,
                                       description VARCHAR(256) NOT NULL
);

DROP TABLE IF EXISTS incident;

CREATE TABLE IF NOT EXISTS incident (
                                        id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                        user_id INT UNSIGNED NOT NULL,
                                        FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE,
                                        vehicle_id INT UNSIGNED NOT NULL,
                                        FOREIGN KEY (vehicle_id) REFERENCES vehicle(id) ON DELETE CASCADE ON UPDATE CASCADE,
                                        date_time DATETIME NOT NULL,
                                        description VARCHAR(256) NOT NULL
);