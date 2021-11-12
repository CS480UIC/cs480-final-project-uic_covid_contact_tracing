SELECT *
FROM student
WHERE vaccination_status != 2
ORDER BY uin;

SELECT * 
FROM covid_test
WHERE test_result != 0
ORDER BY uin;

SELECT *
FROM student_housing
WHERE dorm_id = 'ARC';

-- find percentage frequency of covid test results
SELECT test_result, ROUND(COUNT(*)*100.0 / (SELECT COUNT(*) FROM covid_test), 2) AS percentage
FROM covid_test
GROUP BY test_result;

-- find number of students per organization, filtering out orgs with 1 or fewer members
SELECT UPPER(organization_name), COUNT(*)
FROM organization
GROUP BY organization_id HAVING COUNT(*) >= 2

-- find number of covid tests taken in 2021
SELECT COUNT(*)
FROM covid_test
WHERE YEAR(test_date) = 2021;

--

SELECT vaccination_status, first_name, last_name, student.dorm_id, student_housing.room_number
FROM student
JOIN student_housing
ON student.uin = student_housing.uin
ORDER BY dorm_id, last_name;

SELECT *
FROM organization A
WHERE 2 <=
	(SELECT COUNT(*)
	 FROM organization
     WHERE organization_id = A.organization_id);

SELECT *
FROM organization A
WHERE EXISTS
	(SELECT *
	 FROM student
     WHERE uin = A.uin AND vaccination_status != 2);