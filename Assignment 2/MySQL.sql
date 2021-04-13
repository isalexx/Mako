
CREATE DATABASE mako;
USE mako;

DROP TABLE IF EXISTS smartPhones;

CREATE TABLE smartPhones(
    id int NOT NULL AUTO_INCREMENT,
    manufacturer VARCHAR(30),
    model VARCHAR(30),
    price float(6, 2),
    serialNum int,
    screenSizeInch float(3,1),
    cameraMp int,
    operatingSystem varchar(25),
    memoryGb int,
    colour varchar(25),
    PRIMARY KEY (id)
);


INSERT INTO smartPhones (manufacturer, model, price, serialNum, screenSizeInch, cameraMp, operatingSystem, memoryGb, colour) VALUES ('Samsung', 'Galaxy S21', 1400.00, 2733318, 6.2, 88, 'Android 11', 256, 'Prism Black');
INSERT INTO smartPhones (manufacturer, model, price, serialNum, screenSizeInch, cameraMp, operatingSystem, memoryGb, colour) VALUES ('Iphone', '11', 875.00, 6980091, 6.1, 36, 'IOS 13', 128, 'Rose Gold');
INSERT INTO smartPhones (manufacturer, model, price, serialNum, screenSizeInch, cameraMp, operatingSystem, memoryGb, colour) VALUES ('LG', 'Velvet', 750.00, 8535505, 6.8, 61, 'Android 10', 128, 'Sunset');
INSERT INTO smartPhones (manufacturer, model, price, serialNum, screenSizeInch, cameraMp, operatingSystem, memoryGb, colour) VALUES ('Google', 'Pixel 5', 940.00, 4054700, 6.0, 28, 'Android 11', 128, 'Sorta Sage');
INSERT INTO smartPhones (manufacturer, model, price, serialNum, screenSizeInch, cameraMp, operatingSystem, memoryGb, colour) VALUES ('Huawei', 'P30', 949.99, 3314022, 6.1, 64, 'Android 9', 128, 'Breathing Crystal');

DROP TABLE IF EXISTS smartWatches;

CREATE TABLE smartWatches(
    id int NOT NULL AUTO_INCREMENT,
    manufacturer VARCHAR(30),
    model VARCHAR(30),
    price float(6, 2),
    serialNum int,
    heartRateSens bool,
    diameterMm int,
    finish varchar(25),
    PRIMARY KEY (id)
);

INSERT INTO smartWatches (manufacturer, model, price, serialNum, heartRateSens, diameterMm, finish) VALUES ('Samsung', 'Galaxy Watch Active 2', 519.99, 4597878, true, 44, 'Stainless Steel');
INSERT INTO smartWatches (manufacturer, model, price, serialNum, heartRateSens, diameterMm, finish) VALUES ('Apple', 'Watch Series 6', 698.99, 9014142, true, 44, 'Aluminum');
INSERT INTO smartWatches (manufacturer, model, price, serialNum, heartRateSens, diameterMm, finish) VALUES ('Huawei', 'Watch GT 2 Pro', 398.99, 4548725, true, 46, 'Titanium');

