INSERT INTO make(name, country, description) VALUES ('BMW', 'Germany', 'Bayerische Motoren Werke')
INSERT INTO make(name, country, description) VALUES ('Ford', 'USA', 'Ford Motor Company')
INSERT INTO make(name, country) VALUES ('Nissan', 'Japan')
INSERT INTO make(name, country) VALUES ('Opel', 'Germany')
INSERT INTO make(name, country, description) VALUES ('Volvo', 'Sweden', 'Aktiebolaget Volvo')

INSERT INTO engine(type, capacity, horsepower) VALUES ('petrol', 2000, 125)
INSERT INTO engine(type, capacity, horsepower) VALUES ('diesel', 2500, 220)
INSERT INTO engine(type, capacity, horsepower) VALUES ('lpg', 2000, 180)
INSERT INTO engine(type, capacity, horsepower) VALUES ('petrol', 3000, 340)
INSERT INTO engine(type, capacity, horsepower) VALUES ('diesel', 2000, 110)

INSERT INTO car(engineId, makeId, model, price, productionDate) VALUES (1, 2, '325 Coupe', 160000, '2012-07-20 00:00:00.0')
INSERT INTO engine_car(engine_id, cars_id) VALUES (2, 1)
INSERT INTO make_car(make_id, cars_id) VALUES (1, 1)

INSERT INTO car(engineId, makeId, model, price, productionDate) VALUES (4, 5, 'S80', 340000, '2013-11-01 00:00:00.0')
INSERT INTO engine_car(engine_id, cars_id) VALUES (4, 1)
INSERT INTO make_car(make_id, cars_id) VALUES (5, 1)