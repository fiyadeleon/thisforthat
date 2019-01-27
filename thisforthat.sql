BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `tblBlueberryCheesecake` (
	`_id`	INTEGER,
	`name`	INTEGER,
	`amount`	INTEGER,
	`selected`	INTEGER DEFAULT 0,
	PRIMARY KEY(`_id`)
);
INSERT INTO `tblBlueberryCheesecake` VALUES (1,'Graham Cracker Crumbs','1 cup',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (2,'White Sugar','14 tablespoon',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (3,'Melted Butter','1/4 cup',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (4,'Cornstarch','1 tablespoon',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (5,'Cream Cheese','8 ounces',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (6,'Sour Cream','1 cup',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (7,'Vanilla Extract','1 teaspoon',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (8,'All-Purpose Flour','2 tablespoon',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (9,'Egg','4 pieces',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (10,'Frozen Blueberries','2 cups',0);
INSERT INTO `tblBlueberryCheesecake` VALUES (11,'Blueberry Jelly','1/3 cup',0);
CREATE TABLE IF NOT EXISTS `tblBlackForest` (
	`_id`	INTEGER,
	`name`	INTEGER,
	`amount`	INTEGER,
	`selected`	INTEGER DEFAULT 0,
	PRIMARY KEY(`_id`)
);
INSERT INTO `tblBlackForest` VALUES (1,'Milk','1 cup',0);
INSERT INTO `tblBlackForest` VALUES (2,'Vinegar','1 tablespoon',0);
INSERT INTO `tblBlackForest` VALUES (3,'All-Purpose Flour','1 3/4 cups',0);
INSERT INTO `tblBlackForest` VALUES (4,'White Sugar','2 cups',0);
INSERT INTO `tblBlackForest` VALUES (5,'Unsweetened Cocoa Powder','3/4 cup',0);
INSERT INTO `tblBlackForest` VALUES (6,'Baking Powder','1 teaspoon',0);
INSERT INTO `tblBlackForest` VALUES (7,'Baking Soda','2 teaspoons',0);
INSERT INTO `tblBlackForest` VALUES (8,'Salt','1/2 teaspoon',0);
INSERT INTO `tblBlackForest` VALUES (9,'Egg','2 pieces',0);
INSERT INTO `tblBlackForest` VALUES (10,'Vegetable Oil','1/2 cup',0);
INSERT INTO `tblBlackForest` VALUES (11,'Brewed Coffee','1 cup',0);
INSERT INTO `tblBlackForest` VALUES (12,'Vanilla Extract','1 teaspoon',0);
INSERT INTO `tblBlackForest` VALUES (13,'Cherry Pie Filling','1 can',0);
INSERT INTO `tblBlackForest` VALUES (14,'Cherry Liqueur','1/2 cup',0);
COMMIT;
