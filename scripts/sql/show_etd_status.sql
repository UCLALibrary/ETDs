-- Parameters from caller:
-- &1: ProQuest id (required)

set linesize 130
col proquest_id format a8
col status format a20
col status_date format a25
col message format a65

select 
  proquest_id
, to_char(status_date, 'YYYY-MM-DD HH24:MI:SS.ff2') as status_date
, status
, message
from etd_status
where proquest_id = '&1'
order by proquest_id, status_date;
