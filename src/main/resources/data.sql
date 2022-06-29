INSERT INTO CITY(id,name)
VALUES
	(1,'Perth'),
	(2,'Sydney'),
	(3,'Brisbane'),
	(4,'Melbourne'),
	(5,'Adelaide'),
	(6,'Darwin');

INSERT INTO ADDRESS (id,line1,line2,postalcode,city_id,cuntry)
VALUES
	(1,'41 Nautical Grove','Beldon','6027',1,'Australia'),
	(2,'42 Nautical Grove','Beldon','6028',1,'Australia'),
	(3,'15 Nautical Grove','Hilaryis','6029',1,'Australia'),
	(4,'41 Nautical Grove','Beldon','6027',2,'Australia'),
	(5,'41 Nautical Grove','Beldon','6027',3,'Australia'),
	(6,'41 Nautical Grove','Beldon','6027',4,'Australia'),
	(7,'41 Nautical Grove','Beldon','6027',5,'Australia'),
	(8,'41 Nautical Grove','Beldon','6027',6,'Australia');


INSERT INTO PERSON (id,title,name, email,address_id) 
VALUES
  	(1,'Mr', 'Mohamed Osman', 'mosman@gmail.com',1),
  	(2,'Mr', 'Mohamed2 Osman', 'mosman2@gmail.com',2),
  	(3,'Mr', 'Mohamed3 Osman', 'mosman3@gmail.com',3),
  	(4,'Mr', 'Mohamed4 Osman', 'mosman4@gmail.com',4),
  	(5,'Mr', 'Mohamed5 Osman', 'mosman5@gmail.com',5),
  	(6,'Mr', 'Mohamed6 Osman', 'mosman6@gmail.com',6),
  	(7,'Mrs', 'Marwa Rawy', 'xyz@email.com',7);
  
INSERT INTO CHILD(id,name,age,gender,person_id)
VALUES
	(1,'Abdo',8,'Male',1),
	(2,'Reem',11,'Female',1),
	(3,'Abdo2',9,'Male',1),
	(4,'Abdo3',10,'Male',2),
	(5,'Abdo4',1,'Male',2),
	(6,'Abdo5',2,'Male',3),
	(7,'Abdo6',3,'Male',5),
	(8,'Abdo7',4,'Male',5),
	(9,'Abdo8',5,'Male',5),
	(10,'Abdo9',6,'Male',6),
	(11,'Abdo10',7,'Male',6),
	(12,'Abdo11',11,'Male',6),
	(13,'Abdo12',12,'Male',6);

