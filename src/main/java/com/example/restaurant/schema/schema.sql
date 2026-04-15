
CREATE TABLE IF NOT EXISTS Restaurant (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    phoneNum VARCHAR(20) NOT NULL,
    peopleCapacity INT NOT NULL,
    street VARCHAR(45) NOT NULL,
    streetNumber VARCHAR(45) NOT NULL,
    zipCode VARCHAR(45) NOT NULL, 
    city VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    email VARCHAR(80) NOT NULL UNIQUE,
    phoneNum VARCHAR(20) NOT NULL
);


CREATE TABLE IF NOT EXISTS Menu (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    category VARCHAR(45) NOT NULL,
    available SMALLINT NOT NULL,
    restaurant_id BIGINT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Reservation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    reserveDate DATE NOT NULL,
    reserveAt TIME NOT NULL,
    numberPeople INT NOT NULL,
    user_id BIGINT NOT NULL,
    restaurant_id BIGINT NOT NULL,
    CONSTRAINT fk_reservation_user FOREIGN KEY (user_id) REFERENCES Users(id),
    CONSTRAINT fk_reservation_restaurant FOREIGN KEY (restaurant_id) REFERENCES Restaurant(id)
);