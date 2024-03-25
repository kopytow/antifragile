INSERT INTO users (email, password) VALUES
('vyacheslav1963@mail.ru', 'F_H4IGqM8A'),
('darya18@ya.ru', 'Su_vO4SpeC'),
('vera15041962@gmail.com', 'p8e-Dpg8qU'),
('zoya1985@hotmail.com', 'm-4jAqLW0K'),
('svetlana.nikolina@rambler.ru', '3QWb_pgEMY');

INSERT INTO persons (personal_data_processing_consent, users_pkey, phone, first_name, last_name, nickname) VALUES
(false, 1, '+7 (920) 566-84-75', 'Вячеслав', 'Милюков', 'vinipuh'),
(false, 2, '+7 (905) 988-91-65', 'Дарья', 'Абрамова', 'coty'),
(false, 3, '+7 (933) 326-88-54', 'Вера', 'Базина', 'manital'),
(false, 4, '+7 (922) 681-53-53', 'Зоя', 'Азаренкова', 'zazalta'),
(false, 5, '+7 (924) 383-92-18', 'Светлана', 'Николина', 'ceciliam');

INSERT INTO exams (grade, time_keeping, exam_date, persons_pkey) VALUES
(68, '00:17:06', '2024-01-26 00:47:06.405', 1),
(90, '00:15:06', '2024-01-15 00:47:06.405', 2),
(73, '00:19:06', '2024-02-15 00:47:06.405', 3),
(54, '00:11:06', '2024-02-05 00:47:06.405', 4),
(49, '00:17:06', '2024-03-05 00:47:06.405', 5);