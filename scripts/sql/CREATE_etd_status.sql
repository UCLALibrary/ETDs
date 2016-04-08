-- ONLY DROP DURING TESTING!
-- drop table vger_support.etd_status purge;

create table vger_support.etd_status (
  proquest_id varchar2(10) not null
, status varchar2(20) not null
, status_date timestamp default systimestamp not null 
, message varchar2(200) null
, constraint pk_etd_status primary key (proquest_id, status_date)
)
;

grant select on vger_support.etd_status to ucla_preaddb, vger_report with grant option;

create index vger_support.ix_etd_status on vger_support.etd_status (proquest_id, status, status_date);

create or replace procedure vger_support.etd_status_add (
  p_proquest_id in etd_status.proquest_id%type
, p_status in etd_status.status%type
, p_message in etd_status.message%type := null
) as
-- vars
begin
  insert into vger_support.etd_status (proquest_id, status, message)
    values (p_proquest_id, p_status, p_message)
  ;
  -- Do an explicit commit here, instead of hoping/requiring the caller will.
  commit;
end etd_status_add;
/

