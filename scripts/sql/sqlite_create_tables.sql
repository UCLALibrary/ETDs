create table etd_metadata (
  proquest_id varchar2(10) not null primary key
, etd_filename varchar2(40) not null
, etd_filedate date not null
, author_surname varchar2(25) null
, author_firstname varchar2(25) null
, title varchar2(300) not null
, degree varchar2(20) null
, institutional_contact varchar2(75) null
, category varchar2(50) null
, proquest_accept_date date not null
, embargo_code int not null
, agreement_decision_date date null
, sales_restriction_date date null
, delayed_release_date date null
, ucla_accept_date date null
, ucla_release_date date null
, bib_id int null
)
;

create table etd_status (
  proquest_id varchar2(10) not null
, status varchar2(20) not null
, status_date timestamp default (datetime(CURRENT_TIMESTAMP, 'localtime')) not null 
, message varchar2(200) null
, constraint pk_etd_status primary key (proquest_id, status_date)
)
;