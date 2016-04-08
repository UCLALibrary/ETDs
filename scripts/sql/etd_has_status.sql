-- Parameters from caller:
-- &1: ProQuest id (required)
-- &2: Status (required)

set linesize 5;

select
  case when count(*) = 0 then 'false' else 'true' end as has_status
from vger_support.etd_status
where proquest_id = '&1'
and status = '&2'
;

