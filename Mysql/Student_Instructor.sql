
create database student_exam;
use student_exam;
create table Student(
	StudentId int primary key,
    Name varchar(255),
    Program varchar(50)
);

create table CourseOffering(
	OfferingId int primary key,
    CourseNumber int,
    Year int,
    Semester varchar(20),
    Room varchar(10),
    Timing varchar(20)
);

create table Exam(
	ExamId int primary key,
    ExamName varchar(255),
    Timing varchar(20),
    place varchar(100)
);

create Table ExamResult(
	ResultId int primary key,
    StudentId int,
    OfferingId int,
    ExamId int,
    Marks decimal(5,2),
    foreign key (StudentId) references Student(StudentId),
    foreign key (OfferingId) references CourseOffering(OfferingId),
    foreign key (ExamId) references Exam(ExamId)
);

alter table ExamResult add unique (StudentId, OfferingId);
    