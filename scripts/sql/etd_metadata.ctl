LOAD DATA
APPEND
INTO TABLE vger_support.etd_metadata
FIELDS TERMINATED BY x'09'
TRAILING NULLCOLS
(
  proquest_id
, etd_filename
, etd_filedate DATE "YYYY-MM-DD"
, author_surname "substr(:author_surname, 1, 25)"
, author_firstname "substr(:author_firstname, 1, 25)"
, title CHAR(300) "substr(:title, 1, 300)"
, degree "substr(:degree, 1, 20)"
, institutional_contact "substr(:institutional_contact, 1, 75)"
, category "substr(:category, 1, 50)"
, proquest_accept_date DATE "MM/DD/YYYY"
, embargo_code
, agreement_decision_date DATE "YYYY-MM-DD HH24:MI:SS"
, sales_restriction_date DATE "MM/DD/YYYY"
, delayed_release_date DATE "YYYY-MM-DD HH24:MI:SS"
, ucla_accept_date DATE "YYYY-MM-DD HH24:MI:SS"
)
