DROP TABLE IF EXISTS weeks;
CREATE TABLE weeks
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `start` date    NOT NULL,
    `end`   date    NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS days;
CREATE TABLE days
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `date`    date    NOT NULL,
    `week_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (week_id) REFERENCES weeks (id)
);

DROP TABLE IF EXISTS slot_templates;
CREATE TABLE slot_templates
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `start`    time    NOT NULL,
    `end`      time    NOT NULL,
    `capacity` int(3)  NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS slots;
CREATE TABLE slots
(
    `id`               int(11) NOT NULL AUTO_INCREMENT,
    `slot_template_id` int(11) NOT NULL,
    `day_id`           int(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (day_id) REFERENCES days (id),
    FOREIGN KEY (slot_template_id) REFERENCES slot_templates (id)

);

DROP TABLE IF EXISTS menu;
CREATE TABLE menu
(
    `id`   int(11)     NOT NULL AUTO_INCREMENT,
    `name` varchar(80) NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS reservations;
CREATE TABLE reservations
(
    `id`       int(11)     NOT NULL AUTO_INCREMENT,
    `username` varchar(80) NOT NULL,
    `slot_id`  int(11)     NOT NULL,
    `menu_id`  int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (slot_id) REFERENCES slots (id),
    FOREIGN KEY (menu_id) REFERENCES menu (id),
    CONSTRAINT reservation UNIQUE (username, slot_id)
);
