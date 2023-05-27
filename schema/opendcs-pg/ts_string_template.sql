--
-- This file is extracted manually from opendcs.sql, which is generated by ERM.
--
-- A shell script expands this template by copying it and renaming the 0000
-- suffix with however many files the user has selected.
-- Note that tables 0000 are created by the opendcs.sql

CREATE TABLE TS_STRING_<TableNumber>
(
	TS_ID INT NOT NULL,
	SAMPLE_TIME BIGINT NOT NULL,
	TS_VALUE VARCHAR(64) NOT NULL,
	FLAGS BIGINT NOT NULL,
	SOURCE_ID INT NOT NULL,
	DATA_ENTRY_TIME BIGINT NOT NULL,
	PRIMARY KEY (TS_ID, SAMPLE_TIME)
) WITHOUT OIDS;

ALTER TABLE TS_STRING_<TableNumber>
	ADD FOREIGN KEY (SOURCE_ID)
	REFERENCES TSDB_DATA_SOURCE (SOURCE_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE TS_STRING_<TableNumber>
	ADD FOREIGN KEY (TS_ID)
	REFERENCES TS_SPEC (TS_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

CREATE INDEX TS_STRING_<TableNumber>_ENTRY_IDX 
	ON TS_STRING_0000(DATA_ENTRY_TIME);
