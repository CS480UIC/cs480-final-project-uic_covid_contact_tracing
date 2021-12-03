CREATE VIEW unvaccinated_students
AS
SELECT *
FROM student
WHERE vaccination_status != 2
ORDER BY uin;

CREATE VIEW covid_tests_not_negative
AS
SELECT * 
FROM covid_test
WHERE test_result != 0
ORDER BY uin;

CREATE VIEW arc_residents
AS
SELECT *
FROM student_housing
WHERE dorm_id = 'ARC';

-- find percentage frequency of covid test results
CREATE VIEW test_result_percentages
AS
SELECT test_result, ROUND(COUNT(*)*100.0 / (SELECT COUNT(*) FROM covid_test), 2) AS percentage
FROM covid_test
GROUP BY test_result;

-- find number of students per organization, filtering out orgs with 1 or fewer members
CREATE VIEW num_members_per_org
AS
SELECT UPPER(organization_name) AS organization_name, COUNT(*) AS count
FROM organization
GROUP BY organization_id HAVING COUNT(*) >= 2;

-- find number of covid tests taken in 2021
CREATE VIEW num_covid_tests_2021
AS
SELECT COUNT(*) AS count
FROM covid_test
WHERE YEAR(test_date) = 2021;

--

CREATE VIEW uic_residents_vaccination_status
AS
SELECT student.uin AS uin, vaccination_status, first_name, last_name, student.dorm_id AS dorm_id, student_housing.room_number AS room_number
FROM student
JOIN student_housing
ON student.uin = student_housing.uin
ORDER BY dorm_id, last_name;

CREATE VIEW large_organizations
AS
SELECT *
FROM organization A
WHERE 2 <=
	(SELECT COUNT(*)
	 FROM organization
     WHERE organization_id = A.organization_id);

CREATE VIEW unvaccinated_students_in_orgs
AS
SELECT *
FROM organization A
WHERE EXISTS
	(SELECT *
	 FROM student
     WHERE uin = A.uin AND vaccination_status != 2);