
SOAP request

``` xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:hw4="http://hw4/">
   <soapenv:Header>
      <tweak divisibilityFactor="3" xmlns="http://tweaks.com/"/>
   </soapenv:Header>
   <soapenv:Body>
      <hw4:generateETicket>
         <arg0>21</arg0>
      </hw4:generateETicket>
   </soapenv:Body>
</soapenv:Envelope>
```

pošle `http://localhost:8080/Iter/ServletTest`

Intermediary získa `divisibilityFactor`, pošle zbytok requestu do `ETicketService`, čo vygeneruje ETicket objekt

Zoberie ticket a ID vynásobí - aby bolo ID delitelné daným číslom...

``` java
QName generateETicketResponseName = new QName("http://hw4/", "generateETicketResponse", "ns2");
QName returnName = new QName("return");
QName ticketIdName = new QName("id");

SOAPBodyElement generateETicketResponse = (SOAPBodyElement) responseBody.getChildElements(generateETicketResponseName).next();
SOAPBodyElement returnElement = (SOAPBodyElement) generateETicketResponse.getChildElements(returnName).next();
SOAPElement ticketIdElement = (SOAPElement) returnElement.getChildElements(ticketIdName).next();

int ticketId = Integer.parseInt(ticketIdElement.getTextContent());
int modifiedTicketId = ticketId * divisionFactor;

ticketIdElement.setTextContent(String.valueOf(modifiedTicketId));

```

pridá Header

``` java
SOAPElement tweakedHeader = newHeader.addChildElement("tweaked", "tweaks", tweakNamespace);
tweakedHeader.setTextContent("ID divisible by: " + divisionFactor);

```

a vráti response 

``` xml

<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Header xmlns:tweaks="http://tweaks.com/">
      <tweaks:tweaked>ID divisible by: 3</tweaks:tweaked>
   </S:Header>
   <S:Body>
      <ns2:generateETicketResponse xmlns:ns2="http://hw4/">
         <return>
            <id>1848</id>
            <date>2025-03-13T17:37:40.415+01:00</date>
            <athleteId>21</athleteId>
         </return>
      </ns2:generateETicketResponse>
   </S:Body>
</S:Envelope>

```