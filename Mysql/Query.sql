
create database STUDENT_INSTRUCTOR_DB;
use STUDENT_INSTRUCTOR_DB;

create table Student(
	StudentId INT primary key,
    Name varchar(255),
    Program varchar(100)
);

create table Instructor(
	InstructorId int primary key,
    Name varchar(255),
    Department varchar(100),
    Title varchar(100)
);

create table Course(
	CourseNumber int primary key,
    Title varchar(255),
    Credits int,
    Syllabus text
);

create table Prerequisite(
	PrerequisiteId int auto_increment primary key,
    CourseNumber int,
    foreign key (CourseNumber) references Course(CourseNumber)
);

create table CourseOffering(
	OfferingId int auto_increment primary key,
    CourseNumber int,
    Year int,
    Semester varchar(20),
    SectionNumber int,
    Classroom varchar(50),
    Timings varchar(100),
    foreign key (CourseNumber) references Course(CourseNumber)
);

create table Enrollment(
	EnrollmentId int auto_increment primary key,
    StudentId int,
    OfferingId int,
    foreign key (StudentId) references Student(StudentId),
    foreign key (OfferingId) references CourseOffering(OfferingId)
);

create table Grade(
	GradeId int auto_increment primary key,
    EnrollmentId int,
    Grade varchar(2),
    foreign key (EnrollmentId) references Enrollment(EnrollmentId)
);

