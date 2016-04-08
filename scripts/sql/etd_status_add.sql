-- Adds a row to the etd_status table.
-- Parameters from caller:
-- &1: ProQuest id (required)
-- &2: Status (required)
-- &3: Message (optional)

exec vger_support.etd_status_add ('&1', '&2', '&3');

