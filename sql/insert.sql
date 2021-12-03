INSERT INTO student
VALUES ('687695021','1','Lyle','Levy','1','Computer Science','JST'),
		('648394052','2','Woodie','Larsen','0','Biology',NULL),
		('674849301','0','Billy','Good','0','Business Administration',NULL),
		('674393028','2','Delilah','Marx','1','English','CTY'),
 		('647389410','2','Ashley','Jensen','0','Integrated Health Sciences',NULL),
		('689393032','2','Andy','Buzz','1','Chinese','ARC'),
		('612389673','1','Patty','Pine','1','Computer Engineering','ARC'),
		('648394095','2','Sandy','Cheeks','1','Physics','JST');

INSERT INTO contact_information (email_address, phone_number, address, uin)
VALUES ('johndoe@uic.edu','3122134567',"225 S Canal St, Chicago, IL 60606",'647389410'),
('janedoe@uic.edu','773456123',"1664 S Blue Island Ave, Chicago, IL 60608",'648394052'),
('joejo2@uic.edu','6465789821',"500 W Madison St, Chicago, IL 60661",'674393028'),
('morristu8@uic.edu','3127690821',"1035 W Randolph St, Chicago, IL 60607",'674849301'),
('jreyes21@uic.edu','7738885400',"1380 W Lake St, Chicago, IL 60607",'687695021');

INSERT INTO course (course_id, uin, course_location)
VALUES ('12345','647389410','AH_101'),
('30210','648394052','ARC_201'),
('40512','674393028','LH_302'),
('67892','674849301','SES_250'),
('32489','687695021','TH_120');

INSERT INTO covid_test
VALUES ('647389410','2020-12-21','2020-12-24',1),
('648394052','2020-10-29','2020-11-01',0),
('674393028','2021-10-06','2021-10-10',0),
('674849301','2020-05-08','2020-05-07',1),
('687695021','2021-09-10','2021-09-12',0);

INSERT INTO organization (organization_id, organization_name, uin)
VALUES ('25246',"Filipinos In Alliance",'674849301'),
('87592',"Vietnamese Student Association",'674849301'),
('45482',"Alpha Kappa Delta Phi Sorority, Inc.",'648394052'),
('25246',"Filipinos In Alliance",'647389410'),
('75932',"UIC Dental Club",'648394052');

INSERT INTO student_housing (dorm_id, room_number, uin)
VALUES ('JST','120','687695021'),
('JST','503','648394095'),
('ARC','702','612389673'),
('ARC','402','689393032'),
('CTY','608','674393028');

