# Entities

Person <br>
Synonyms: none <br>
Description: A person is any human that attends UIC. Persons include students and employees <br>
Attributes: 
* uin 1-1(1)
* vaccination_status M-M(0)
* first_name M-1(1)
* last_name M-1(1)
<br>
Student<br>
Synonyms: scholar<br>
Description: A student is a type of person who has a major at UIC. A student can live in the student_housing or off campus.
<br>
Attributes: 
* Student_living_status 0-M(1)
* Student_major_name 0-M(0)
* Uin 1-M(1)
<br>
Employee<br>
Synonyms: worker, staff, faculty, professor<br>
Description: a person employed for wages or salary<br>
Attributes:
* department_name
<br>
Course<br>
Synonyms: class<br>
Description: A course is a class that students and employees (professors) can be enrolled in. The course location can be a location on campus or online.<br>
Attributes:
* course_id 1-1(1)
* uin 1-M(1)
* course_location 1-M(0)
<br>
Organization<br>
Synonyms: clubs, extracurriculars<br>
Description: An organization is a collection of people who participate in a specific activity. Any person can be in any organization <br>
Attributes:
* organization_id 1-1(1)
* organization_name 1-1(1)
* uin 1-M(1)
<br>
Student_housing<br>
Synonyms: dorms<br>
Description: a building for people to live and reside in, these people are usually students and sometimes employees. <br>
Attributes:
* dorm_id 1-1(1)
* room_number 1-1(1)
* uin 1-M(1)
<br>
Contact_information<br>
Synonyms: None<br>
Description: Contact_information contains information about persons at UIC. Every person at UIC as a contact information<br>
Attributes:
* email_address 1-M(1)
* phone_number 1-M(1)
* address 1-M(1)
* uin 1-1(1)

 <br>
## Relationships

person_takes_covid_test
* Maxima: many-many. Many people can take many COVID-19 tests.
* Minima: zero-zero. A person can be untested.
<br>
person_has_contact_information
* Maxima: one-one. One person can have one set of contact information.
* Minima: one-zero. Contact information must belong to a person, but not all people have contact information.
<br>
person_is_in_organization
* Maxima: many-many. Many people can be in many organizations.
* Minima: zero-zero. A person can not be in any organization.
<br>
person_enrolls_in_course
* Maxima: many-many. Many people can be in many courses.
* Minima: zero-zero. A person (presumably an employee that isn’t a professor) can not be in any course.
<br>
student_lives_in_student_housing
* Maxima: many-one. Many people can be in one dorm.
* Minima: zero-zero. A person can not be in a dorm.


