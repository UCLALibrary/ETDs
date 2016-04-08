/*  Support linking etd metadata to Voyager bib records.
*/

-- Create view of relevant Voyager data.
create or replace view vger_support.etd_voyager_vw as
with bibs as (
  select
    bib_id
  , replace(normal_heading, 'PQEXTID ', '') as proquest_id
  from ucladb.bib_index
  where index_code = '0359' 
  and normal_heading like 'PQEXTID%'
)
select
  b.bib_id
, b.proquest_id
, bm.create_date
-- slight chance this human-entered data will be invalid when converted to date
, (select to_date(min(subfield), 'YYYYMMDD') from vger_subfields.ucladb_bib_subfield where record_id = b.bib_id and tag = '948c') as cataloged_date
, case
    when exists (select * from vger_subfields.ucladb_bib_subfield where record_id = b.bib_id and tag like '948%')
    then 'CATALOGED'
    else null
  end as is_cataloged
from bibs b
inner join ucladb.bib_master bm on b.bib_id = bm.bib_id
;

grant select on vger_support.etd_voyager_vw to ucla_preaddb;

