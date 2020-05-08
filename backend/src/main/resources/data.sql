insert into weeks VALUES
    (null, '2020-05-04', '2020-05-08'),
    (null, '2020-05-11', '2020-05-15'),
    (null, '2020-05-18', '2020-05-22'),
    (null, '2020-05-25', '2020-05-29'),
    (null, '2020-06-01', '2020-06-05'),
    (null, '2020-06-08', '2020-06-12');

INSERT INTO days VALUES
    (null, '2020-05-04', 1),
    (null, '2020-05-05', 1),
    (null, '2020-05-06', 1),
    (null, '2020-05-07', 1),
    (null, '2020-05-08', 1);

INSERT INTO slot_templates VALUES
    (null, '11:30:00','12:00:00', 5),
    (null, '12:15:00','12:45:00', 5),
    (null, '13:00:00','13:30:00', 5);
    
INSERT INTO slots VALUES
    (null, 1, 1),
    (null, 2, 1),
    (null, 3, 1),
    (null, 1, 2),
    (null, 2, 2),
    (null, 3, 2),
    (null, 1, 3),
    (null, 2, 3),
    (null, 3, 3),
    (null, 1, 4),
    (null, 2, 4),
    (null, 3, 4),
    (null, 1, 5),
    (null, 2, 5),
    (null, 3, 5);

INSERT INTO menu VALUES
    (null, 'Menu 1'),
    (null, 'Menu 2');

INSERT INTO reservations VALUES
    (null, 'Mark Zuckerberg', 13, 1),
    (null, 'Larry Ellison', 14, 1),
    (null, 'Pavel Durov', 15, 2),
    (null, 'Jeff Bezos', 15, 1),
    (null, 'Sergei Brin', 15, 1),
    (null, 'Ilya Segalovich', 15, 1);
