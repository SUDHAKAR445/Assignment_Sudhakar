create database student;
use student;
create table course (
    name varchar(255) primary key,
    department varchar(255),
    course_number int
);
create table section (
    section_number int primary key,
    enrollment int,
    course_name varchar(255),
    foreign key (course_name) references course(name)
);
create table room (
    room_number int primary key,
    capacity int,
    `block` varchar(255)
);
create table exam (
    exam_id int primary key,
    exam_name varchar(255),
    date date,
    time datetime
);
create table student (
    student_id int primary key,
    student_name varchar(255),
    department varchar(255)
);
create table instructor (
    instructor_id int primary key,
    instructor_name varchar(255)
);
create table exam_section (
    exam_id int,
    section_number int,
    room_number int,
    foreign key (exam_id) references exam(exam_id),
    foreign key (section_number) references section(section_number),
    foreign key (room_number) references room(room_number)
);
create table enrollment (
    student_id int,
    section_number int,
    foreign key (student_id) references student(student_id),
    foreign key (section_number) references section(section_number)
);
create table teaching (
    instructor_id int,
    section_number int,
    foreign key (instructor_id) references instructor(instructor_id),
    foreign key (section_number) references section(section_number)
);
create table exam_result (
    result_id int primary key,
    exam_id int,
    student_id int,
    score decimal(5, 2),
    foreign key (exam_id) references exam(exam_id),
    foreign key (student_id) references student(student_id)
);

