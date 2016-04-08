LOAD DATA
APPEND
INTO TABLE vger_support.etd_metadata
FIELDS TERMINATED BY x'09'
TRAILING NULLCOLS
(
  proquest_id
, etd_filename
, etd_filedate DATE "YYYY-MM-DD"
, author_surname
, author_firstname
, title CHAR(300) "substr(:title, 1, 300)"
, degree
, institutional_contact
, category
, proquest_accept_date DATE "MM/DD/YYYY"
, embargo_code
, agreement_decision_date DATE "YYYY-MM-DD HH24:MI:SS"
, sales_restriction_date DATE "MM/DD/YYYY"
, delayed_release_date DATE "YYYY-MM-DD HH24:MI:SS"
, ucla_accept_date DATE "YYYY-MM-DD HH24:MI:SS"
)
