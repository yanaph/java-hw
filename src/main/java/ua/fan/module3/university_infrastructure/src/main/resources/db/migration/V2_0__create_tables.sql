create TABLE IF NOT EXISTS Discipline(
  id VARCHAR(255) NOT NULL,
   codeName INTEGER NOT NULL,
   professor_id VARCHAR(255),
   CONSTRAINT pk_discipline PRIMARY KEY (id)
);

create TABLE IF NOT EXISTS Grade (
  id VARCHAR(255) NOT NULL,
   value INTEGER,
   student_id VARCHAR(255),
   discipline_id VARCHAR(255),
   CONSTRAINT pk_grade PRIMARY KEY (id)
);

create TABLE IF NOT EXISTS Professor (
  id VARCHAR(255) NOT NULL,
   firstName VARCHAR(255),
   lastName VARCHAR(255),
   age INTEGER,
   discipline_id VARCHAR(255),
   CONSTRAINT pk_professor PRIMARY KEY (id)
);

create TABLE IF NOT EXISTS Student (
  id VARCHAR(255) NOT NULL,
   firstName VARCHAR(255),
   lastName VARCHAR(255),
   age INTEGER,
   admissionDate date,
   studyGroup_id VARCHAR(255),
   CONSTRAINT pk_student PRIMARY KEY (id)
);

create TABLE IF NOT EXISTS StudyGroup (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_studygroup PRIMARY KEY (id)
);

alter table Discipline add CONSTRAINT FK_DISCIPLINE_ON_PROFESSOR FOREIGN KEY (professor_id) REFERENCES Professor (id);

alter table Grade add CONSTRAINT FK_GRADE_ON_DISCIPLINE FOREIGN KEY (discipline_id) REFERENCES Discipline (id);

alter table Grade add CONSTRAINT FK_GRADE_ON_STUDENT FOREIGN KEY (student_id) REFERENCES Student (id);

alter table Professor add CONSTRAINT FK_PROFESSOR_ON_DISCIPLINE FOREIGN KEY (discipline_id) REFERENCES Discipline (id);

alter table Student add CONSTRAINT FK_STUDENT_ON_STUDYGROUP FOREIGN KEY (studyGroup_id) REFERENCES StudyGroup (id);