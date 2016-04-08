-- ONLY DROP DURING TESTING!
-- drop table vger_support.etd_metadata purge;

create table vger_support.etd_metadata (
  proquest_id varchar2(10) not null
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
, constraint pk_etd_metadata primary key (proquest_id)
)
;

grant select on vger_support.etd_metadata to ucla_preaddb, vger_report with grant option;

create index vger_support.ix_etd_metadata_bib_id on vger_support.etd_metadata (bib_id, proquest_id);

create or replace procedure vger_support.etd_ucla_dates_add (
  p_proquest_id in etd_metadata.proquest_id%type
, p_ucla_accept_date in etd_metadata.ucla_accept_date%type
, p_ucla_release_date in etd_metadata.ucla_release_date%type
) as
begin
  update vger_support.etd_metadata set
    ucla_accept_date = p_ucla_accept_date
  , ucla_release_date = p_ucla_release_date
  where proquest_id = p_proquest_id
  ;
  -- Do an explicit commit here, instead of hoping/requiring the caller will.
  commit;
end etd_ucla_dates_add;
/

create or replace procedure vger_support.etd_bib_id_add (
  p_proquest_id in etd_metadata.proquest_id%type
, p_bib_id in etd_metadata.bib_id%type
) as
begin
  update vger_support.etd_metadata set
    bib_id = p_bib_id
  where proquest_id = p_proquest_id
  ;
  -- Do an explicit commit here, instead of hoping/requiring the caller will.
  commit;
end etd_bib_id_add;
/

