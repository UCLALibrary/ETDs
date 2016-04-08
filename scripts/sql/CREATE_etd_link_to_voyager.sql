create or replace procedure vger_support.etd_link_to_voyager as
begin
/*  For phase 3 script, after loading new CDL MARC records:
  * Update etd_metadata.bib_id
  * Update etd_status with CDL_MARC_LOADED status for new records from CDL
  * Update etd_status with CATALOGED status for any newly-cataloged records (most updates will have none, as these are via daily OCLC load)
*/

--  * Update etd_metadata.bib_id
update vger_support.etd_metadata em
set bib_id = (
  select min(bib_id) -- in case of duplicates, unlikely but possible
  from vger_support.etd_voyager_vw
  where proquest_id = em.proquest_id
)
where em.bib_id is null
and exists (
  select *
  from vger_support.etd_voyager_vw
  where proquest_id = em.proquest_id
)
;

-- * Update etd_status with CDL_MARC_LOADED status for new records from CDL which are not yet cataloged
insert into vger_support.etd_status
select
  proquest_id
, 'CDL_MARC_LOADED' as status
, create_date as status_date
, 'Loaded MARC record from CDL: bib id ' || bib_id as message
from vger_support.etd_voyager_vw v
where v.is_cataloged is null
and not exists (
  select *
  from vger_support.etd_status
  where proquest_id = v.proquest_id
  and status = 'CDL_MARC_LOADED'
)
;

--  * Update etd_status with CATALOGED status for any newly-cataloged records (most updates will have none, as these are via daily OCLC load)
insert into vger_support.etd_status
select
  proquest_id
, 'CATALOGED' as status
, cataloged_date as status_date
, 'Cataloged MARC record: bib id ' || bib_id as message
from vger_support.etd_voyager_vw v
where v.is_cataloged = 'CATALOGED'
and not exists (
  select *
  from vger_support.etd_status
  where proquest_id = v.proquest_id
  and status = 'CATALOGED'
)
;
commit;

end etd_link_to_voyager;
/

