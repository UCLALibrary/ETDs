-- Updates etd_metadata for given ProQuest ID to add UCLA-specific dates.
-- Parameters from caller:
-- &1: ProQuest id (required)
-- &2: UCLA acceptance date (required)
-- &3: UCLA release date (required)

exec vger_support.etd_ucla_dates_add ('&1', to_date('&2', 'YYYY-MM-DD HH24:MI:SS'), to_date('&3', 'YYYY-MM-DD HH24:MI:SS'));

