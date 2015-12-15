/* 生徒 */
create table student (
    student_code  int(5),
    club_code  int(5),
    student_name  varchar(30),
    primary key( student_code )
);

/* 部活 */
create table club (
    club_code  int(5),
    club_name  varchar(30),
    primary key( club_code )
);

