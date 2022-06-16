insert into university values ('a4c1a702-ceb2-44aa-93c2-89d42e7fd011', 'NURE');

insert into universityGroup (id, groupName, university_id) values
    ('cecf7e56-df05-42c0-b8c3-99b410270a72', 'KNT-20-1','a4c1a702-ceb2-44aa-93c2-89d42e7fd011'),
    ('37381d28-bba0-4b46-ab41-00289ba0bc4f', 'KNT-20-2','a4c1a702-ceb2-44aa-93c2-89d42e7fd011');

insert into student (name) values
    (1, 'Bezuhlyi Nazar'),
    (2, 'Biryukova Uyliia'),
    (3, 'Klochko Liza'),
    (4, 'Cherhinskaya Masha'),
    (5, 'Shulimenko Sofiia');

insert into universitygroup_student (universityGroup_id, srudent_id) values
	('cecf7e56-df05-42c0-b8c3-99b410270a72', 1),
	('cecf7e56-df05-42c0-b8c3-99b410270a72', 2),
	('37381d28-bba0-4b46-ab41-00289ba0bc4f' , 3),
	('37381d28-bba0-4b46-ab41-00289ba0bc4f' , 4),
	('37381d28-bba0-4b46-ab41-00289ba0bc4f' , 5);

insert into curator (id, fullName, birthdate, experience, universityGroup_id) values
    ('6264fa0d-f594-4400-852c-5c57105c6ce3', 'Vyshnyak V.V.', 1966-12-01, 'cecf7e56-df05-42c0-b8c3-99b410270a72'),
    ('1cf84fd5-fa22-4b6d-ac16-d40bc2ed6c07', 'Mischeriakov S.Y', 1978-05-06, '37381d28-bba0-4b46-ab41-00289ba0bc4f');

insert into course (id, name, difficultyLvl) values
    ('d8fd75f3-5df8-444d-b489-98ea4857cc33', 'Discrete Mathematics', 7),
    ('b1bd6839-4794-4d08-a625-0d7e78f71ee8', 'Numeric Methods', 6),
    ('86f1e9ae-6c9a-446e-ad0e-7e32d4a4b638', 'English', 4);

insert into student_course (student_id, course_id) values
    (1, 'd8fd75f3-5df8-444d-b489-98ea4857cc33'),
    (2, 'b1bd6839-4794-4d08-a625-0d7e78f71ee8'),
    (3, 'd8fd75f3-5df8-444d-b489-98ea4857cc33'),
    (4, '86f1e9ae-6c9a-446e-ad0e-7e32d4a4b638'),
    (5, '86f1e9ae-6c9a-446e-ad0e-7e32d4a4b638');