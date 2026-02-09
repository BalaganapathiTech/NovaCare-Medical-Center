create database nova_care;
use nova_care;

show databases;

select * from appointment;
select * from patient;
select * from doctor;
select * from nova_care.doctor;
delete from nova_care.doctor where doctor_id=4;
select * from nova_care.patient;
select * from nova_care.appointment;
delete from nova_care.appointment where appointment_id=5;
use nova_care;
DESCRIBE appointment;
ALTER TABLE appointment DROP PRIMARY KEY;

drop table nova_care;
DROP TABLE appointment;
select * from nova_care.appointment;
ALTER TABLE appointment DROP COLUMN patient_id;

ALTER TABLE appointment DROP COLUMN patient_id;
ALTER TABLE appointment ADD COLUMN patient_id BIGINT;

use nova_care;
select * from nova_care.prescription;
describe prescription;

alter table prescription
modify medicines varchar(255); 
select * from nova_care.medical_history;
select * from nova_care.appointment;
describe appointment;
select * from nova_care.doctor;
select * from nova_care.prescription;
use nova_care;
describe nova_care;
select * from nova_care.doctor;
select * from nova_care.patient;


show databases;
use nova_care;
show tables;
describe patient;
drop table consultation;

CREATE TABLE consultation (
    consultation_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    consultation_date DATE NOT NULL,
    diagnosis VARCHAR(255),
    doctor_id INT,
    patient_id INT,
    prescription TEXT,
    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);

ALTER TABLE consultation MODIFY patient_id BIGINT;

CREATE TABLE consultation (
    consultation_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    consultation_date DATE NOT NULL,
    diagnosis VARCHAR(255),
    doctor_id INT,
    patient_id BIGINT, 
    prescription TEXT,
    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);
ALTER TABLE patient MODIFY patient_id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE consultation MODIFY patient_id BIGINT;

select * from nova_care.patient;
select * from nova_care.consultation;

ALTER TABLE consultation MODIFY patient_id BIGINT;
ALTER TABLE patient MODIFY patient_id BIGINT;


SHOW CREATE TABLE appointment;

ALTER TABLE patient MODIFY patient_id BIGINT;

DESCRIBE doctor;
DESCRIBE consultation;

ALTER TABLE consultation MODIFY doctor_id BIGINT;

SHOW CREATE TABLE consultation;
ALTER TABLE consultation DROP FOREIGN KEY consultation_ibfk_1;

ALTER TABLE doctor MODIFY doctor_id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE consultation MODIFY doctor_id BIGINT;

ALTER TABLE consultation
ADD CONSTRAINT consultation_ibfk_1 FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id);


describe patient;
SHOW CREATE TABLE patient;
-- patient_id bigint NOT NULL AUTO_INCREMENT



SELECT patient_id, address, dob, email, login_password, mobile_no, patient_name, sex 
FROM patient 
WHERE patient_id = 34;  -- Replace with a valid patient_id

select * from nova_care.doctor;

show tables;

select * from nova_care.consultation;

drop table consultation;

create database nova;

select * from nova.doctor;
describe patient;

use nova;