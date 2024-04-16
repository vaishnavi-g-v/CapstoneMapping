INSERT INTO student (srn, semester, cgpa, Fname, Lname, email, pswd, outgoing_year) values
('PES1UG21CS695', 5, 8.35, 'Vaishnavi', 'Venu', 'vaishnavigv@example.com', 'ABC', 2025),
('PES1UG21CS699', 5, 8.7, 'Varsha', 'Rohidekar', 'varshar@example.com', 'ABC', 2025),
('PES1UG21CS628', 5, 8.9, 'Stuti', 'Udupa', 'stuthiu@example.com', 'ABC', 2025),
('PES1UG21CS629', 5, 9.0, 'Stuthi', 'Pathak', 'stuthip@example.com', 'ABC', 2025),
('PES1UG21CS700', 5, 7.6, 'Adithya', 'S', 'adithyas@example.com', 'ABC', 2025),
('PES1UG21CS701', 5, 8.45, 'Adithi', 'Bhushan', 'adithib@example.com', 'ABC', 2025),
('PES1UG21CS702', 5, 7.97, 'Anagha', 'Kumble', 'anaghak@example.com', 'ABC', 2025),
('PES1UG21CS703', 5, 7.4, 'Ujjwal', 'MK', 'ujjwalmk@example.com', 'ABC', 2025),
('PES1UG21CS704', 5, 8.20, 'Varun', 'B', 'varunb@example.com', 'ABC', 2025),
('PES1UG21CS705', 5, 8.19, 'Nikhata', 'S', 'nikhatas@example.com', 'ABC', 2025),
('PES1UG21CS706', 5, 9.5, 'Ananya', 'J', 'ananyaj@example.com', 'ABC', 2025),
('PES1UG21CS707', 5, 8.0, 'Sanjana', 'M', 'sanjanam@example.com', 'ABC', 2025),
('PES1UG20CS500', 7, 9.7, 'Kruthika', 'Sanjay', 'kruthikas@example.com', 'ABC', 2024),
('PES1UG20CS501', 7, 8.04, 'Vishrutha', 'Balaji', 'vishruthab@example.com', 'ABC', 2024),
('PES1UG20CS502', 7, 10, 'Punith', 'N', 'punithn@example.com', 'ABC', 2024),
('PES1UG20CS503', 7, 9.8, 'Pranav', 'Acharya', 'pranava@example.com', 'ABC', 2024),
('PES1UG20CS504', 7, 8.94, 'Guna', 'C', 'gunac@example.com', 'ABC', 2024),
('PES1UG20CS505', 7, 8.53, 'Vedant', 'J', 'vedantj@example.com', 'ABC', 2024),
('PES1UG20CS506', 7, 7.98, 'Harshith', 'Gowda', 'harshithg@example.com', 'ABC', 2024),
('PES1UG20CS508', 7, 9.0, 'Rex', 'Lapis', 'moraxarchon@example.com', 'ABC', 2024),
('PES1UG20CS509', 7, 7.5, 'Laasya', 'G', 'laasyag@example.com', 'ABC', 2024),
('PES1UG20CS510', 7, 8.93, 'Shrikar', 'M', 'shrikarm@example.com', 'ABC', 2024),
('PES1UG20CS511', 7, 9.8, 'Aryan', 'Agarwal', 'aryana@example.com', 'ABC', 2024),
('PES1UG20CS512', 7, 8.33, 'Nambrata', 'A', 'nambrataa@example.com', 'ABC', 2024),
('PES1UG21CS712', 5, 8.69, 'Prajwal', 'Rai', 'prajwalrai@example.com', 'ABC', 2025),
('PES1UG21CS713', 5, 9.23, 'HariKrishnan', 'G', 'harig@example.com', 'ABC', 2025),
('PES1UG21CS714', 5, 9.51, 'Abhinav', 'Singh', 'abhisingh@example.com', 'ABC', 2025),
('PES1UG21CS715', 5, 8.82, 'Shrishti', 'A', 'shrishtia123@example.com', 'ABC', 2025);



--UPDATE student
--SET team_teamid = 1
--WHERE srn in ('PES1UG20CS500', 'PES1UG20CS501', 'PES1UG20CS502', 'PES1UG20CS503');

INSERT INTO Teacher (teacher_id, fname, lname, email, pswd) VALUES
('T123456789000', 'Sowmya', 'R', 'sowmyar@example.com', 'DEF'),
('T123456789001', 'Pavan', 'A', 'pavana@example.com', 'DEF'),
('T123456789002', 'Vidhya', 'C', 'vidhyac@example.com', 'DEF'),
('T123456789003', 'Narayan', 'Desai', 'narayand@example.com', 'DEF'),
('T123456789004', 'Madhu', 'P', 'madhu@example.com', 'DEF'),
('T123456789005', 'Sundar', 'L', 'sundarl@example.com', 'DEF'),
('T123456789006', 'Jyothi', 'Kumar', 'jyothik@example.com', 'DEF'),
('T123456789007', 'Shankar', 'Sathish', 'shankars@example.com', 'DEF'),
('T123456789008', 'Shwetha', 'N', 'shwethan@example.com', 'DEF'),
('T123456789009', 'Hrudaya', 'Naidu', 'hrudayan@example.com', 'DEF');

INSERT INTO `supervisor` (teacher_id, fname, lname, email, pswd, team_limit) VALUES
('T123456789000', 'Sowmya', 'R', 'sowmyar@example.com', 'DEF', 2),
('T123456789002', 'Vidhya', 'C', 'vidhyac@example.com', 'DEF', 2),
('T123456789005', 'Sundar', 'L', 'sundarl@example.com', 'DEF', 2),
('T123456789006', 'Jyothi', 'Kumar', 'jyothik@example.com', 'DEF', 2),
('T123456789008', 'Shwetha', 'N', 'shwethan@example.com', 'DEF', 2);

INSERT INTO `supervisor_domains` (teacher_id, domain) VALUES
('T123456789000', 'Computer Vision'),
('T123456789000', 'Data Analytics'),
('T123456789002', 'Machine Learning'),
('T123456789002', 'Image Processing'),
('T123456789005', 'Machine Learning'),
('T123456789005', 'Natural Language Processing'),
('T123456789005', 'Cloud Computing'),
('T123456789006', 'AR/VR'),
('T123456789006', 'Image Processing'),
('T123456789006', 'Cloud Computing'),
('T123456789008', 'Natural Language Processing'),
('T123456789008', 'Data Analytics');

INSERT INTO `supervisor_years` (teacher_id, year) VALUES
('T123456789000', 2025),
('T123456789002', 2025),
('T123456789002', 2024),
('T123456789005', 2025),
('T123456789005', 2024),
('T123456789006', 2025),
('T123456789008', 2024);
