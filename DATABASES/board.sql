drop table tbl_board;
drop table tbl_board_type;

create table tbl_board_type(
    board_type varchar2(20) primary key,
    boare_name varchar2(20),
    board_order number(11,0)
);
create table tbl_board(
    board_index number(22,0) primary key,
    board_title varchar2(100),
    board_content varchar2(255),
    board_writer varchar2(100),
    board_viewcount number(11,0),
    board_reg_date date,
    board_update_date date,
    board_type varchar2(20),
    CONSTRAINT board_type_fk foreign key (board_type) references tbl_board_type(board_type) on delete cascade
);
create table tbl_board_attach(
    save_file_name varchar2(255) primary key,
    real_file_name varchar2(255),
    reg_date date,
    board_index number(22,0),
    CONSTRAINT board_index_fk foreign key(board_index) references tbl_board(board_index) on delete cascade
);
create table tbl_board_reply(
    reply_index number(22,0) primary key,
    reply_content varchar2(255),
    reply_writer varchar2(100),
    reg_date date,
    update_date date,
    board_index number(22,0),
    CONSTRAINT board_index_reply_fk foreign key(board_index) REFERENCES tbl_board(board_index) on delete cascade
);