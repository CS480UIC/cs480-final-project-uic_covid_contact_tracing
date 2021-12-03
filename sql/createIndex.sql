CREATE INDEX MajorIndex
ON student(student_major_name);

CREATE INDEX AddressIndex
ON contact_information(address);

CREATE INDEX CourseIndex
ON course(course_id);

CREATE INDEX TestIndex
ON covid_test(test_date);

CREATE INDEX OrganizationNameIndex
ON organization(organization_name);

CREATE INDEX DormIndex
ON student_housing(dorm_id);