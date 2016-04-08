-- Parameters from caller:
-- &1: Status (required)

set linesize 10;

select
  proquest_id
from vger_support.etd_status s
where status = '&1'
and status_date = (
  select max(status_date)
  from vger_support.etd_status
  where proquest_id = s.proquest_id
)
order by proquest_id
;

