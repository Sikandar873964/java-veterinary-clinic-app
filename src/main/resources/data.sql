-- Customer data
MERGE INTO CUSTOMERS
    (CUSTOMER_ID,CREATED_TIME,EMAIL_ID,CUSTOMER_NAME,LAST_UPDATED_TIME)
    KEY (CUSTOMER_ID)
    values (1, current_time (),'test@gmail.com','Test', current_time ());

-- Hospitals data
MERGE INTO HOSPITALS(HOSPITAL_ID,CREATED_TIME,HOSPITAL_DESCRIPTION,HOSPITAL_END_TIME,HOSPITAL_START_TIME,HOSPITAL_NAME,LAST_UPDATED_TIME)
    KEY (HOSPITAL_ID)
    values (2, current_time,'Test Hospital','23:00:00','10:00:00','Test Hospital', current_time);
MERGE INTO HOSPITALS(HOSPITAL_ID,CREATED_TIME,HOSPITAL_DESCRIPTION,HOSPITAL_END_TIME,HOSPITAL_START_TIME,HOSPITAL_NAME,LAST_UPDATED_TIME)
    KEY (HOSPITAL_ID)
    values (3, current_time,'Manchester Hospital','23:00:00','10:00:00','Manchester Hospital', current_time);

-- Animals Data
MERGE INTO ANIMALS(ANIMAL_ID, ANIMAL_TYPE, ANIMAL_CATEGORY, ANIMAL_NAME, CREATED_TIME, DANGEROUS_LEVEL, LAST_UPDATED_TIME)
    KEY (ANIMAL_ID)
    VALUES
    (101, 'FARM_ANIMAL', 'Farm Animal', 'Cow', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (102, 'FARM_ANIMAL', 'Farm Animal', 'Chicken', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (103, 'FARM_ANIMAL', 'Farm Animal', 'Sheep', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (104, 'FARM_ANIMAL', 'Farm Animal', 'Goat', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (105, 'FARM_ANIMAL', 'Farm Animal', 'Pig', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (106, 'PET', 'Pet', 'Dog', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (107, 'PET', 'Pet', 'Cat', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (108, 'PET', 'Pet', 'Parrot', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (109, 'PET', 'Pet', 'Hamster', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (110, 'PET', 'Pet', 'Goldfish', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (111, 'ZOO', 'Zoo Animal', 'Elephant', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (112, 'ZOO', 'Zoo Animal', 'Giraffe', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (113, 'ZOO', 'Zoo Animal', 'Zebra', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (114, 'ZOO', 'Zoo Animal', 'Kangaroo', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (115, 'ZOO', 'Zoo Animal', 'Panda', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (116, 'ZOO', 'Zoo Animal', 'Lion', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (117, 'ZOO', 'Zoo Animal', 'Tiger', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (118, 'ZOO', 'Zoo Animal', 'Bear', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (119, 'ZOO', 'Zoo Animal', 'Rhino', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (120, 'ZOO', 'Zoo Animal', 'Hippopotamus', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (121, 'WILD', 'Wild Animal', 'Wolf', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (122, 'WILD', 'Wild Animal', 'Fox', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (123, 'WILD', 'Wild Animal', 'Deer', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (124, 'WILD', 'Wild Animal', 'Bear', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (125, 'WILD', 'Wild Animal', 'Eagle', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (126, 'WILD', 'Wild Animal', 'Leopard', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (127, 'WILD', 'Wild Animal', 'Buffalo', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (128, 'WILD', 'Wild Animal', 'Crocodile', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (129, 'WILD', 'Wild Animal', 'Cheetah', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (130, 'WILD', 'Wild Animal', 'Hyena', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (131, 'FARM_ANIMAL', 'Farm Animal', 'Duck', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (132, 'FARM_ANIMAL', 'Farm Animal', 'Horse', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (133, 'FARM_ANIMAL', 'Farm Animal', 'Turkey', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (134, 'FARM_ANIMAL', 'Farm Animal', 'Donkey', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (135, 'FARM_ANIMAL', 'Farm Animal', 'Rabbit', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (136, 'PET', 'Pet', 'Turtle', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (137, 'PET', 'Pet', 'Guinea Pig', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (138, 'PET', 'Pet', 'Ferret', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (139, 'PET', 'Pet', 'Snake', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (140, 'PET', 'Pet', 'Iguana', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (141, 'ZOO', 'Zoo Animal', 'Monkey', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (142, 'ZOO', 'Zoo Animal', 'Flamingo', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (143, 'ZOO', 'Zoo Animal', 'Peacock', CURRENT_TIME, 'LOW', CURRENT_TIME),
    (144, 'ZOO', 'Zoo Animal', 'Ostrich', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (145, 'ZOO', 'Zoo Animal', 'Gorilla', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (146, 'WILD', 'Wild Animal', 'Jaguar', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (147, 'WILD', 'Wild Animal', 'Moose', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (148, 'WILD', 'Wild Animal', 'Panther', CURRENT_TIME, 'HIGH', CURRENT_TIME),
    (149, 'WILD', 'Wild Animal', 'Ocelot', CURRENT_TIME, 'MEDIUM', CURRENT_TIME),
    (150, 'WILD', 'Wild Animal', 'Raccoon', CURRENT_TIME, 'LOW', CURRENT_TIME);
