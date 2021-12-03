CREATE DEFINER=`root`@`localhost` PROCEDURE `course_students`(IN course_id mediumint)
BEGIN
	SELECT uin FROM course WHERE course_id = course_id;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_students`()
BEGIN
	SELECT * FROM student;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `org_students`(IN organization_name varchar(100))
BEGIN
	SELECT uin FROM organization where organization_name = organization_name;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `class_type`(size int) RETURNS varchar(20) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
IF size > 65 THEN
RETURN ("online");
ELSE 
RETURN ("in person");
END IF;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `covid_percentage`(class_size int, covid_count int) RETURNS decimal(3,2)
    DETERMINISTIC
BEGIN
RETURN (class_size/covid_count);
END

CREATE DEFINER=`root`@`localhost` FUNCTION `is_eligible`(test_result int) RETURNS varchar(5) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
IF test_result > 0 THEN
RETURN ("no");
ELSE
RETURN ("yes");
END IF;
END