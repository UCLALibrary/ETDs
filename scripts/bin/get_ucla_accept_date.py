import requests
import sys
import xmltodict
from datetime import datetime

# QAD for now
grad_service_key = sys.argv[1]
proquest_id = sys.argv[2]

# SOAP request URL
url = "https://gd.commservices.grad.ucla.edu/GD.CommServices.ProquestFilerService.svc"

# structured XML
payload = f"""
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:tem="http://tempuri.org/">
<soap:Header xmlns:wsa="http://www.w3.org/2005/08/addressing">
   <wsa:To>https://gd.commservices.grad.ucla.edu/GD.CommServices.ProquestFilerService.svc</wsa:To>
   <wsa:Action>http://tempuri.org/IProquestFilerService/GetProquestFilerForProquestID</wsa:Action>
</soap:Header>
   <soap:Body>
      <tem:GetProquestFilerForProquestID>
         <tem:gdToken>{grad_service_key}</tem:gdToken>
         <tem:proquestID>{proquest_id}</tem:proquestID>
      </tem:GetProquestFilerForProquestID>
   </soap:Body>
</soap:Envelope>"""

# headers
headers = {"Content-Type": "application/soap+xml; charset=utf-8"}

# POST request
response = requests.request("POST", url, headers=headers, data=payload)

# Print the acceptance date, if any.
# If Grad Div has not accepted the dissertation, Message will not be Success,
# and the FileDate key will not exist.
if response.status_code == requests.codes.ok:
    # print(response.text)
    # Deeply nested SOAP-based XML
    xml = xmltodict.parse(response.text)
    data = dict(
        xml["s:Envelope"]["s:Body"]["GetProquestFilerForProquestIDResponse"][
            "GetProquestFilerForProquestIDResult"
        ]
    )
    status = data["b:Message"]
    if status == "Success":
        # This is a string, like "2022-12-09T00:00:00"
        acceptance_date = data["b:ProquestFiler"]["c:FileDate"]
        # Convert to "2022-12-09 00:00:00"
        acceptance_date = datetime.strptime(
            acceptance_date, "%Y-%m-%dT00:00:00"
        ).strftime("%Y-%m-%d %X")
        print(acceptance_date)
else:
    # This should happen only if the service is broken / unreachable.
    response.raise_for_status()
