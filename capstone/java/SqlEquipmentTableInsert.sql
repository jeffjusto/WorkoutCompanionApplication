CREATE TABLE equipment
(
equipment_id serial,
equipment_name varChar(50),
description varChar(1000),
img_src varChar(1000),

CONSTRAINT PK_equipment PRIMARY KEY (equipmentId)
);
